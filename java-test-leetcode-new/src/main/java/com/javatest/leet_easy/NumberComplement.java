package com.javatest.leet_easy;

public class NumberComplement {

    public static int findComplement(int num) {
        int NumberOfBits = (int) Math.floor((Math.log(num) / Math.log(2)) + 1); // считаем количество битов, заполненых до нуля
        int Mask = (1 << NumberOfBits) - 1;
        System.out.println("Mask: " + Integer.toBinaryString(Mask));
        System.out.println("Num: " + Integer.toBinaryString(num));
        System.out.println("~Num: " + Integer.toBinaryString(~num));
        return ~num & Mask;
    }

    public static int findComplement2(int num) {
        // -1 так как мы его все равно перевернем,
        // а нам надо в сравнении найти пустые, не заполненые (без нулей до крайнего левого бита)
        return ~num & (Integer.highestOneBit(num) - 1);
    }

    public static void main(String[] args) {
        System.out.println(findComplement2(5));
    }
}
//The complement of an integer is the integer you get when you
// flip all the 0's to 1's and all the 1's to 0's in its binary representation.
//
//For example, The integer 5 is "101" in binary and its complement is "010" which is the integer 2.
//Given an integer num, return its complement.