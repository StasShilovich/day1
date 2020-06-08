package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.entity.Point;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidation;

public class FunctionService {

    private static final double TWO = 2;
    private static final int TEN = 10;

    private static final EnteredDataValidation dataValidation = new EnteredDataValidation();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public double runTaskOne(double value) {
        double result = 0;
        try {
            if (!dataValidation.validateInteger(value) || !dataValidation.validateNotNull(value)) {
                throw new IncorrectDataException("Incorrect data. Enter an integer");
            }
            result = findRemainderOfDividingByTen(value);
            printToConsole.printValue(result);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
        return result;
    }

    public boolean runTaskFour(int firstNumber, int secondNumber, int thirdNumber, int fourthNumber) {
        boolean result = false;
        try {
            if (!dataValidation.validateNotNull(firstNumber) ||
                    !dataValidation.validateNotNull(secondNumber) ||
                    !dataValidation.validateNotNull(thirdNumber) ||
                    !dataValidation.validateNotNull(fourthNumber)) {
                throw new IncorrectDataException("Incorrect data. Enter not null value");
            }
            int flag = 0;
            if (isEvenNumber(firstNumber)) {
                flag++;
            }
            if (isEvenNumber(secondNumber)) {
                flag++;
            }
            if (isEvenNumber(thirdNumber)) {
                flag++;
            }
            if (isEvenNumber(fourthNumber)) {
                flag++;
            }
            if (flag >= TWO) {
                result = true;
            }
            printToConsole.printMessage(Boolean.toString(result));
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
        return result;
    }

    public boolean runTaskFive(int number) {
        boolean result = false;
        try {
            if (!dataValidation.validateNotNull(number)) {
                throw new IncorrectDataException("Incorrect data. Enter not null value");
            }
            result = isPerfect(number);
            printToConsole.printMessage(Boolean.toString(result));
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
        return result;
    }

    public void runTaskSeven(Point pointA, Point pointB) {
        try {
            if (!dataValidation.validatePointRange(pointA) ||
                    !dataValidation.validatePointRange(pointB)) {
                throw new IncorrectDataException("Incorrect data. Enter an integer");
            }
            double distancePointA = calculateHypotenuse(pointA.getAxisX(), pointA.getAxisY());
            double distancePointB = calculateHypotenuse(pointB.getAxisX(), pointB.getAxisY());
            if (distancePointA > distancePointB) {
                printToConsole.printPoint(pointA, distancePointA);
            } else if (distancePointB > distancePointA) {
                printToConsole.printPoint(pointB, distancePointB);
            } else {
                printToConsole.printMessage("The distance is the same");
            }
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
    }

    private double calculateHypotenuse(double axisX, double axisY) {
        return Math.hypot(axisX, axisY);
    }

    private boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    private boolean isEvenNumber(int number) {
        return number % TWO == 0;
    }

    private double findRemainderOfDividingByTen(double value) {
        return calculateSquare(value % TEN) % TEN;
    }

    private double calculateSquare(double value) {
        return Math.pow(value, TWO);
    }
}
