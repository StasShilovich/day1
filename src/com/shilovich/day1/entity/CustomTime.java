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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomTime that = (CustomTime) o;
        if (second != that.second) return false;
        if (minute != that.minute) return false;
        return hours == that.hours;

    }

    @Override
    public int hashCode() {
        int result = (int) (second ^ (second >>> 32));
        result = 31 * result + (int) (minute ^ (minute >>> 32));
        result = 31 * result + (int) (hours ^ (hours >>> 32));
        return result;
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
