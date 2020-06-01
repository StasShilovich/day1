package com.shilovich.day1.task8;

public class Calculations {

    public double calculate(int number) {
        if (number >= 3) {
            return calculateFirst(number);
        } else {
            return calculateSecond(number);
        }
    }

    private double calculateFirst(int number) {
        return -Math.pow(number, 2d) + 3 * number + 9;
    }

    private double calculateSecond(int number) {
        return 1 / (Math.pow(number, 3d) - 6);
    }
}
