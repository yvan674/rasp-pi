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

        // create return string
        return simpleMonth.format(now);
    }

    public static String getDay(Date now) {
        SimpleDateFormat simpleDay = new SimpleDateFormat("EEEE");
        return simpleDay.format(now);
    }

    public static String getTime(Date now) {
        SimpleDateFormat simpleTime = new SimpleDateFormat("HH:mm");
        // get time
        return simpleTime.format(now);
    }
}
