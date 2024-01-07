package com.leetcode;

public class RemoveAllOccurrencesofaSubstring {
    public static String removeOccurrences(String s, String part) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int length = part.length();
        while (true) {
            int index = stringBuilder.indexOf(part);
            if (index != -1) {
                stringBuilder.delete(index, index + length);
            } else
                break;
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeOccurrences("axxxxyyyyb", "xy"));
    }
}
