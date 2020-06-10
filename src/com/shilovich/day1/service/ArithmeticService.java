package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidation;

import java.util.HashMap;
import java.util.Map;

public class ArithmeticService {

    private static final double THREE = 3;

    private static final EnteredDataValidation dataValidation = new EnteredDataValidation();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public double runTaskEight(int number) {
        double result = 0;
        if (number >= THREE) {
            result = calculateFirst(number);
        } else {
            result = calculateSecond(number);
        }
        printToConsole.printValue(result);
        return result;
    }

    public Map<Double, Double> runTaskTen(double startPoint, double endPoint, double step) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(startPoint) ||
                !dataValidation.validateNotNull(endPoint) ||
                !dataValidation.validateNotNull(step) ||
                !dataValidation.validateEndPointMoreThanStartPoint(startPoint, endPoint)) {
            throw new IncorrectDataException("Incorrect data. Enter the correct area");
        }
        printToConsole.printTableHeader();
        Map<Double, Double> function = new HashMap<>();
        for (double i = startPoint; i <= endPoint; i += step) {
            double value = Math.tan(i);
            printToConsole.printTableValue(i);
            printToConsole.printTableFunction(value);
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
