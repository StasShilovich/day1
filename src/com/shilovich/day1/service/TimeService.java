package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.entity.Month;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidation;

import static com.shilovich.day1.entity.Month.FEBRUARY;

public class TimeService {

    private static final int FOUR = 4;
    private static final int SIXTY = 60;
    private static final int DAYS_IN_LEAP_FEBRUARY = 29;

    private static final EnteredDataValidation dataValidation = new EnteredDataValidation();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public void runTaskSix(int seconds) {
        try {
            if (!dataValidation.validateNotNull(seconds) || !dataValidation.validateValueAboveZero(seconds)) {
                throw new IncorrectDataException("Incorrect data. Enter not null value");
            }
            int minutes = Math.floorDiv(seconds, SIXTY);
            int hoursFinal = Math.floorDiv(minutes, SIXTY);
            int minutesFinal = minutes % SIXTY;
            int secondsFinal = seconds % SIXTY;
            printToConsole.printTime(secondsFinal, minutesFinal, hoursFinal);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
    }

    public int runTaskTwo(String year, String monthNumber) {
        int quantity = 0;
        try {
            int yearInt = parseString(year);
            int monthInt = parseString(monthNumber);
            if (!dataValidation.validateNotNull(yearInt) || !dataValidation.validateNotNull(monthInt)) {
                throw new IncorrectDataException("Incorrect data. Enter not null value");
            }
            if (checkLeapYear(yearInt) && monthInt == FEBRUARY.getMonthNumber()) {
                quantity = DAYS_IN_LEAP_FEBRUARY;
                printToConsole.printQuantity(quantity);
                return quantity;
            }
            for (Month month : Month.values()) {
                if (month.getMonthNumber() == monthInt) {
                    quantity = month.getDaysInMonth();
                }
            }
            printToConsole.printQuantity(quantity);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
        return quantity;
    }

    private boolean checkLeapYear(int year) {
        return year % FOUR == 0;
    }

    private int parseString(String string) {
        return Integer.valueOf(string);
    }
}
