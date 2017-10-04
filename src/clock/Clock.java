package clock;

import java.time.LocalTime;

/**
 * Created by Yvan on 3.10.17.
 * Copyright (C) 2017.
 * This is the module that acts as a clock and can be used to quickly get the date
 */
public class Clock {
    public int[] Time() {
        int time[] = new int[2];
        time[0] = LocalTime.now().getHour();
        time[1] = LocalTime.now().getMinute();
        return time;
    }

    public boolean SecondsFlash() {
        if (LocalTime.now().getSecond() % 2 == 0) return true;
        else return false;
    }
    public int[] Date() {
        int date[] = new int[3];

        return date;
    }
}
