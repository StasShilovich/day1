package com.shilovich.day1.task10;

public class Tangent {
    private int startPoint;
    private int endPoint;
    private double step;

    public Tangent(int startPoint, int endPoint, double step) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.step = step;
    }

    public void printTangentGraph() {
        String string = "|argument values | argument function|";
        System.out.println(string);
        for (int i = startPoint; i <= endPoint; i += step) {
            System.out.printf("|%16d|", i);
            System.out.printf("%18f|", Math.tan(i));
            System.out.println();
        }
    }
}
