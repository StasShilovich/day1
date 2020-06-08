package com.shilovich.day1.service;

import com.shilovich.day1.console.PrintToConsole;
import com.shilovich.day1.exception.IncorrectDataException;
import com.shilovich.day1.validator.EnteredDataValidation;

public class FigureService {
    private static final double TWO = 2;

    private static final EnteredDataValidation dataValidation = new EnteredDataValidation();
    private static final PrintToConsole printToConsole = new PrintToConsole();

    public void runTaskThree(double square) {
        try {
            if (!dataValidation.validateValueAboveZero(square) || !dataValidation.validateNotNull(square)) {
                throw new IncorrectDataException("Incorrect data. Enter the correct area");
            }
            double sideOut = Math.sqrt(square);
            double sideIn = sideOut / Math.sqrt(TWO);
            double inscribedSquare = Math.pow(sideIn, TWO);
            double ratio = square / inscribedSquare;
            printToConsole.printInscribedSquare(inscribedSquare);
            printToConsole.printRatio(ratio);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
    }

    public void runTaskNine(double radius) {
        try {
            if (!dataValidation.validateValueAboveZero(radius) || !dataValidation.validateNotNull(radius)) {
                throw new IncorrectDataException("Incorrect data. Enter the correct radius");
            }
            double circumference = TWO * Math.PI * radius;
            double area = Math.PI * Math.pow(radius, 2d);
            printToConsole.printCircumference(circumference);
            printToConsole.printArea(area);
        } catch (IncorrectDataException e) {
            printToConsole.printMessage(e.getMessage());
        }
    }
}
