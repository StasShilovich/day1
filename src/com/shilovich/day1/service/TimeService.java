package com.shilovich.day1.service;

import com.shilovich.day1.entity.CustomTime;
import com.shilovich.day1.entity.MonthNotLeap;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidator;

import java.util.concurrent.TimeUnit;

import static com.shilovich.day1.entity.MonthNotLeap.FEBRUARY;

public class TimeService {

    private static final int FOUR = 4;
    private static final int DAYS_IN_LEAP_FEBRUARY = 29;

    private static final EnteredDataValidator dataValidation = new EnteredDataValidator();

    public int runTaskTwo(int yearInt, int monthInt) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(yearInt) || !dataValidation.validateNotNull(monthInt)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        int quantity = 0;
        if (checkLeapYear(yearInt) && monthInt == FEBRUARY.getMonthNumber()) {
            quantity = DAYS_IN_LEAP_FEBRUARY;
            return quantity;
        }
        for (MonthNotLeap month : MonthNotLeap.values()) {
            if (month.getMonthNumber() == monthInt) {
                quantity = month.getDaysInMonth();
            }
        }
        return quantity;
    }

    public CustomTime runTaskSix(int seconds) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(seconds) || !dataValidation.validateValueAboveZero(seconds)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        long hours = TimeUnit.SECONDS.toHours(seconds);
        long minute = TimeUnit.SECONDS.toMinutes(seconds-hours*3600);
        long second = TimeUnit.SECONDS.toHours(seconds);
        CustomTime customTime = new CustomTime(second, minute, hours);
        return customTime;
    }

    public boolean checkLeapYear(int year) {
        return year % FOUR == 0;
    }
}
