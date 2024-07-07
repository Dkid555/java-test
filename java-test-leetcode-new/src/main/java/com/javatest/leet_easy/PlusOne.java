package com.javatest.leet_easy;

public class PlusOne {
    static int[] plus(int[] number) {
        for (int i = number.length - 1; i > -1; --i) {
            number[i] = number[i] + 1;
            if (number[i] == 10) {
                number[i] = 0;
            } else break;
        }
        if (number[0] == 0) {
            int[] fin = new int[number.length + 1];
            fin[0] = 1;
            return fin;
        }
        return number;
    }

    public static void main(String[] args) {
        int[] number = {9, 9, 9};
        plus(number);
    }
}
