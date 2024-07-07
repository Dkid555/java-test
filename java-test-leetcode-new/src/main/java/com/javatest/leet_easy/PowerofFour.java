package com.javatest.leet_easy;

public class PowerofFour {

    public static boolean isPowerOfFour(int n) {
        if (n == 1) return true;
        if ((n & 1) == 1 || n < 0) return false;
        int count = 0;
        String BitString = Integer.toBinaryString(n);
        for (int i = BitString.length() - 2; i > -1; i--) {
            if (BitString.charAt(i) == '1' && ((BitString.length() - 1) - i) % 2 != 0) return false;
            if (BitString.charAt(i) == '1' && ((BitString.length() - 1) - i) % 2 == 0) ++count;
        }
        return count == 1;
    }

    public static boolean isPowerOfFour3(int n) {
        //n is greater than 0, n is even, (n - 1) mod 3 = 0
        return (n > 0) && ((n & (n - 1)) == 0) && ((n - 1) % 3 == 0);
    }
    // if n = 4 ^ x => n - 1 mod 3 == 0 mod 3 <=> n = 1 mod 3;


    public static boolean isPowerofFour2(int n) {
        if (n == 1) return true;
        if ((n & 1) == 1 || n < 0) return false;
        int count = 0;
        while (n > 0) {
            n >>= 1;
            if ((n & 1) == 0)
                ++count;
        }
        return count % 2 == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfFour3((10)));
    }
}
