package com.shilovich.day1.main;

import com.shilovich.day1.service.ArithmeticService;

public class Task10 {
    public static void main(String[] args) {
        ArithmeticService arithmeticService = new ArithmeticService();
        int startPoint = 2;
        int endPoint = 10;
        double step = 0.5;
        arithmeticService.runTaskTen(startPoint, endPoint, step);
    }
}
