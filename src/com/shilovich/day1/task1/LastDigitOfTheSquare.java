package com.shilovich.day1.task1;

public class LastDigitOfTheSquare {
    private static final int TEN = 10;

    public int find(int number) {
        int square = calculateSquare(number);
        return square % TEN;
    }

    private int calculateSquare(int number) {
        return number * number;
    }

}
