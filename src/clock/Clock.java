package clock;

import javafx.animation.AnimationTimer;

import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * This is the module that acts as a clock and can be used to quickly get the date
 */
public class Clock {
    public static String Date(Date now) {
        // declare variables
        String date[] = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        StringBuilder builder = new StringBuilder(3);


        // get date and month
        // simple month to get human-friendly month
        SimpleDateFormat simpleMonth = new SimpleDateFormat("MMMM");

        // create return string
        builder.append(simpleMonth.format(now));
        builder.append(" ");

        // the date uses the calendar
        builder.append(Integer.toString(cal.get(Calendar.DAY_OF_MONTH)));
        return builder.toString();

    }
    public static String Day(Date now) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("EEEE");
        // debug
        System.out.println(simpleDate.format(now));
        return simpleDate.format(now);
    }

    public static String getClock() {
        // get time
        int time[] = new int[2];
        time[0] = LocalTime.now().getHour();
        time[1] = LocalTime.now().getMinute();

        StringBuilder builder = new StringBuilder(3);
        builder.append(time[0]);
        builder.append(':');
        builder.append(time[1]);
        return builder.toString();
    }

}
