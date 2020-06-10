package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.entity.Month;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidation;

import java.util.ArrayList;
import java.util.List;

import static com.shilovich.day1.entity.Month.FEBRUARY;

public class TimeService {

    private static final int FOUR = 4;
    private static final int SIXTY = 60;
    private static final int DAYS_IN_LEAP_FEBRUARY = 29;

    private static final EnteredDataValidation dataValidation = new EnteredDataValidation();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public int runTaskTwo(int yearInt, int monthInt) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(yearInt) || !dataValidation.validateNotNull(monthInt)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        int quantity = 0;
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
        return quantity;
    }

    public List<Integer> runTaskSix(int seconds) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(seconds) || !dataValidation.validateValueAboveZero(seconds)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        int minutes = Math.floorDiv(seconds, SIXTY);
        int hoursFinal = Math.floorDiv(minutes, SIXTY);
        int minutesFinal = minutes % SIXTY;
        int secondsFinal = seconds % SIXTY;
        printToConsole.printTime(secondsFinal, minutesFinal, hoursFinal);
        List<Integer> timeList = new ArrayList<>();
        timeList.add(hoursFinal);
        timeList.add(minutesFinal);
        timeList.add(secondsFinal);
        return timeList;
    }

    public boolean checkLeapYear(int year) {
        return year % FOUR == 0;
    }
}
