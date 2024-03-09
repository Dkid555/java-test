package com.meta;

import java.util.Arrays;

public class ScoreboardInference1 {
    public int getMinProblemCount(int N, int[] S) {
        // Сортировка массива S по возрастанию
        Arrays.sort(S);

        int min_problems = 0;

        if (S[S.length - 1] == 1)
            return 1;
        if (S[S.length - 1] % 2 == 1) {// Если максимальный элемент массива S нечетный
            // Вычисляем min_problems, если максимальный элемент массива S нечетный
            min_problems = S[S.length - 1] / 2 + 1;
        } else {
            // Вычисляем min_problems, если максимальный элемент массива S четный
            min_problems = S[S.length - 1] / 2;

            for (int score : S) {
                if (score % 2 == 1) {
                    // Если текущий элемент массива S нечетный, увеличиваем min_problems на 1 и прерываем цикл
                    ++min_problems;
                    break;
                }
            }
        }
        return min_problems;
    }


    public int getMinProblemCount2(int N, int[] S) {
        int max_element = Integer.MIN_VALUE;
        boolean check_odd = false;
        for (int score : S) { // ищем максимальное значение S
            max_element = Math.max(max_element, score);
            if (!check_odd && score % 2 == 1) // проверяем наличие нечетного элемента
                check_odd = true;
        }
        int min_problems = 0;
        if (max_element == 1)
            return 1;
        if (max_element % 2 == 1) {// Если максимальный элемент массива S нечетный
            // Вычисляем min_problems, если максимальный элемент массива S нечетный
            min_problems = max_element / 2 + 1;
        } else {
            // Вычисляем min_problems, если максимальный элемент массива S четный
            min_problems = max_element / 2;
            if (check_odd)
                ++min_problems;
        }
        return min_problems;
    }
}
//You are spectating a programming contest with N competitors, each trying to independently
// solve the same set of programming problems. Each problem has a point value, which is either 1 or 2.
//On the scoreboard, you observe that the ith competitor has attained a score of S i, which is a positive integer
// equal to the sum of the point values of all the problems they have solved.
//The scoreboard does not display the number of problems in the contest, nor their point values.
// Using the information available, you would like to determine the minimum possible number of problems in the contest.