package seedu.hustler.ui.timer;

import java.util.*;

public class timer implements Runnable {

    protected int hours;
    protected int minutes;
    protected int seconds;

    public timer() {
        hours = 0;
        minutes = 0;
        seconds = 0;
    }

    public timer(String hours, String minutes, String seconds) {
        this.hours = Integer.parseInt(hours);
        this.minutes = Integer.parseInt(minutes);
        this.seconds = Integer.parseInt(seconds);
    }

    public void run() {
        System.out.println("Timer mode has commenced! Time set: " + hours + "hr " + minutes + "min " + seconds + "sec");
        try {
            while (hours != 0 || minutes != 0 | seconds != 0) {
                Thread.sleep(1000);
                decrementSeconds();
            }
        } catch (Exception e) {}

	System.out.println("Timer mode has ended.");
    }

    public void decrementSeconds() {
        if (seconds != 0) {
            seconds--;
        } else  {
            seconds = 59;
            decrementMinutes();
        }
    }

    public void decrementMinutes() {
        if (minutes != 0) {
            minutes--;
        } else {
            minutes = 59;
            decrementHours();
        }
    }

    public void decrementHours() {
        hours--;
    }

    public void printTimeLeft() {
        System.out.println("time remaining: "
                           + (hours < 10 ? "0" : "") + hours + "hr "
                           + (minutes < 10 ? "0" : "") + minutes + "min "
                           + (seconds < 10 ? "0" : "") + seconds + "sec");
    }
}