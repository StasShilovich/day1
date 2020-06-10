package com.shilovich.day1.service;

import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidator;

import java.util.ArrayList;
import java.util.List;

public class FigureService {
    private static final double TWO = 2;

    private static final EnteredDataValidator dataValidation = new EnteredDataValidator();

    public List<Double> runTaskThree(double square) throws IncorrectDataException {
        if (!dataValidation.validateValueAboveZero(square) || !dataValidation.validateNotNull(square)) {
            throw new IncorrectDataException("Incorrect data. Enter the correct area");
        }
        double sideOut = Math.sqrt(square);
        double sideIn = sideOut / Math.sqrt(TWO);
        double inscribedSquare = Math.pow(sideIn, TWO);
        double ratio = square / inscribedSquare;
        List<Double> results = new ArrayList<>();
        results.add(inscribedSquare);
        results.add(ratio);
        return results;
    }

    public List<Double> runTaskNine(double radius) throws IncorrectDataException {
        if (!dataValidation.validateValueAboveZero(radius) || !dataValidation.validateNotNull(radius)) {
            throw new IncorrectDataException("Incorrect data. Enter the correct radius");
        }
        double circumference = TWO * Math.PI * radius;
        double area = Math.PI * Math.pow(radius, 2d);
        List<Double> results = new ArrayList<>();
        results.add(circumference);
        results.add(area);
        return results;
    }
}
