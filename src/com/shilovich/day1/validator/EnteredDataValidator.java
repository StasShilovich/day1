package com.shilovich.day1.validator;

import com.shilovich.day1.entity.Point;

public class EnteredDataValidator {

    private static final int HUNDRED = 100;

    public boolean validateInteger(double value) {
        boolean result = false;
        if (value % 1 == 0) {
            result = true;
        }
        return result;
    }

    public boolean validateNotNull(double value) {
        boolean result = false;
        if (value != 0) {
            result = true;
        }
        return result;
    }

    public boolean validatePointRange(Point point) {
        boolean result = false;
        if (Math.abs(point.getAxisX()) <= HUNDRED && Math.abs(point.getAxisY()) <= HUNDRED) {
            result = true;
        }
        return result;
    }

    public boolean validateValueAboveZero(double value) {
        boolean result = false;
        if (value > 0) {
            result = true;
        }
        return result;
    }

    public boolean validateLineSegment(double startPoint, double endPoint) {
        boolean result = false;
        if (startPoint < endPoint) {
            result = true;
        }
        return result;
    }
}
