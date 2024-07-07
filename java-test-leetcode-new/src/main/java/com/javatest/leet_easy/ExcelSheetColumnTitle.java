package com.javatest.leet_easy;

// converting column names of excel to numbers and reverse

public class ExcelSheetColumnTitle {

    ///works
    public static String convertToTitle2(int columnNumber) {
        StringBuilder result = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            result.insert(0, (char) ('A' + (columnNumber % 26)));
            columnNumber = columnNumber / 26;
        }
        return result.toString();
    }

    public static int convertToInt(String columnname) {
        int count = 0;
        for (int i = columnname.length() - 1; i > -1; --i) {
            count += (columnname.charAt(i) - 'A' + 1) * Math.pow(26, columnname.length() - 1 - i);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle2(16199));
        System.out.println(convertToInt("WYA"));
    }
}
