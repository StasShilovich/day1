package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.entity.Point;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidator;

public class FunctionService {

    private static final double TWO = 2;
    private static final int TEN = 10;

    private static final EnteredDataValidator dataValidation = new EnteredDataValidator();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public double runTaskOne(double value) throws IncorrectDataException {
        if (!dataValidation.validateInteger(value) || !dataValidation.validateNotNull(value)) {
            throw new IncorrectDataException("Incorrect data. Enter an integer");
        }
        double result = calculateSquare(value % TEN) % TEN;
        printToConsole.printValue(result);
        return result;
    }

    public boolean runTaskFour(int firstNumber, int secondNumber,
                               int thirdNumber, int fourthNumber) throws IncorrectDataException {
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
        boolean result = false;
        if (flag >= TWO) {
            result = true;
        }
        printToConsole.printMessage(Boolean.toString(result));
        return result;
    }

    public boolean runTaskFive(int number) throws IncorrectDataException {
        if (!dataValidation.validateNotNull(number)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        boolean result = isPerfect(number);
        printToConsole.printMessage(Boolean.toString(result));
        return result;
    }

    public Point runTaskSeven(Point pointA, Point pointB) throws IncorrectDataException {
        if (!dataValidation.validatePointRange(pointA) ||
                !dataValidation.validatePointRange(pointB)) {
            throw new IncorrectDataException("Incorrect data. Enter an integer");
        }
        double distancePointA = calculateHypotenuse(pointA.getAxisX(), pointA.getAxisY());
        double distancePointB = calculateHypotenuse(pointB.getAxisX(), pointB.getAxisY());
        Point point = new Point();
        if (distancePointA > distancePointB) {
            printToConsole.printPoint(pointA, distancePointA);
            point = pointA;
        } else if (distancePointB > distancePointA) {
            printToConsole.printPoint(pointB, distancePointB);
            point = pointB;
        } else {
            printToConsole.printMessage("The distance is the same");
        }
        return point;
    }

    public double calculateHypotenuse(double axisX, double axisY) {
        return Math.hypot(axisX, axisY);
    }

    public boolean isPerfect(int number) {
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum == number;
    }

    public boolean isEvenNumber(int number) {
        return number % TWO == 0;
    }

    public double calculateSquare(double value) {
        return Math.pow(value, TWO);
    }
}
