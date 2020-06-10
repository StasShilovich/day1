package com.shilovich.day1.entity;

import java.util.StringJoiner;

public class CustomTime {
    private long second;
    private long minute;
    private long hours;

    public CustomTime(long second, long minute, long hours) {
        this.second = second;
        this.minute = minute;
        this.hours = hours;
    }

    public CustomTime() {
    }

    public long getSecond() {
        return second;
    }

    public void setSecond(long second) {
        this.second = second;
    }

    public long getMinute() {
        return minute;
    }

    public void setMinute(long minute) {
        this.minute = minute;
    }

    public long getHours() {
        return hours;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", CustomTime.class.getSimpleName() + "[", "]")
                .add("second=" + second)
                .add("minute=" + minute)
                .add("hours=" + hours)
                .toString();
    }
}
