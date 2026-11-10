package com.iamhuitron.rutinaoptima;

import android.Manifest;
import android.app.Activity;
import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        RoutineNotificationHelper.createNotificationChannel(this);
        requestNotificationPermissionIfNeeded();

        if (RoutineNotificationHelper.areAlarmsEnabled(this)) {
            RoutineNotificationHelper.scheduleAllAlarms(this);
        }
        RoutineWidgetProvider.updateAllWidgets(this);

        webView = new WebView(this);
        webView.setBackgroundColor(0xFF0D0C0A);

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setCacheMode(WebSettings.LOAD_DEFAULT);

        webView.addJavascriptInterface(new AndroidBridge(), "AndroidBridge");
        webView.setWebViewClient(new WebViewClient());

        setContentView(webView);
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    protected void onResume() {
        super.onResume();
        RoutineWidgetProvider.updateAllWidgets(this);
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    private void requestNotificationPermissionIfNeeded() {
        if (Build.VERSION.SDK_INT >= 33) {
            if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 101);
            }
        }
    }

    public class AndroidBridge {

        @JavascriptInterface
        public void testNotification() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    RoutineNotificationHelper.triggerImmediateStatusNotification(MainActivity.this);
                    Toast.makeText(MainActivity.this, "📲 Notificación enviada a tu Galaxy S23", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public void pinOrSyncWidget() {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    RoutineWidgetProvider.updateAllWidgets(MainActivity.this);
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        AppWidgetManager manager = AppWidgetManager.getInstance(MainActivity.this);
                        ComponentName provider = new ComponentName(MainActivity.this, RoutineWidgetProvider.class);
                        int[] ids = manager.getAppWidgetIds(provider);
                        if ((ids == null || ids.length == 0) && manager.isRequestPinAppWidgetSupported()) {
                            manager.requestPinAppWidget(provider, null, null);
                            return;
                        }
                    }
                    Toast.makeText(MainActivity.this, "🧩 Widget actualizado con tu bloque actual", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public boolean toggleAlarms() {
            final boolean nextState = !RoutineNotificationHelper.areAlarmsEnabled(MainActivity.this);
            RoutineNotificationHelper.setAlarmsEnabled(MainActivity.this, nextState);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    String msg = nextState ? "🔔 Alarmas automáticas activadas (68 bloques/sem)" : "🔕 Alarmas automáticas pausadas";
                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                }
            });
            return nextState;
        }

        @JavascriptInterface
        public boolean areAlarmsEnabled() {
            return RoutineNotificationHelper.areAlarmsEnabled(MainActivity.this);
        }
    }
}
