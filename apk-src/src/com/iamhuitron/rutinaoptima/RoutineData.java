package com.iamhuitron.rutinaoptima;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class RoutineData {

    public static class Block {
        public final int id;
        public final int dayOfWeek;
        public final String dayTitle;
        public final String timeRange;
        public final int startHour;
        public final int startMin;
        public final int endHour;
        public final int endMin;
        public final String title;
        public final String badge;
        public final String icon;
        public final String description;

        public Block(int id, int dayOfWeek, String dayTitle, String timeRange,
                     int startHour, int startMin, int endHour, int endMin,
                     String title, String badge, String icon, String description) {
            this.id = id;
            this.dayOfWeek = dayOfWeek;
            this.dayTitle = dayTitle;
            this.timeRange = timeRange;
            this.startHour = startHour;
            this.startMin = startMin;
            this.endHour = endHour;
            this.endMin = endMin;
            this.title = title;
            this.badge = badge;
            this.icon = icon;
            this.description = description;
        }

        public int getStartMinutes() {
            return startHour * 60 + startMin;
        }

        public int getEndMinutes() {
            int s = getStartMinutes();
            int e = endHour * 60 + endMin;
            return (e <= s) ? (endHour + 24) * 60 + endMin : e;
        }
    }

    public static class ActiveStatus {
        public final String dayTitle;
        public final Block current;
        public final Block next;
        public final int progressPercent;
        public final int minutesRemaining;

        public ActiveStatus(String dayTitle, Block current, Block next, int progressPercent, int minutesRemaining) {
            this.dayTitle = dayTitle;
            this.current = current;
            this.next = next;
            this.progressPercent = progressPercent;
            this.minutesRemaining = minutesRemaining;
        }
    }

    public static List<Block> getAllBlocks() {
        List<Block> list = new ArrayList<>();

        // LUNES
        list.add(new Block(101, Calendar.MONDAY, "Lunes", "06:45 – 07:00", 6, 45, 7, 0, "Despertar, Hidratación & Descompresión", "HGH & Sueño", "🌅", "Agua con pizca de sal. 2 min colgado en barra para descomprimir discos intervertebrales."));
        list.add(new Block(102, Calendar.MONDAY, "Lunes", "07:00 – 07:45", 7, 0, 7, 45, "Entrenamiento V-Taper (Pecho & Espalda)", "Físico & Gym", "🏋️", "Flexiones declinadas, dominadas/remos invertidos, flexiones con déficit."));
        list.add(new Block(103, Calendar.MONDAY, "Lunes", "07:45 – 08:30", 7, 45, 8, 30, "Ducha fresca, Skincare & Desayuno Anabólico", "Comida & Aseo", "🚿", "4 huevos, avena o fruta, café negro. Limpieza facial y protector solar."));
        list.add(new Block(104, Calendar.MONDAY, "Lunes", "08:30 – 11:30", 8, 30, 11, 30, "Trabajo Remoto (Bloque 1 de 3h)", "Trabajo Remoto", "💼", "3 horas de concentración laboral temprana. Cumpliendo métricas semanales."));
        list.add(new Block(105, Calendar.MONDAY, "Lunes", "11:30 – 12:00", 11, 30, 12, 0, "Almuerzo en casa & Alistar Mochila", "Comida & Aseo", "🍽️", "Comida completa previa al viaje y empaque de snacks para la uni."));
        list.add(new Block(106, Calendar.MONDAY, "Lunes", "12:00 – 14:00", 12, 0, 14, 0, "Traslado de Ida (2h) — Modo Lectura", "Traslado / Lectura", "📖", "Lectura activa en Kindle/físico (45–60 min). ~30 libros al año."));
        list.add(new Block(107, Calendar.MONDAY, "Lunes", "14:00 – 20:00", 14, 0, 20, 0, "Universidad (Clases + Biblioteca)", "Universidad", "🏛️", "14h: Inglés | 16h: Derecho | 18h: Mate III | 19h: Prog III. En huecos (15h y 17h): tareas."));
        list.add(new Block(108, Calendar.MONDAY, "Lunes", "20:00 – 22:30", 20, 0, 22, 30, "Traslado de Regreso (2.5h) — Descompresión", "Traslado / Lectura", "🚌", "Música tranquila, podcast o siesta para descansar la vista."));
        list.add(new Block(109, Calendar.MONDAY, "Lunes", "22:30 – 23:15", 22, 30, 23, 15, "Cena Pro-HGH Ligera, Ducha & Descompresión", "Comida & Aseo", "🥗", "Proteína magra + vegetales (sin azúcar). Ducha templada y 2 min en barra."));
        list.add(new Block(110, Calendar.MONDAY, "Lunes", "23:15 – 06:45", 23, 15, 6, 45, "Sueño Profundo (7.5h) — Pico Somatropina", "HGH & Sueño", "💤", "Habitación fría y oscura. Máxima regeneración celular en fase N3."));

        // MARTES
        list.add(new Block(201, Calendar.TUESDAY, "Martes", "06:45 – 07:00", 6, 45, 7, 0, "Despertar & Descompresión Espinal", "HGH & Sueño", "🌅", "Hidratación celular inmediata y colgado en barra."));
        list.add(new Block(202, Calendar.TUESDAY, "Martes", "07:00 – 07:45", 7, 0, 7, 45, "Entrenamiento V-Taper (Hombros 3D & Brazos)", "Físico & Gym", "🏋️", "Pike push-ups, elevaciones laterales estrictas, fondos y stomach vacuum."));
        list.add(new Block(203, Calendar.TUESDAY, "Martes", "07:45 – 08:30", 7, 45, 8, 30, "Ducha, Skincare & Desayuno", "Comida & Aseo", "🚿", "Higiene matutina completa y carga de nutrientes esenciales."));
        list.add(new Block(204, Calendar.TUESDAY, "Martes", "08:30 – 11:30", 8, 30, 11, 30, "Trabajo Remoto (Bloque 2 de 3h)", "Trabajo Remoto", "💼", "3 horas de avance laboral remoto (6h acumuladas)."));
        list.add(new Block(205, Calendar.TUESDAY, "Martes", "11:30 – 12:30", 11, 30, 12, 30, "Proyectos Personales (1h de Código / Ideas)", "Proyectos", "💻", "Desarrollo propio, portafolio o arquitectura técnica."));
        list.add(new Block(206, Calendar.TUESDAY, "Martes", "12:30 – 13:00", 12, 30, 13, 0, "Almuerzo en casa & Salida", "Comida & Aseo", "🍽️", "Comida nutritiva antes de iniciar el trayecto (salida 13:00 para llegar 15:00)."));
        list.add(new Block(207, Calendar.TUESDAY, "Martes", "13:00 – 15:00", 13, 0, 15, 0, "Traslado de Ida (2h) — Lectura", "Traslado / Lectura", "📖", "Avanzar libro del mes o aprendizaje técnico en el transporte."));
        list.add(new Block(208, Calendar.TUESDAY, "Martes", "15:00 – 20:00", 15, 0, 20, 0, "Universidad (Sistemas Op, Metodología, Inf III)", "Universidad", "🏛️", "Aprovechar huecos de 16h y 18h para estudiar y dejar la tarde libre de tareas."));
        list.add(new Block(209, Calendar.TUESDAY, "Martes", "20:00 – 22:30", 20, 0, 22, 30, "Traslado de Regreso (2.5h)", "Traslado / Lectura", "🚌", "Desconexión progresiva para bajar cortisol y preparar la noche."));
        list.add(new Block(210, Calendar.TUESDAY, "Martes", "22:30 – 23:15", 22, 30, 23, 15, "Cena ligera, Ducha tibia & Skincare", "Comida & Aseo", "🥗", "Cena digestiva, limpieza facial y preparar mochila para el miércoles."));
        list.add(new Block(211, Calendar.TUESDAY, "Martes", "23:15 – 06:45", 23, 15, 6, 45, "Sueño Anabólico HGH (7.5h)", "HGH & Sueño", "💤", "Recuperación muscular completa y liberación hormonal profunda."));

        // MIÉRCOLES
        list.add(new Block(301, Calendar.WEDNESDAY, "Miércoles", "06:45 – 07:00", 6, 45, 7, 0, "Despertar, Hidratación & Estiramiento", "HGH & Sueño", "🌅", "Rehidratación y 2 min colgado en barra."));
        list.add(new Block(302, Calendar.WEDNESDAY, "Miércoles", "07:00 – 07:45", 7, 0, 7, 45, "Entrenamiento V-Taper (Pierna & Pliometría)", "Físico & Gym", "🏋️", "Sentadillas búlgaras, saltos explosivos, pantorrillas en escalón."));
        list.add(new Block(303, Calendar.WEDNESDAY, "Miércoles", "07:45 – 08:30", 7, 45, 8, 30, "Ducha, Grooming & Desayuno Alto en Proteína", "Comida & Aseo", "🚿", "Cuidado personal y combustible limpio."));
        list.add(new Block(304, Calendar.WEDNESDAY, "Miércoles", "08:30 – 11:30", 8, 30, 11, 30, "Trabajo Remoto (Bloque 3 de 3h)", "Trabajo Remoto", "💼", "Avance laboral consistente (9h acumuladas)."));
        list.add(new Block(305, Calendar.WEDNESDAY, "Miércoles", "11:30 – 12:00", 11, 30, 12, 0, "Almuerzo & Empaque", "Comida & Aseo", "🍽️", "Comida en casa y alistarse para la salida a las 12:00."));
        list.add(new Block(306, Calendar.WEDNESDAY, "Miércoles", "12:00 – 14:00", 12, 0, 14, 0, "Traslado de Ida (2h) — Lectura", "Traslado / Lectura", "📖", "Lectura activa en transporte."));
        list.add(new Block(307, Calendar.WEDNESDAY, "Miércoles", "14:00 – 20:00", 14, 0, 20, 0, "Universidad (Clases vespertinas)", "Universidad", "🏛️", "Inglés, Derecho, Matemáticas III, Programación III."));
        list.add(new Block(308, Calendar.WEDNESDAY, "Miércoles", "20:00 – 22:30", 20, 0, 22, 30, "Traslado Vuelta (2.5h)", "Traslado / Lectura", "🚌", "Audio relajante o descanso mental."));
        list.add(new Block(309, Calendar.WEDNESDAY, "Miércoles", "22:30 – 23:15", 22, 30, 23, 15, "Cena Ligera, Ducha & Preparación", "Comida & Aseo", "🥗", "Preparación nocturna sin pantallas estimulantes."));
        list.add(new Block(310, Calendar.WEDNESDAY, "Miércoles", "23:15 – 06:45", 23, 15, 6, 45, "Sueño Óptimo HGH (7.5h)", "HGH & Sueño", "💤", "Regeneración celular."));

        // JUEVES
        list.add(new Block(401, Calendar.THURSDAY, "Jueves", "06:45 – 07:00", 6, 45, 7, 0, "Despertar & Descompresión Espinal", "HGH & Sueño", "🌅", "Respiración profunda, colgado de barra."));
        list.add(new Block(402, Calendar.THURSDAY, "Jueves", "07:00 – 07:45", 7, 0, 7, 45, "Entrenamiento V-Taper (Torso Denso & Postura)", "Físico & Gym", "🏋️", "Remo unilateral con mochila, flexiones diamante, vuelos posteriores."));
        list.add(new Block(403, Calendar.THURSDAY, "Jueves", "07:45 – 08:30", 7, 45, 8, 30, "Ducha, Aseo & Desayuno", "Comida & Aseo", "🚿", "Aseo matutino y nutrición."));
        list.add(new Block(404, Calendar.THURSDAY, "Jueves", "08:30 – 11:30", 8, 30, 11, 30, "Trabajo Remoto (Bloque 4 de 3h)", "Trabajo Remoto", "💼", "3h laborales (12h acumuladas)."));
        list.add(new Block(405, Calendar.THURSDAY, "Jueves", "11:30 – 12:30", 11, 30, 12, 30, "Proyectos Personales (1h de foco)", "Proyectos", "💻", "Continuar tu proyecto personal con mente fresca."));
        list.add(new Block(406, Calendar.THURSDAY, "Jueves", "12:30 – 13:00", 12, 30, 13, 0, "Almuerzo & Preparación", "Comida & Aseo", "🍽️", "Comida y salida 13:00 rumbo a la universidad."));
        list.add(new Block(407, Calendar.THURSDAY, "Jueves", "13:00 – 15:00", 13, 0, 15, 0, "Traslado de Ida (2h) — Lectura", "Traslado / Lectura", "📖", "Lectura enriquecedora."));
        list.add(new Block(408, Calendar.THURSDAY, "Jueves", "15:00 – 20:00", 15, 0, 20, 0, "Universidad", "Universidad", "🏛️", "Sistemas Operativos, Metodología, Informática III."));
        list.add(new Block(409, Calendar.THURSDAY, "Jueves", "20:00 – 22:30", 20, 0, 22, 30, "Traslado Vuelta (2.5h)", "Traslado / Lectura", "🚌", "Desconexión del día."));
        list.add(new Block(410, Calendar.THURSDAY, "Jueves", "22:30 – 23:15", 22, 30, 23, 15, "Cena & Rutina de Cierre", "Comida & Aseo", "🥗", "Cena ligera rica en zinc y magnesio."));
        list.add(new Block(411, Calendar.THURSDAY, "Jueves", "23:15 – 06:45", 23, 15, 6, 45, "Sueño Máximo HGH (7.5h)", "HGH & Sueño", "💤", "Descanso reparador."));

        // VIERNES
        list.add(new Block(501, Calendar.FRIDAY, "Viernes", "07:00 – 07:30", 7, 0, 7, 30, "Despertar calmado & Movilidad", "Físico & Gym", "🧘", "Estiramientos, descompresión espinal y movilidad articular."));
        list.add(new Block(502, Calendar.FRIDAY, "Viernes", "07:30 – 08:15", 7, 30, 8, 15, "Ducha, Aseo & Desayuno completo", "Comida & Aseo", "🚿", "Arranque tranquilo del último día hábil de clases."));
        list.add(new Block(503, Calendar.FRIDAY, "Viernes", "08:15 – 11:15", 8, 15, 11, 15, "Trabajo Remoto (Bloque 5 de 3h)", "Trabajo Remoto", "💼", "3 horas de trabajo para completar 15 horas entre semana."));
        list.add(new Block(504, Calendar.FRIDAY, "Viernes", "11:15 – 12:00", 11, 15, 12, 0, "Almuerzo temprano & Alistarse", "Comida & Aseo", "🍽️", "Comida en casa y salida a las 12:00."));
        list.add(new Block(505, Calendar.FRIDAY, "Viernes", "12:00 – 14:00", 12, 0, 14, 0, "Traslado Ida (2h) — Lectura", "Traslado / Lectura", "📖", "Sesión de lectura en el transporte."));
        list.add(new Block(506, Calendar.FRIDAY, "Viernes", "14:00 – 17:30", 14, 0, 17, 30, "Universidad (Inglés & Mate III)", "Universidad", "🏛️", "Cierre de semana académica."));
        list.add(new Block(507, Calendar.FRIDAY, "Viernes", "17:30 – 20:00", 17, 30, 20, 0, "Traslado Vuelta Temprano", "Traslado / Lectura", "🚌", "¡Llegada a casa a las 20:00! Mucho más temprano que los otros días."));
        list.add(new Block(508, Calendar.FRIDAY, "Viernes", "20:00 – 00:00", 20, 0, 23, 59, "Noche 100% Libre & Ocio", "Ocio & Recarga", "🎮", "Películas, videojuegos, salir con amigos, relax sin culpa."));
        list.add(new Block(509, Calendar.FRIDAY, "Viernes", "00:00 – 08:30", 0, 0, 8, 30, "Sueño Extendido de Fin de Semana (8.5h)", "HGH & Sueño", "💤", "Máxima recarga biológica sin alarma urgente."));

        // SÁBADO
        list.add(new Block(601, Calendar.SATURDAY, "Sábado", "08:30 – 09:15", 8, 30, 9, 15, "Despertar, Descompresión & Desayuno Gourmet", "Comida & Aseo", "🍳", "Café de calidad, huevos con aguacate, lectura tranquila."));
        list.add(new Block(602, Calendar.SATURDAY, "Sábado", "09:15 – 14:15", 9, 15, 14, 15, "Trabajo Remoto (Últimas 5h de la semana)", "Trabajo Remoto", "💼", "Bloque de 5h para completar las 20h semanales exactas. ¡Fin del trabajo por la semana!"));
        list.add(new Block(603, Calendar.SATURDAY, "Sábado", "14:15 – 15:30", 14, 15, 15, 30, "Comida reconfortante & Sobremesa", "Comida & Aseo", "🍽️", "Comida relajada sin prisas de traslados."));
        list.add(new Block(604, Calendar.SATURDAY, "Sábado", "15:30 – 18:30", 15, 30, 18, 30, "Gran Bloque de Proyectos Personales (3h)", "Proyectos", "💻", "Construcción profunda de tus ideas, aplicaciones o metas personales."));
        list.add(new Block(605, Calendar.SATURDAY, "Sábado", "18:30 – 23:30", 18, 30, 23, 30, "Tarde/Noche Social, Ocio & Hobbies", "Ocio & Recarga", "🍿", "Desconexión total, amigos, familia o entretenimiento."));
        list.add(new Block(606, Calendar.SATURDAY, "Sábado", "23:30 – 08:30", 23, 30, 8, 30, "Sueño Reparador HGH (9 horas)", "HGH & Sueño", "💤", "Descanso óptimo para regenerar tejido muscular y articular."));

        // DOMINGO
        list.add(new Block(701, Calendar.SUNDAY, "Domingo", "08:30 – 09:30", 8, 30, 9, 30, "Despertar natural sin prisas & Hidratación", "HGH & Sueño", "☕", "Despertar cuando el cuerpo lo pida. Descompresión espinal suave."));
        list.add(new Block(702, Calendar.SUNDAY, "Domingo", "09:30 – 10:30", 9, 30, 10, 30, "Desayuno relajado & Lectura por placer", "Comida & Aseo", "📖", "Leer tu libro favorito con café en el sillón."));
        list.add(new Block(703, Calendar.SUNDAY, "Domingo", "10:30 – 14:00", 10, 30, 14, 0, "Tiempo Libre, Paseo, Familia o Hobbies", "Ocio & Recarga", "🌳", "Salud mental, sol natural (vitamina D para huesos y testosterona)."));
        list.add(new Block(704, Calendar.SUNDAY, "Domingo", "14:00 – 15:30", 14, 0, 15, 30, "Comida familiar / Especial", "Comida & Aseo", "🍲", "Buena nutrición y convivencia."));
        list.add(new Block(705, Calendar.SUNDAY, "Domingo", "15:30 – 19:00", 15, 30, 19, 0, "Ocio, Videojuegos, Películas o Proyectos libres", "Ocio & Recarga", "🎮", "Total libertad creativa o simplemente descansar."));
        list.add(new Block(706, Calendar.SUNDAY, "Domingo", "19:00 – 20:30", 19, 0, 20, 30, "Reset Semanal & Preparación", "Comida & Aseo", "🎒", "Revisar agenda de la semana, planear tuppers y ropa lista."));
        list.add(new Block(707, Calendar.SUNDAY, "Domingo", "20:30 – 22:30", 20, 30, 22, 30, "Cena ligera & Rutina nocturna", "Comida & Aseo", "🥗", "Bajar luces, evitar pantallas para inducir melatonina temprana."));
        list.add(new Block(708, Calendar.SUNDAY, "Domingo", "22:30 – 06:45", 22, 30, 6, 45, "Sueño de 8h+ para Arrancar la Semana al Máximo", "HGH & Sueño", "🌙", "Dormir temprano para empezar el lunes con energía atómica."));

        return list;
    }

    public static ActiveStatus getActiveStatus() {
        Calendar cal = Calendar.getInstance();
        int dow = cal.get(Calendar.DAY_OF_WEEK);
        int nowMin = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE);

        List<Block> todayBlocks = new ArrayList<>();
        for (Block b : getAllBlocks()) {
            if (b.dayOfWeek == dow) {
                todayBlocks.add(b);
            }
        }
        if (todayBlocks.isEmpty()) {
            for (Block b : getAllBlocks()) {
                if (b.dayOfWeek == Calendar.MONDAY) todayBlocks.add(b);
            }
        }

        int currentIdx = -1;
        for (int i = 0; i < todayBlocks.size(); i++) {
            Block b = todayBlocks.get(i);
            int s = b.getStartMinutes();
            int e = b.getEndMinutes();
            if (e > 24 * 60) {
                if (nowMin >= s || nowMin < (e - 24 * 60)) {
                    currentIdx = i;
                    break;
                }
            } else {
                if (nowMin >= s && nowMin < e) {
                    currentIdx = i;
                    break;
                }
            }
        }
        if (currentIdx == -1) {
            currentIdx = todayBlocks.size() - 1;
        }

        Block current = todayBlocks.get(currentIdx);
        Block next = todayBlocks.get((currentIdx + 1) % todayBlocks.size());

        int s = current.getStartMinutes();
        int e = current.getEndMinutes();
        int adjNow = (e > 24 * 60 && nowMin < s) ? (nowMin + 24 * 60) : nowMin;
        int total = Math.max(1, e - s);
        int elapsed = Math.max(0, Math.min(total, adjNow - s));
        int progress = Math.max(0, Math.min(100, (int) ((elapsed * 100.0f) / total)));
        int remaining = Math.max(1, e - adjNow);

        return new ActiveStatus(current.dayTitle, current, next, progress, remaining);
    }
}
