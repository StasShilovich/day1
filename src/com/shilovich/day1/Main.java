package com.shilovich.day1;

import com.shilovich.day1.task1.LastDigitOfTheSquare;
import com.shilovich.day1.task10.Tangent;
import com.shilovich.day1.task2.NumberOfADays;
import com.shilovich.day1.task3.InscribedSquare;
import com.shilovich.day1.task4.EvenNumbers;
import com.shilovich.day1.task5.PerfectNumber;
import com.shilovich.day1.task6.SecondsToHours;
import com.shilovich.day1.task7.Point;
import com.shilovich.day1.task7.PointCompare;
import com.shilovich.day1.task8.Calculations;
import com.shilovich.day1.task9.CircleCalculations;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        //Task1
        LastDigitOfTheSquare lastDigitOfTheSquare = new LastDigitOfTheSquare();
        System.out.println(lastDigitOfTheSquare.find(34));
        //Task2
        NumberOfADays numberOfADays = new NumberOfADays(2019, 2);
        System.out.println(numberOfADays.getQuantity());
        //Task3
        InscribedSquare inscribedSquare = new InscribedSquare(4);
        System.out.println(inscribedSquare.getSquareArea());
        System.out.println(inscribedSquare.ratio());
        //Task4
        EvenNumbers evenNumbers = new EvenNumbers(2, 3, 4, 7);
        System.out.println(evenNumbers.isMoreThenTwoEven());
        //Task5
        PerfectNumber perfectNumber = new PerfectNumber();
        System.out.println(perfectNumber.isPerfect(6));
        //Task6
        SecondsToHours secondsToHours = new SecondsToHours();
        System.out.println(secondsToHours.transformSecondsToHours(123123));
        //Task7
        Point A = new Point(4, 5);
        Point B = new Point(5, 5);
        PointCompare pointCompare = new PointCompare(A, B);
        System.out.println(pointCompare.compare());
        //Task8
        Calculations calculations = new Calculations();
        System.out.println(calculations.calculate(2));
        //Task9
        CircleCalculations circleCalculations = new CircleCalculations(5);
        System.out.println(circleCalculations.calculateCircumference() + " " + circleCalculations.calculateArea());
        //Task10
        Tangent tangent = new Tangent(2, 10, 1);
        tangent.printTangentGraph();

    }
}
