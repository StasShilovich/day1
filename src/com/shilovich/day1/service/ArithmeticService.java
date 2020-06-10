package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidation;

public class ArithmeticService {

    private static final double THREE = 3;

    private static final EnteredDataValidation dataValidation = new EnteredDataValidation();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public double runTaskEight(int number) throws IncorrectDataException{
        double result = 0;
        try {
            if (number >= THREE) {
                result = calculateFirst(number);
            } else {
                result = calculateSecond(number);
            }
            printToConsole.printValue(result);
        } catch (Exception e) {
            printToConsole.printMessage(e.getMessage());
        }
        return result;
    }

    public double runTaskTen(double startPoint, double endPoint, double step) throws IncorrectDataException{
        double result = 0;
        try {
            if (!dataValidation.validateNotNull(startPoint) ||
                    !dataValidation.validateNotNull(endPoint) ||
                    !dataValidation.validateNotNull(step) ||
                    !dataValidation.validateEndPointMoreThanStartPoint(startPoint, endPoint)) {
                throw new IncorrectDataException("Incorrect data. Enter the correct area");
            }
            printToConsole.printTableHeader();
            for (double i = startPoint; i <= endPoint; i += step) {
                double value = Math.tan(i);
                printToConsole.printTableValue(i);
                printToConsole.printTableFunction(value);
            }
        } catch (Exception e) {
            printToConsole.printMessage(e.getMessage());
        }
        return result;
    }

    private double calculateFirst(int number) {
        return -Math.pow(number, 2) + 3 * number + 9;
    }

    private double calculateSecond(int number) {
        return 1 / (Math.pow(number, 3) - 6);
    }
}
