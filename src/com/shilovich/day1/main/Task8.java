package com.shilovich.day1.main;

import com.shilovich.day1.service.ArithmeticService;

public class Task8 {
    public static void main(String[] args) {
        ArithmeticService arithmeticService=new ArithmeticService();
        int number=2;
        double result=arithmeticService.runTaskEight(number);
    }
}
