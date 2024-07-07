package com.javatest.leet_easy;

public class StudentAttendanceRecordI {
    public static boolean checkRecord(String s) {
        int checkA = 0;
        int checkL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                checkA++;
                if (checkA == 2)
                    return false;
            } else if (s.charAt(i) == 'L') {
//                checkL++;
                while (i < s.length() && s.charAt(i) == 'L') {
                    i++;
                    checkL++;
                }
                i--;
                if (checkL >= 3) {
                    return false;
                }
                checkL = 0;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkRecord("PPALLL"));
    }
}
