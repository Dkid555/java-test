package com.meta;

import java.util.Arrays;

public class CollectingChocolates {
    public long minCost(int[] nums, int x) {
        // Создание копии исходного массива для хранения минимальных цен на конфеты
        int[] minPrice = Arrays.copyOf(nums, nums.length);
        // Инициализация переменной для хранения ответа с максимальным возможным значением
        long result = Long.MAX_VALUE;
        // Получение длины массива
        final int n = nums.length;

        // Исследование стоимости для 0 до n-1 сдвигов
        for (int k = 0; k < nums.length; ++k) {
            // Поиск минимальной цены для каждой конфеты
            // Вычисление общей стоимости для k сдвигов
            long total = (long) k * x;
            for (int i = 0; i < nums.length; ++i) {
                minPrice[i] = Math.min(minPrice[i], nums[(i - k + n) % n]);
                total += minPrice[i];
            }

            // Обновление минимальной общей стоимости
            result = Math.min(result, total);
        }

        // Возвращение минимальной общей стоимости
        return result;
    }

    public long minCost2(int[] nums, int x) {
        int n = nums.length;
        int[] memory = new int[n];
        long result = 0;

        // Инициализация memory и вычисление начальной суммы
        for (int i = 0; i < n; i++) {
            memory[i] = nums[i]; // заполняем значениями из nums
            result += (long) nums[i];
        }

        // Перебор количества сдвигов
        for (int i = 1; i < n; i++) { // количество сдвигов
            long sum = (long) i * (long) x; // вычисление суммы для текущего количества сдвигов

            // Обновление memory и вычисление суммы для текущего количества сдвигов
            for (int j = 0; j < n; j++) { // индекс
//                int curr_index = j + i >= n ? j + i - n : j + i;
                int curr_index = (j + i) % n;
                memory[j] = Math.min(memory[j], nums[curr_index]);
                sum += (long) memory[j];
            }

            // Обновление минимальной общей суммы
            result = Math.min(result, sum);
        }

        // Возвращение минимальной общей суммы
        return result;
    }
}
//You are given a 0-indexed integer array nums of size n representing
// the cost of collecting different chocolates. The cost of collecting
// the chocolate at the index i is nums[i]. Each chocolate is
// of a different type, and initially, the chocolate at the index i is of ith type.
//
//In one operation, you can do the following with an incurred cost of x:
//
//Simultaneously change the chocolate of ith type to ((i + 1) mod n)th type for all chocolates.
//Return the minimum cost to collect chocolates of all types,
// given that you can perform as many operations as you would like.