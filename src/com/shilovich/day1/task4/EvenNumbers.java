package com.shilovich.day1.task4;

public class EvenNumbers {
    private int A;
    private int B;
    private int C;
    private int D;

    public EvenNumbers(int a, int b, int c, int d) {
        A = a;
        B = b;
        C = c;
        D = d;
    }

    public boolean isMoreThenTwoEven() {
        int flag = 0;
        if (A % 2 == 0) {
            flag++;
        }
        if (B % 2 == 0) {
            flag++;
        }
        if (C % 2 == 0) {
            flag++;
        }
        if (D % 2 == 0) {
            flag++;
        }
        boolean value = false;
        if (flag >= 2) {
            value = true;
        }
        return value;
    }
}
