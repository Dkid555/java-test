package com.javatest.meta;

public class MissingMail {
    public double getMaxExpectedProfit(int N, int[] V, int C, double S) {
        double[] profit = new double[N + 1]; // Массив для хранения максимальной прибыли
        double maxProfit = 0.0; // Переменная для хранения максимальной прибыли

        for (int i = 0; i < N; i++) { // Внешний цикл для перебора элементов массива V
            double cumulativeProfit = 0.0; // Переменная для хранения накопленной прибыли
            for (int j = i; j < N; j++) { // Внутренний цикл для перебора оставшихся элементов массива V
                cumulativeProfit *= 1 - S; // Рассчитываем накопленную прибыль с учетом вероятности кражи
                cumulativeProfit += V[j]; // Добавляем текущую прибыль к накопленной
                profit[j + 1] = Math.max(profit[j + 1], profit[i] + cumulativeProfit - C); // Обновляем значение максимальной прибыли в текущем состоянии
            }
            maxProfit = Math.max(maxProfit, profit[i + 1]); // Обновляем максимальную прибыль
        }
        return maxProfit; // Возвращаем максимальную прибыль
    }

}