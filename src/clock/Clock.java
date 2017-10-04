package clock;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * This is the module that acts as a clock and can be used to quickly get the date
 */
public class Clock {
    // main timeline
    private Timeline timeline;
    private AnimationTimer timer;

    // debug main
    public static void main(String[] args) {
        runClock();
        Date now = new Date();
        Date(now);
        Day(now);
    }
    public static String Date(Date now) {
        // declare variables
        String date[] = new String[2];
        Calendar cal = Calendar.getInstance();
        cal.setTime(now);
        StringBuilder builder = new StringBuilder(3);


        // get date and month
        // simple month to get human-friendly month
        SimpleDateFormat simpleMonth = new SimpleDateFormat("MMMM");
        // the date uses the calendar
        date[1] = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
        date[0] = simpleMonth.format(now);
        // debug
        System.out.println(date[0]);
        System.out.println(date[1]);

        // create return string
        builder.append(date[0]);
        builder.append(" ");
        builder.append(date[1]);
        return builder.toString();

    }
    public static String Day(Date now) {
        SimpleDateFormat simpleDate = new SimpleDateFormat("EEEE");
        // debug
        System.out.println(simpleDate.format(now));
        return simpleDate.format(now);
    }

    public static void runClock() {
        // get time
        int time[] = new int[2];
        time[0] = LocalTime.now().getHour();
        time[1] = LocalTime.now().getMinute();

        StringBuilder builder = new StringBuilder(3);
        builder.append(time[0]);
        builder.append(':');
        builder.append(time[1]);
        rasppi.Controller.setTime(builder.toString());
        System.out.println(builder.toString());
    }
}
