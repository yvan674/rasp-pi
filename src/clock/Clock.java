package clock;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * This is the module that acts as a clock and can be used to quickly get the date
 */
public class Clock {
    public static String Date(Date now) {
        // simple month to get human-friendly month
        SimpleDateFormat simpleMonth = new SimpleDateFormat("MMMM");

        // create return string
        return simpleMonth.format(now) + " " + LocalDate.now().getDayOfMonth();
    }

    public static String Day(Date now) {
        SimpleDateFormat simpleDay = new SimpleDateFormat("EEEE");
        return simpleDay.format(now);
    }

    public static String getClock() {
        // get time
        return LocalTime.now().getHour() + ":" + LocalTime.now().getMinute();
    }
}
