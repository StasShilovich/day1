package com.shilovich.day1.task2;

import static com.shilovich.day1.task2.Month.*;

public class NumberOfADays {
    private static final int DAYS_IN_LEAP_FEBRUARY = 29;

    private int year;
    private int month;

    public NumberOfADays(int year, int month) {
        this.year = year;
        this.month = month;
    }

    public int getQuantity() {
        int quantity = 0;
        if (checkLeapYear() && month == FEBRUARY.getMonthNumber()) {
            quantity = DAYS_IN_LEAP_FEBRUARY;
            return quantity;
        }
        for (Month month : Month.values()) {
            if (month.getMonthNumber() == this.month) {
                quantity = month.getDaysInMonth();
                return quantity;
            }
        }
        return quantity;
    }

    private boolean checkLeapYear() {
        if (year % 4 == 0) {
            return true;
        } else return false;
    }
}
