package com.meta.other;

public class ANumberAfteraDoubleReversal {
    public static boolean isSameAfterReversals(int num) {

        StringBuilder num_str = new StringBuilder(String.valueOf(num));

        num_str.reverse();

        String res = num_str.toString().replaceFirst("^0+(?!$)", "");

        num_str = new StringBuilder(res).reverse();
        return Integer.parseInt(num_str.toString()) == num;

    }

    public static boolean isSameAfterReversals2(int num) {
        return Integer.parseInt(
                new StringBuilder(new StringBuilder(String.valueOf(num)).reverse().toString().
                        replaceFirst("^0+(?!$)", "")).reverse().toString()
        ) == num;

    }

    public static void main(String[] args) {
        System.out.println(isSameAfterReversals2(12550));
    }
}
