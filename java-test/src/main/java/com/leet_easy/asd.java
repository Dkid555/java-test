package com.leet_easy;

public class asd {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4};
        int result = 0;
        for (int number : numbers) {
            result *= number;
        }
        System.out.println(result);
//        doTh("12");

        int[] a = new int[]{1, 2, 3, 4};
        int[] b = new int[]{1, 4, 5, 6};
        int[] r = merge(a, b);

    }

    static int[] merge(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        for (int i = 0; i < a.length; i++) {
            res[2 * i] = a[i];
            res[2 * i + 1] = b[i];
        }
        return res;
    }
//    public static int doTh(String n){
//        try {
//            int i = Integer.parseInt(n);
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return i;

//    }
}
