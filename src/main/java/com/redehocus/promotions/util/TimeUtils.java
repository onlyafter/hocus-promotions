package com.redehocus.promotions.util;

import java.util.concurrent.TimeUnit;

public class TimeUtils {

    public static String format(long time) {

        if (time == 0L) return "Em instantes";

        time -= System.currentTimeMillis();
        long day = TimeUnit.MILLISECONDS.toDays(time);
        long hours = TimeUnit.MILLISECONDS.toHours(time) - day * 24L;
        long minutes = TimeUnit.MILLISECONDS.toMinutes(time) - TimeUnit.MILLISECONDS.toHours(time) * 60L;
        long seconds = TimeUnit.MILLISECONDS.toSeconds(time) - TimeUnit.MILLISECONDS.toMinutes(time) * 60L;
        StringBuilder stringBuilder = new StringBuilder();
        if (day > 0L) {
            stringBuilder.append(day).append(" dias").append(" ");
        }

        if (hours > 0L) {
            stringBuilder.append(hours).append(" horas").append(" ");
        }

        if (minutes > 0L) {
            stringBuilder.append(minutes).append(" minutos").append(" ");
        }

        if (seconds > 0L) {
            stringBuilder.append(seconds).append(" segundos");
        }

        return stringBuilder.toString().isEmpty() ? null : stringBuilder.toString();
    }
}