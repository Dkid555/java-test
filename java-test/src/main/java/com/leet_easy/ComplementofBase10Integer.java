package com.leet_easy;

public class ComplementofBase10Integer {
    public static int bitwiseComplement(int n) {
        if (n == 0) return 1;
        StringBuilder str = new StringBuilder(Integer.toBinaryString(n));
        boolean check = false;
        for (int i = 0; i < str.length(); i++) {
            if (!check && str.charAt(i) == '1') {
                check = true;
                str.setCharAt(i, '0');
            } else if (check && str.charAt(i) == '1') {
                str.setCharAt(i, '0');
            } else if (check && str.charAt(i) == '0') {
                str.setCharAt(i, '1');
            }
        }
        return Integer.parseInt(str.toString(), 2);
    }

    public static int bitwiseComplement2(int n) {
        if (n == 0) return 1;
        int m = n;
        int mask = 0;

        while (m != 0) {
            mask = (mask << 1) | 1; // calculating mask
            m = m >> 1;
        }
        return ~n & mask;
    }

    public static void main(String[] args) {
        System.out.println(bitwiseComplement(5));
    }
}
