package com.javatest.leet_easy;

import java.util.Arrays;

import static java.lang.Integer.parseInt;

public class DuplicateZeros {
    public static void duplicateZeros(int[] arr) {
        String str = "";
        for (int j : arr) str += j;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                str = str.substring(0, i + 1) + "0" + str.substring(i + 1, str.length() - 1);
                i++;
            }
        }
        int i = 0;
        for (int j = 0; j < str.length(); j++) {
            arr[i++] = parseInt(String.valueOf(str.charAt(j)));
        }
//        arr = Arrays.stream(str.split("")).mapToInt(Integer::parseInt).toArray();
//        return arr;
    }

    public static void duplicateZeros2(int[] arr) {
        int[] arrNew = new int[arr.length];
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            if (j == arr.length) break;
            if (arr[i] == 0) {
                arrNew[j++] = 0;
                if (j == arr.length) break;
                arrNew[j++] = 0;
            } else {
                arrNew[j++] = arr[i];
            }

        }

        j = 0;
        for (int ele : arrNew) {
            arr[j++] = ele;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 0, 4, 5, 0};
        duplicateZeros(arr);
//        System.out.println(Arrays.toString(duplicateZeros(arr)));
        System.out.println(Arrays.toString(arr));
    }
}
