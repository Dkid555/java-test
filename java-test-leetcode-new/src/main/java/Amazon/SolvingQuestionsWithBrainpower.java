package com.Amazon;

import java.util.Arrays;

public class SolvingQuestionsWithBrainpower {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        Arrays.fill(dp, -1L);
        return helper(questions, 0, dp);
    }

    public long helper(int[][] questions, int index, long[] dp) {
        if (index >= questions.length) return 0L;
        if (dp[index] != -1L) return dp[index];

        long solve = questions[index][0] + helper(questions, index + questions[index][1] + 1, dp);
        long skip = helper(questions, index + 1, dp);

        return dp[index] = Math.max(solve, skip);
    }
}
//You are given a 0-indexed 2D integer
// array questions where questions[i] = [pointsi, brainpoweri].
//
//The array describes the questions of an exam, where
// you have to process the questions in order (i.e.,
// starting from question 0) and make a decision whether to solve
// or skip each question. Solving question i will earn you pointsi
// points but you will be unable to solve each of the next brainpoweri
// questions. If you skip question i, you get to make the decision on the next question.
//
//For example, given questions = [[3, 2], [4, 3], [4, 4], [2, 5]]:
//If question 0 is solved, you will earn 3 points but you will be unable to solve questions 1 and 2.
//If instead, question 0 is skipped and question 1 is solved, you will
// earn 4 points but you will be unable to solve questions 2 and 3.
//Return the maximum points you can earn for the exam.