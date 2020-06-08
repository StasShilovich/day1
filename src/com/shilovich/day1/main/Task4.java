package com.shilovich.day1.main;

import com.shilovich.day1.service.FunctionService;

public class Task4 {
    public static void main(String[] args) {
        FunctionService functionService = new FunctionService();
        int firstNumber = 2;
        int secondNumber = 5;
        int thirdNumber = -4;
        int fourthNumber = 7;
        functionService.runTaskFour(firstNumber, secondNumber, thirdNumber, fourthNumber);
    }
}
