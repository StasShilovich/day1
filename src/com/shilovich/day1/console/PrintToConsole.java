package com.shilovich.day1.console;

import com.shilovich.day1.entity.Point;

public class PrintToConsole {
    public void printMessage(String message) {
        System.out.printf(message);
    }

    public void printValue(double value) {
        System.out.printf("%.2f", value);
    }

    public void printPoint(Point point, double distance) {
        System.out.printf(point + " Distance: " + distance);
    }

    public void printInscribedSquare(double square) {
        System.out.printf("Inscribed Square: %.2f", square);
    }

    public void printRatio(double ratio) {
        System.out.printf(" Ratio: %.2f", ratio);
    }

    public void printArea(double area) {
        System.out.printf(" Area: %.2f", area);
    }

    public void printCircumference(double circumference) {
        System.out.printf(" Circumference: %.2f", circumference);
    }

    public void printTime(int seconds, int minutes, int hours) {
        System.out.printf("hours %d: minutes %d: seconds %d%n", hours, minutes, seconds);
    }

    public void printQuantity(int quantity) {
        System.out.printf("Days in a month: %d", quantity);
    }

    public void printTableHeader() {
        System.out.printf("|argument values | argument function|%n");
    }

    public void printTableValue(double i) {
        System.out.printf("|%16.2f|", i);
    }

    public void printTableFunction(double value) {
        System.out.printf("%18.2f|%n", value);
    }
}
