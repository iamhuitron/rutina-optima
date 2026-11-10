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

        // LUNES (Entrada 14:00 | Salida 12:00 de casa)
        list.add(new Block(101, Calendar.MONDAY, "Lunes", "07:00 – 07:15", 7, 0, 7, 15, "Shock Anti-Inercia (S23 a 3m + Luz + Dead Hang)", "HGH & Sueño", "🌅", "Levántate a apagar el S23 lejos de la cama. Abre cortina, agua con sal y 2 min colgado en barra. ¡Prohibido volver a tocar la cama!"));
        list.add(new Block(102, Calendar.MONDAY, "Lunes", "07:15 – 07:50", 7, 15, 7, 50, "Entrenamiento V-Taper (Pecho & Espalda)", "Físico & Gym", "🏋️", "35 min alta densidad: Dominadas/remos invertidos, flexiones declinadas y con déficit."));
        list.add(new Block(103, Calendar.MONDAY, "Lunes", "07:50 – 08:20", 7, 50, 8, 20, "Ducha Fría/Fresca & Desayuno Anabólico", "Comida & Aseo", "🚿", "El agua fresca elimina el sueño residual y eleva dopamina +250%. 4 huevos, fruta y café."));
        list.add(new Block(104, Calendar.MONDAY, "Lunes", "08:20 – 10:50", 8, 20, 10, 50, "Trabajo Remoto (Bloque 1 de 2.5h)", "Trabajo Remoto", "💼", "2.5 horas de concentración profunda en métricas laborales."));
        list.add(new Block(105, Calendar.MONDAY, "Lunes", "10:50 – 11:40", 10, 50, 11, 40, "Cursos & Certificaciones (Práctica en PC)", "Cursos", "🎓", "50 min diarios dedicados 100% a avanzar tus cursos con mente fresca."));
        list.add(new Block(106, Calendar.MONDAY, "Lunes", "11:40 – 12:00", 11, 40, 12, 0, "Almuerzo en casa & Alistar Mochila", "Comida & Aseo", "🍽️", "Comida completa previa al viaje y empaque de snacks para la uni."));
        list.add(new Block(107, Calendar.MONDAY, "Lunes", "12:00 – 14:00", 12, 0, 14, 0, "Traslado Ida (2h) — Teoría de Cursos + Lectura", "Traslado / Lectura", "📖", "45 min de videos descargados de tus cursos + 45 min de lectura en Kindle/libro."));
        list.add(new Block(108, Calendar.MONDAY, "Lunes", "14:00 – 20:00", 14, 0, 20, 0, "Universidad (Clases + Biblioteca)", "Universidad", "🏛️", "14h: Inglés | 16h: Derecho | 18h: Mate III | 19h: Prog III. En huecos (15h y 17h): liquidar tareas."));
        list.add(new Block(109, Calendar.MONDAY, "Lunes", "20:00 – 22:30", 20, 0, 22, 30, "Traslado de Regreso (2.5h) — Siesta / Audio", "Traslado / Lectura", "🚌", "Cierra los ojos 30-40 min en el transporte para adelantar descanso ocular."));
        list.add(new Block(110, Calendar.MONDAY, "Lunes", "22:30 – 23:15", 22, 30, 23, 15, "Cena Pro-HGH, Ducha Tibia & S23 Lejos", "Comida & Aseo", "🥗", "Proteína + vegetales. Deja el S23 cargando a 3 metros de la cama con alarma 07:00."));
        list.add(new Block(111, Calendar.MONDAY, "Lunes", "23:15 – 07:00", 23, 15, 7, 0, "Sueño Profundo (5 Ciclos Completos = 7.5h)", "HGH & Sueño", "💤", "5 ciclos exactos de 90 min para despertar en fase ligera sin inercia del sueño."));

        // MARTES (Entrada 15:00 | Salida 13:00 de casa)
        list.add(new Block(201, Calendar.TUESDAY, "Martes", "07:00 – 07:15", 7, 0, 7, 15, "Shock Anti-Inercia (S23 a 3m + Luz + Dead Hang)", "HGH & Sueño", "🌅", "Párate de inmediato a apagar el S23. Luz solar directa, agua con sal y 2 min en barra."));
        list.add(new Block(202, Calendar.TUESDAY, "Martes", "07:15 – 07:50", 7, 15, 7, 50, "Entrenamiento V-Taper (Hombros 3D & Brazos)", "Físico & Gym", "🏋️", "Pike push-ups, elevaciones laterales estrictas, fondos y stomach vacuum."));
        list.add(new Block(203, Calendar.TUESDAY, "Martes", "07:50 – 08:20", 7, 50, 8, 20, "Ducha Fresca, Skincare & Desayuno", "Comida & Aseo", "🚿", "Activación térmica + desayuno rico en proteína."));
        list.add(new Block(204, Calendar.TUESDAY, "Martes", "08:20 – 10:50", 8, 20, 10, 50, "Trabajo Remoto (Bloque 2 de 2.5h)", "Trabajo Remoto", "💼", "2.5 horas de avance laboral remoto (5h acumuladas)."));
        list.add(new Block(205, Calendar.TUESDAY, "Martes", "10:50 – 12:00", 10, 50, 12, 0, "Cursos & Certificaciones (Bloque Intensivo 1h 10m)", "Cursos", "🎓", "70 minutos enfocados en completar módulos y laboratorios de tus cursos."));
        list.add(new Block(206, Calendar.TUESDAY, "Martes", "12:00 – 12:35", 12, 0, 12, 35, "Proyectos Personales (35 min Sprint)", "Proyectos", "💻", "Avance puntual en tu portafolio o código personal."));
        list.add(new Block(207, Calendar.TUESDAY, "Martes", "12:35 – 13:00", 12, 35, 13, 0, "Almuerzo en casa & Salida", "Comida & Aseo", "🍽️", "Comida nutritiva antes de salir a las 13:00 rumbo a SO (15:00)."));
        list.add(new Block(208, Calendar.TUESDAY, "Martes", "13:00 – 15:00", 13, 0, 15, 0, "Traslado Ida (2h) — Videos Cursos + Lectura", "Traslado / Lectura", "📖", "Repaso de cursos en video + lectura activa."));
        list.add(new Block(209, Calendar.TUESDAY, "Martes", "15:00 – 20:00", 15, 0, 20, 0, "Universidad (Sistemas Op, Metodología, Inf III)", "Universidad", "🏛️", "En huecos de 16h y 18h: terminar tareas en biblioteca."));
        list.add(new Block(210, Calendar.TUESDAY, "Martes", "20:00 – 22:30", 20, 0, 22, 30, "Traslado de Regreso (2.5h)", "Traslado / Lectura", "🚌", "Desconexión auditiva y descanso ocular."));
        list.add(new Block(211, Calendar.TUESDAY, "Martes", "22:30 – 23:15", 22, 30, 23, 15, "Cena Pro-HGH, Ducha Tibia & S23 a 3m", "Comida & Aseo", "🥗", "Cena sin carbohidratos simples. Deja el celular lejos de la cama."));
        list.add(new Block(212, Calendar.TUESDAY, "Martes", "23:15 – 07:00", 23, 15, 7, 0, "Sueño Anabólico HGH (7.5h — 5 Ciclos)", "HGH & Sueño", "💤", "Recuperación muscular completa y pico de somatropina."));

        // MIÉRCOLES (Entrada 14:00)
        list.add(new Block(301, Calendar.WEDNESDAY, "Miércoles", "07:00 – 07:15", 7, 0, 7, 15, "Shock Anti-Inercia (S23 a 3m + Luz + Dead Hang)", "HGH & Sueño", "🌅", "Levántate de inmediato, luz natural y 2 min colgado en barra."));
        list.add(new Block(302, Calendar.WEDNESDAY, "Miércoles", "07:15 – 07:50", 7, 15, 7, 50, "Entrenamiento V-Taper (Pierna & Pliometría)", "Físico & Gym", "🏋️", "Sentadillas búlgaras, saltos explosivos, pantorrillas en escalón."));
        list.add(new Block(303, Calendar.WEDNESDAY, "Miércoles", "07:50 – 08:20", 7, 50, 8, 20, "Ducha Fresca & Desayuno Alto en Proteína", "Comida & Aseo", "🚿", "Combustible limpio y activación nerviosa."));
        list.add(new Block(304, Calendar.WEDNESDAY, "Miércoles", "08:20 – 10:50", 8, 20, 10, 50, "Trabajo Remoto (Bloque 3 de 2.5h)", "Trabajo Remoto", "💼", "Avance laboral consistente (7.5h acumuladas)."));
        list.add(new Block(305, Calendar.WEDNESDAY, "Miércoles", "10:50 – 11:40", 10, 50, 11, 40, "Cursos & Certificaciones (Práctica en PC)", "Cursos", "🎓", "50 min de avance práctico en tus cursos."));
        list.add(new Block(306, Calendar.WEDNESDAY, "Miércoles", "11:40 – 12:00", 11, 40, 12, 0, "Almuerzo & Empaque", "Comida & Aseo", "🍽️", "Comida en casa y salida puntual a las 12:00."));
        list.add(new Block(307, Calendar.WEDNESDAY, "Miércoles", "12:00 – 14:00", 12, 0, 14, 0, "Traslado Ida (2h) — Cursos + Lectura", "Traslado / Lectura", "📖", "Teoría de cursos + lectura en transporte."));
        list.add(new Block(308, Calendar.WEDNESDAY, "Miércoles", "14:00 – 20:00", 14, 0, 20, 0, "Universidad (Clases vespertinas)", "Universidad", "🏛️", "Inglés, Derecho, Matemáticas III, Programación III."));
        list.add(new Block(309, Calendar.WEDNESDAY, "Miércoles", "20:00 – 22:30", 20, 0, 22, 30, "Traslado Vuelta (2.5h)", "Traslado / Lectura", "🚌", "Descanso mental."));
        list.add(new Block(310, Calendar.WEDNESDAY, "Miércoles", "22:30 – 23:15", 22, 30, 23, 15, "Cena Ligera, Ducha & S23 Lejos", "Comida & Aseo", "🥗", "Preparación nocturna sin pantallas en cama."));
        list.add(new Block(311, Calendar.WEDNESDAY, "Miércoles", "23:15 – 07:00", 23, 15, 7, 0, "Sueño Óptimo HGH (7.5h — 5 Ciclos)", "HGH & Sueño", "💤", "Regeneración celular."));

        // JUEVES (Entrada 15:00)
        list.add(new Block(401, Calendar.THURSDAY, "Jueves", "07:00 – 07:15", 7, 0, 7, 15, "Shock Anti-Inercia (S23 a 3m + Luz + Dead Hang)", "HGH & Sueño", "🌅", "Levántate al sonar la alarma, agua con electrolitos y colgado en barra."));
        list.add(new Block(402, Calendar.THURSDAY, "Jueves", "07:15 – 07:50", 7, 15, 7, 50, "Entrenamiento V-Taper (Torso Denso & Postura)", "Físico & Gym", "🏋️", "Remo unilateral con mochila, flexiones diamante, vuelos posteriores."));
        list.add(new Block(403, Calendar.THURSDAY, "Jueves", "07:50 – 08:20", 7, 50, 8, 20, "Ducha Fresca, Aseo & Desayuno", "Comida & Aseo", "🚿", "Aseo matutino y nutrición."));
        list.add(new Block(404, Calendar.THURSDAY, "Jueves", "08:20 – 10:50", 8, 20, 10, 50, "Trabajo Remoto (Bloque 4 de 2.5h)", "Trabajo Remoto", "💼", "2.5h laborales (10h acumuladas)."));
        list.add(new Block(405, Calendar.THURSDAY, "Jueves", "10:50 – 12:00", 10, 50, 12, 0, "Cursos & Certificaciones (Bloque Intensivo 1h 10m)", "Cursos", "🎓", "70 minutos de práctica técnica en tus cursos."));
        list.add(new Block(406, Calendar.THURSDAY, "Jueves", "12:00 – 12:35", 12, 0, 12, 35, "Proyectos Personales (35 min)", "Proyectos", "💻", "Avance en tus proyectos personales."));
        list.add(new Block(407, Calendar.THURSDAY, "Jueves", "12:35 – 13:00", 12, 35, 13, 0, "Almuerzo & Preparación", "Comida & Aseo", "🍽️", "Comida y salida 13:00 rumbo a la universidad."));
        list.add(new Block(408, Calendar.THURSDAY, "Jueves", "13:00 – 15:00", 13, 0, 15, 0, "Traslado Ida (2h) — Cursos + Lectura", "Traslado / Lectura", "📖", "Lectura y repaso de cursos."));
        list.add(new Block(409, Calendar.THURSDAY, "Jueves", "15:00 – 20:00", 15, 0, 20, 0, "Universidad", "Universidad", "🏛️", "Sistemas Operativos, Metodología, Informática III."));
        list.add(new Block(410, Calendar.THURSDAY, "Jueves", "20:00 – 22:30", 20, 0, 22, 30, "Traslado Vuelta (2.5h)", "Traslado / Lectura", "🚌", "Desconexión del día."));
        list.add(new Block(411, Calendar.THURSDAY, "Jueves", "22:30 – 23:15", 22, 30, 23, 15, "Cena & Rutina de Cierre (S23 a 3m)", "Comida & Aseo", "🥗", "Cena ligera rica en zinc y magnesio."));
        list.add(new Block(412, Calendar.THURSDAY, "Jueves", "23:15 – 07:00", 23, 15, 7, 0, "Sueño Máximo HGH (7.5h — 5 Ciclos)", "HGH & Sueño", "💤", "Descanso reparador."));

        // VIERNES (Entrada 14:00 | Salida temprana 17:30)
        list.add(new Block(501, Calendar.FRIDAY, "Viernes", "07:00 – 07:30", 7, 0, 7, 30, "Shock Anti-Inercia & Movilidad Articular", "Físico & Gym", "🧘", "Despertar sin recaída, estiramientos de psoas y descompresión espinal."));
        list.add(new Block(502, Calendar.FRIDAY, "Viernes", "07:30 – 08:00", 7, 30, 8, 0, "Ducha, Aseo & Desayuno completo", "Comida & Aseo", "🚿", "Arranque del viernes."));
        list.add(new Block(503, Calendar.FRIDAY, "Viernes", "08:00 – 10:30", 8, 0, 10, 30, "Trabajo Remoto (Bloque 5 de 2.5h)", "Trabajo Remoto", "💼", "2.5h de trabajo (12.5h acumuladas entre semana)."));
        list.add(new Block(504, Calendar.FRIDAY, "Viernes", "10:30 – 11:35", 10, 30, 11, 35, "Cursos & Certificaciones (1h 05m)", "Cursos", "🎓", "Cerrar meta de cursos de lunes a viernes."));
        list.add(new Block(505, Calendar.FRIDAY, "Viernes", "11:35 – 12:00", 11, 35, 12, 0, "Almuerzo temprano & Alistarse", "Comida & Aseo", "🍽️", "Comida en casa y salida a las 12:00."));
        list.add(new Block(506, Calendar.FRIDAY, "Viernes", "12:00 – 14:00", 12, 0, 14, 0, "Traslado Ida (2h) — Lectura", "Traslado / Lectura", "📖", "Sesión de lectura en el transporte."));
        list.add(new Block(507, Calendar.FRIDAY, "Viernes", "14:00 – 17:30", 14, 0, 17, 30, "Universidad (Inglés & Mate III)", "Universidad", "🏛️", "Cierre de semana académica."));
        list.add(new Block(508, Calendar.FRIDAY, "Viernes", "17:30 – 20:00", 17, 30, 20, 0, "Traslado Vuelta Temprano", "Traslado / Lectura", "🚌", "¡Llegada a casa a las 20:00!"));
        list.add(new Block(509, Calendar.FRIDAY, "Viernes", "20:00 – 23:30", 20, 0, 23, 30, "Noche 100% Libre & Ocio", "Ocio & Recarga", "🎮", "Películas, videojuegos, salir con amigos, relax sin culpa."));
        list.add(new Block(510, Calendar.FRIDAY, "Viernes", "23:30 – 08:00", 23, 30, 8, 0, "Sueño Extendido de Fin de Semana (8.5h)", "HGH & Sueño", "💤", "Máxima recarga biológica y pago de deuda de sueño."));

        // SÁBADO
        list.add(new Block(601, Calendar.SATURDAY, "Sábado", "08:00 – 08:45", 8, 0, 8, 45, "Despertar, Descompresión & Desayuno Gourmet", "Comida & Aseo", "🍳", "Café de calidad, huevos con aguacate."));
        list.add(new Block(602, Calendar.SATURDAY, "Sábado", "08:45 – 14:15", 8, 45, 14, 15, "Trabajo Remoto (5.5h con descanso activo)", "Trabajo Remoto", "💼", "Cerrar trabajo remoto semanal para dejar el domingo libre (o 2h extra si faltó en la semana)."));
        list.add(new Block(603, Calendar.SATURDAY, "Sábado", "14:15 – 15:15", 14, 15, 15, 15, "Comida reconfortante & Sobremesa", "Comida & Aseo", "🍽️", "Comida relajada sin prisas."));
        list.add(new Block(604, Calendar.SATURDAY, "Sábado", "15:15 – 16:45", 15, 15, 16, 45, "Cursos & Certificaciones (Sesión Práctica 1.5h)", "Cursos", "🎓", "Avance profundo de fin de semana en tus cursos."));
        list.add(new Block(605, Calendar.SATURDAY, "Sábado", "16:45 – 18:45", 16, 45, 18, 45, "Proyectos Personales (2h)", "Proyectos", "💻", "Construcción de tus aplicaciones o portafolio."));
        list.add(new Block(606, Calendar.SATURDAY, "Sábado", "18:45 – 23:30", 18, 45, 23, 30, "Tarde/Noche Social, Ocio & Hobbies", "Ocio & Recarga", "🍿", "Desconexión total, amigos, familia o entretenimiento."));
        list.add(new Block(607, Calendar.SATURDAY, "Sábado", "23:30 – 08:30", 23, 30, 8, 30, "Sueño Reparador HGH (9 horas)", "HGH & Sueño", "💤", "Descanso óptimo para regenerar tejido muscular."));

        // DOMINGO
        list.add(new Block(701, Calendar.SUNDAY, "Domingo", "08:30 – 09:30", 8, 30, 9, 30, "Despertar natural sin prisas & Hidratación", "HGH & Sueño", "☕", "Despertar descansado. Descompresión espinal suave."));
        list.add(new Block(702, Calendar.SUNDAY, "Domingo", "09:30 – 10:30", 9, 30, 10, 30, "Desayuno relajado & Lectura por placer", "Comida & Aseo", "📖", "Leer tu libro favorito con café."));
        list.add(new Block(703, Calendar.SUNDAY, "Domingo", "10:30 – 11:45", 10, 30, 11, 45, "Cursos & Certificaciones (1h 15m sin estrés)", "Cursos", "🎓", "Sesión dominical ligera para cerrar la semana con 8+ horas de cursos."));
        list.add(new Block(704, Calendar.SUNDAY, "Domingo", "11:45 – 14:30", 11, 45, 14, 30, "Tiempo Libre, Paseo, Sol & Familia", "Ocio & Recarga", "🌳", "Vitamina D solar para huesos y testosterona."));
        list.add(new Block(705, Calendar.SUNDAY, "Domingo", "14:30 – 16:00", 14, 30, 16, 0, "Comida familiar / Especial", "Comida & Aseo", "🍲", "Buena nutrición y convivencia."));
        list.add(new Block(706, Calendar.SUNDAY, "Domingo", "16:00 – 19:30", 16, 0, 19, 30, "Ocio, Videojuegos o Descanso Libre", "Ocio & Recarga", "🎮", "Libertad total para recargar dopamina."));
        list.add(new Block(707, Calendar.SUNDAY, "Domingo", "19:30 – 20:30", 19, 30, 20, 30, "Reset Semanal & Preparar S23 a 3m de la cama", "Comida & Aseo", "🎒", "Planear tuppers, ropa lista y cargador lejos de la cama."));
        list.add(new Block(708, Calendar.SUNDAY, "Domingo", "20:30 – 22:30", 20, 30, 22, 30, "Cena ligera & Rutina nocturna", "Comida & Aseo", "🥗", "Bajar luces, evitar pantallas para inducir melatonina temprana."));
        list.add(new Block(709, Calendar.SUNDAY, "Domingo", "22:30 – 07:00", 22, 30, 7, 0, "Sueño de 8.5h para Arrancar el Lunes al 100%", "HGH & Sueño", "🌙", "Dormir temprano el domingo elimina la fatiga del lunes a las 7 AM."));

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
