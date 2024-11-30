package de.pertooo.playtime.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timestamp {
    public static Long getCurrentTimeStamp() {
        return new java.sql.Timestamp(System.currentTimeMillis()).getTime();
    }

    public static String parseTimestamp(Long timeInMilliseconds) {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return simpleDateFormat.format(new Date(timeInMilliseconds));
    }
}
