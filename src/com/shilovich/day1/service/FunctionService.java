package com.shilovich.day1.service;

import com.shilovich.day1.entity.Point;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidator;

public class FunctionService {

    private static final double TWO = 2;
    private static final int TEN = 10;

    public double runTaskOne(double value) throws IncorrectDataException {
        EnteredDataValidator dataValidation = new EnteredDataValidator();
        if (!dataValidation.validateInteger(value) || !dataValidation.validateNotNull(value)) {
            throw new IncorrectDataException("Incorrect data. Enter an integer");
        }
        double result = calculateSquare(value % TEN) % TEN;
        return result;
    }

    public boolean runTaskFour(int... numbers) throws IncorrectDataException {
        EnteredDataValidator dataValidation = new EnteredDataValidator();
        if (!dataValidation.validateArrayForZeroValues(numbers)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        int flag = 0;
        for (int number : numbers) {
            if (isEvenNumber(number)) {
                flag++;
            }
        }
        boolean result = flag >= TWO;
        return result;
    }

    public boolean runTaskFive(int number) throws IncorrectDataException {
        EnteredDataValidator dataValidation = new EnteredDataValidator();
        if (!dataValidation.validateNotNull(number)) {
            throw new IncorrectDataException("Incorrect data. Enter not null value");
        }
        boolean result = isPerfect(number);
        return result;
    }

    public Point runTaskSeven(Point pointA, Point pointB) throws IncorrectDataException {
        EnteredDataValidator dataValidation = new EnteredDataValidator();
        if (!dataValidation.validatePointRange(pointA) ||
                !dataValidation.validatePointRange(pointB)) {
            throw new IncorrectDataException("Incorrect data. Enter an integer");
        }
        double distancePointA = calculateHypotenuse(pointA.getAxisX(), pointA.getAxisY());
        double distancePointB = calculateHypotenuse(pointB.getAxisX(), pointB.getAxisY());
        Point point = distancePointA > distancePointB ? pointA : pointB;
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
