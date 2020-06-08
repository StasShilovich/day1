package com.shilovich.day1.main;

import com.shilovich.day1.service.TimeService;

public class Task2 {
    public static void main(String[] args) {
        TimeService timeService = new TimeService();
        String year = "2000";
        String month = "2";
        int quantity = timeService.runTaskTwo(year, month);
    }
}
