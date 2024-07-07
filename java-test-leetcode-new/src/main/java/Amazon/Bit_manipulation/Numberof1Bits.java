package com.Amazon.Bit_manipulation;

public class Numberof1Bits {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0){
            if(n % 2 == 1)
                ++count;
            n >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(hammingWeight(5));
    }
}
