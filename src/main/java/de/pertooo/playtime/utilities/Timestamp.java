package de.pertooo.playtime.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Timestamp {
    public static Long getCurrentTimeStamp() {
        return new java.sql.Timestamp(System.currentTimeMillis()).getTime();
    }

    public static String parseTimestamp(Long timeInMilliseconds) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date(timeInMilliseconds));
    }
}
