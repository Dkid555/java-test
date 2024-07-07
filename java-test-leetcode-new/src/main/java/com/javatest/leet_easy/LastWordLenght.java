package com.javatest.leet_easy;

public class LastWordLenght {
    public static int lengWord(String str) {
        String[] fin = str.split(" ");
        return fin[fin.length - 1].length();
    }

    public static void main(String[] args) {
        String str = "Hello World ";
        System.out.println(lengWord(str));
    }

/* or manually
*  public int lengthOfLastWord(String s) {
        int indexOfNonSpace = s.length() - 1;

        while(indexOfNonSpace > 0) {
            if (s.charAt(indexOfNonSpace) != ' ') {
                break;
            }
            indexOfNonSpace--;
        }

        int lengthOfLastWord = 0;
        for (int i = indexOfNonSpace; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                lengthOfLastWord++;
            } else {
                break;
            }

        }

        return lengthOfLastWord;
    }
*
*
* */
}
