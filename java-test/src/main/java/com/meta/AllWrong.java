package com.meta;

public class AllWrong {
    public String getWrongAnswers(int N, String C) {
        // Write your code here


        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; ++i) {
            result.append(C.charAt(i) == 'A' ? 'B' : 'A');
        }

        return result.toString();
    }
}
