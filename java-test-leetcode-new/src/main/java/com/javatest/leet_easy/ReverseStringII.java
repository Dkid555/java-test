package com.javatest.leet_easy;

public class ReverseStringII {
    public static String reverseStr(String string, int k) {
        StringBuilder fin = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); i += 2 * k) {
            // индекс последнего элемента который меняем
            int endOfChange = Math.min(i + k, string.length());

            StringBuilder temp = new StringBuilder(string.substring(i, endOfChange));
            temp.reverse();
            fin.append(temp);
            // индекс последнего элемента, который остается
            int endUnChange = Math.min(i + 2 * k, string.length());

            // можно в stringbuilder сразу вставлять сабстринг
            fin.append(string, endOfChange, endUnChange);
        }
        return fin.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("lol kek", 2));
    }

}

//Given a string s and an integer k, reverse
// the first k characters for every 2k characters
// counting from the start of the string.
//
//If there are fewer than k characters left, reverse all of them.
// If there are less than 2k but greater than or equal to k characters,
// then reverse the first k characters and leave the other as original.