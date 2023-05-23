package leetcode;

import java.util.Scanner;

public class Factorial {
    public static int factorial(int num){
        if(num == 1) return num;
        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        Scanner str = new Scanner(System.in);
        System.out.println("Input your number: ");
        String s = str.nextLine();
        int num = Integer.valueOf(s);
        System.out.println("Your Factorial is:  " + factorial(num));
        //System.out.println(Math.nextAfter());
    }
}
