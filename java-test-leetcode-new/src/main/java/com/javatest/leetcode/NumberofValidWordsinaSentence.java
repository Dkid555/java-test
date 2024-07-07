package com.javatest.leetcode;

public class NumberofValidWordsinaSentence {
    private static boolean checkChar(char ch) {
        return (int) ch >= 97 && (int) ch <= 122;
    }

    public static int countValidWords(String sentence) {
        int count = 0;
        for (String word : sentence.split(" ")) {
            if (word == " " || (word == ""))
                continue;
            boolean check = true;
            int defis = 0;
            for (int i = 0; i < word.length(); ++i) {
                if (word.charAt(i) == '.' || word.charAt(i) == '!' || word.charAt(i) == ',') {
                    if (i != word.length() - 1) {
                        check = false;
                        break;
                    }
                } else if (word.charAt(i) == '-') {
                    ++defis;
                    if (defis > 1 || (i == 0 || i == word.length() - 1) || (!checkChar(word.charAt(i - 1)) || !checkChar(word.charAt(i + 1)))) {
                        check = false;
                        break;
                    }
                } else if (!checkChar(word.charAt(i))) {
                    check = false;
                    break;
                }
            }
            if (check)
                ++count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countValidWords("he bought 2 pencils, 3 erasers, and 1  pencil-sharpener."));
    }
}
