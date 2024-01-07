package com.leetcode;

public class ShiftingLettersII {
    public static String shiftingLetters(String s, int[][] shifts) {
        StringBuilder stringBuilder = new StringBuilder(s);
        for (int[] shift : shifts) {
            for (int i = shift[0]; i <= shift[1]; ++i) {
                int indexChar = (stringBuilder.substring(i, i + 1).toCharArray()[0]
                        - (shift[2] == 0 ? 1 : (-1)));
                if (indexChar < 97) {
                    indexChar += 26;
                } else if (indexChar > 122) {
                    indexChar -= 26;
                }
                stringBuilder.replace(i, i + 1,
                        String.valueOf((char)
                                (indexChar)));
            }
        }
        return stringBuilder.toString();
    }

    public String shiftingLettersBetter(String s, int[][] shifts) {
        char[] ch = s.toCharArray();
        int[] count = new int[s.length() + 1];

        for (int[] shift : shifts) {
            int value = shift[2] == 1 ? 1 : -1;
            count[shift[0]] += value;
            count[shift[1] + 1] -= value;
        }

        int sum = 0;
        for (int i = 0; i < count.length - 1; i++) {
            sum += count[i];
            int newChar = ((ch[i] - 'a') + sum) % 26;
            if (newChar < 0) newChar += 26;
            ch[i] = (char) ('a' + newChar);
        }

        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(shiftingLetters("asd", new int[][]{{0, 0, 0}, {1, 1, 1}}));
    }//
}
