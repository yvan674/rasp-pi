package clock;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * This is the module that acts as a clock and can be used to quickly get the date
 */
public class Clock {
    public static String getDate(Date now) {
        // simple month to get human-friendly month
        SimpleDateFormat simpleMonth = new SimpleDateFormat("MMMM d");

        // returns formatted string of the "now" date
        return simpleMonth.format(now);
    }

    public static String getDay(Date now) {
        // simple day to get human-friendly day name
        SimpleDateFormat simpleDay = new SimpleDateFormat("EEEE");

        // returns formatted string of the "now" date
        return simpleDay.format(now);
    }

    public static String getTime(Date now) {
        // Simple time to get a formatted version of the time
        SimpleDateFormat simpleTime = new SimpleDateFormat("HH:mm");
        // returns formatted string of the "now" date
        return simpleTime.format(now);
    }
}
