package com.shilovich.day1.task6;

public class SecondsToHours {
    private static final int SIXTY = 60;

    public String transformSecondsToHours(int seconds) {
        int minutes = (int) seconds / SIXTY;
        int second = seconds % SIXTY;
        int hours = (int) minutes / SIXTY;
        int minute = minutes % SIXTY;
        return hours + " hours, " + minute + " minutes, " + second + " seconds";
    }
}
