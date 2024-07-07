package com.javatest.leet_easy;

public class PowerofThree {
    public static boolean isPowerOfThree(int n) {
//        if(n == 1) return true;
//        if(n <= 0 || (n & 1) == 0) return false;
        long temp = 1;
        //System.out.println(Integer.toBinaryString((int)temp));
        while (n > 1 && temp < n) {
            temp += temp << 1;
            //System.out.println(Integer.toBinaryString((int)temp));
        }

        return temp == n;
    }

    // 3^20 > 2^31 - 1, but on the other way it's bigger than int, so our n is lower than 3^20 -> 3^19
    public static boolean isPowerOfThree2(int n) {
        return (n > 0 && 1162261467 % n == 0);
    }

    public static void main(String[] args) {
//        System.out.println(isPowerOfThree(3));
        System.out.println(Integer.toBinaryString(243));
        System.out.println(isPowerOfThree2(27));
    }
}
