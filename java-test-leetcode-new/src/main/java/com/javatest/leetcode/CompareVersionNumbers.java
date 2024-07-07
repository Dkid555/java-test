package com.javatest.leetcode;

public class CompareVersionNumbers {
    public static int compareVersion(String version1, String version2) {
        String[] versionFirst = version1.split("\\.");
        String[] versionSecond = version2.split("\\.");
        int i = 0;
        while (i < versionFirst.length && i < versionSecond.length) {
            //int num1 = Integer.parseInt(versionFirst[i]), num2 = Integer.parseInt(versionSecond[i]);
            int compare = Integer.compare(Integer.parseInt(versionFirst[i]), Integer.parseInt(versionSecond[i++]));
            if (compare != 0)
                return compare;
        }
        if (i < versionSecond.length)
            for (; i < versionSecond.length; ++i) {
                if (Integer.parseInt(versionSecond[i]) != 0)
                    return -1;
            }
        else if (i < versionFirst.length) {
            for (; i < versionFirst.length; ++i) {
                if (Integer.parseInt(versionFirst[i]) != 0)
                    return 1;
            }

        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.0.1", "1.0.1"));
    }
}
