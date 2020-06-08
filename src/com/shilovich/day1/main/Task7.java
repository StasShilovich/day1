package com.shilovich.day1.main;

import com.shilovich.day1.entity.Point;
import com.shilovich.day1.service.FunctionService;

public class Task7 {
    public static void main(String[] args) {
        FunctionService functionService = new FunctionService();
        Point pointA = new Point();
        pointA.setAxisX(5);
        pointA.setAxisY(6);
        Point pointB = new Point();
        pointB.setAxisX(5);
        pointB.setAxisY(6);
        functionService.runTaskSeven(pointA, pointB);
    }
}
