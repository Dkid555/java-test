package com.javatest.leet_easy;

public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
//        StringBuilder result = new StringBuilder(s);
        char[] result = new char[s.length()];
        int i = 0;
        for (int index = 0; index < s.length(); index++) {
            result[indices[index]] = s.charAt(index);
        }
        return String.valueOf(result);

        //char[] result = new char[s.length()];
        //        int i = 0;
        //        for (int index: indices
        //             ) {
        //            result[index] = s.charAt(i++);
        //        }
        //        return String.valueOf(result);
    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}
