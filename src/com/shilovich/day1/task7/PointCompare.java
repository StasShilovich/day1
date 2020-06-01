package com.shilovich.day1.task7;

public class PointCompare {
    private Point a;
    private Point b;

    public PointCompare(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point compare() {
        double distanceA = Math.sqrt(a.getX() * a.getX() + a.getY() * a.getY());
        double distanceB = Math.sqrt(b.getX() * b.getX() + b.getY() * b.getY());
        if (distanceA > distanceB) {
            return a;
        } else {
            return b;
        }
    }
}
