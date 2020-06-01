package com.shilovich.day1.task9;

public class CircleCalculations {
    private int radius;

    public CircleCalculations(int radius) {
        this.radius = radius;
    }

    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2d);
    }
}
