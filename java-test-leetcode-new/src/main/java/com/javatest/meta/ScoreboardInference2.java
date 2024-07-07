package com.javatest.meta;

public class ScoreboardInference2 {
    public static int getMinProblemCount(int[] S) {
        boolean hasOne = false; // Флаг наличия результата, равного 1
        boolean hasOneRemainder = false; // Флаг наличия остатка от деления на 3, равного 1
        boolean hasTwoRemainder = false; // Флаг наличия остатка от деления на 3, равного 2
        int max = 0; // Максимальный результат
        int secondMax = 0; // Второй по величине результат

        // Проходим по всем результатам
        for (int score : S) {
            hasOne = hasOne || score == 1; // Обновляем флаг hasOne
            hasOneRemainder = hasOneRemainder || score % 3 == 1; // Обновляем флаг hasOneRemainder
            hasTwoRemainder = hasTwoRemainder || score % 3 == 2; // Обновляем флаг hasTwoRemainder

            // Обновляем максимальный и второй по величине результаты
            if (score > max) {
                secondMax = max;
                max = score;
            } else if (score > secondMax) {
                secondMax = score;
            }
        }

        // Вычисляем начальное количество задач
        int count = max / 3 + (hasOneRemainder ? 1 : 0) + (hasTwoRemainder ? 1 : 0);

        // Заменяем последнюю тройку задач на одну задачу с оценкой 1 и одну с оценкой 2
        if (hasOneRemainder && hasTwoRemainder && max % 3 == 0) {
            count--;
        }

        // Если нет задач с оценкой 1, но есть задачи с оценкой 1 и 2, и максимальный результат имеет остаток 1 от деления на 3
        if (!hasOne && hasOneRemainder && hasTwoRemainder && max % 3 == 1) {
            // Проверяем, насколько максимальный результат отличается от второго по величине результата
            int diff = max - secondMax;
            if (diff != 1 && diff != 3) {
                count--; // Уменьшаем количество задач
            }
        }

        return count;
    }
}
//You are spectating a programming contest with N competitors, each trying to independently solve the same
// set of programming problems. Each problem has a point value, which is either 1, 2, or 3.
//On the scoreboard, you observe that the i-th competitor has attained a score of S-i ,
// which is a positive integer equal to the sum of the point values of all the problems they have solved.
//The scoreboard does not display the number of problems in the contest, nor their point values.
// Using the information available, you would like to determine the minimum possible number of problems in the contest.
