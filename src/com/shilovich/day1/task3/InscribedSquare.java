package com.shilovich.day1.task3;

public class InscribedSquare {

    private static final double TWO = 2d;
    private double square;

    public InscribedSquare(double square) {
        this.square = square;
    }

    public double getSquareArea() {
        double sideOut = Math.sqrt(square);
        double sideIn = sideOut / Math.sqrt(TWO);
        return sideIn * sideIn;
    }

    public double ratio() {
        return square / getSquareArea();
    }
}
