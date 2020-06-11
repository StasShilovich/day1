package com.shilovich.day1.service;

import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidator;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticService {

    private static final double THREE = 3;

    private static final EnteredDataValidator dataValidation = new EnteredDataValidator();

    public double runTaskEight(int number) {
        double result;
        if (number >= THREE) {
            result = calculateFirst(number);
        } else {
            result = calculateSecond(number);
        }
        return result;
    }

    public Map<Double, Double> runTaskTen(double startPoint, double endPoint, double step) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(startPoint) ||
                !dataValidation.validateNotNull(endPoint) ||
                !dataValidation.validateNotNull(step) ||
                !dataValidation.validateLineSegment(startPoint, endPoint)) {
            throw new IncorrectDataException("Incorrect data. Enter the correct area");
        }
        Map<Double, Double> function = new HashMap<>();
        for (double i = startPoint; i <= endPoint; i += step) {
            double value = Math.tan(i);
            function.put(i, value);
        }
        return function;
    }

    public double calculateFirst(int number) {
        return -Math.pow(number, 2) + 3 * number + 9;
    }

    public double calculateSecond(int number) {
        return 1 / (Math.pow(number, 3) - 6);
    }
}
