package com.shilovich.day1.entity;

import java.util.StringJoiner;

public class Point {
    private int axisX;
    private int axisY;

    public int getAxisX() {
        return axisX;
    }

    public int getAxisY() {
        return axisY;
    }

    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Point.class.getSimpleName() + "[", "]")
                .add("axisX=" + axisX)
                .add("axisY=" + axisY)
                .toString();
    }
}
