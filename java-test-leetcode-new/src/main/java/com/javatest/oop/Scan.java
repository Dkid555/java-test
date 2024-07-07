package com.javatest.oop;

import java.util.Scanner;

enum EnumTest {
    LOW,
    MEDIUM,
    HIGH;
}

public class Scan {
    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        System.out.println("Enter User: ");
        String user = str.nextLine();
        System.out.println("User is: " + user);
        //str = new Scanner(System.in);

        EnumTest x = EnumTest.LOW;
        switch (x) {
            case LOW:
                System.out.println("low level");
                break;
            case MEDIUM:
                System.out.println("Medium");
                break;
            case HIGH:
                System.out.println("High");
                break;

        }

        //System.out.println(x);
    }
}
