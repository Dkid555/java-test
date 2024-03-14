package com.meta.other;

import java.util.HashMap;

public class WaystoSplitArrayIntoGoodSubarrays {
    public int numberOfGoodSubarraySplits(int[] nums) {
        // Инициализация переменной result для хранения количества "хороших" разбиений подмассивов
        long result = 0;
        // Определение значения MOD для операции взятия остатка
        long MOD = 1000000007;

        // Итерация по массиву
        for (int i = 0, l = -1; i < nums.length; i++) {
            // Если текущий элемент не равен нулю
            if (nums[i] != 0) {
                // Если l не инициализировано (-1),
                // устанавливаем его равным текущему индексу i и инициализируем result равным 1
                if (l == -1) {
                    l = i;
                    result = 1;
                } else {
                    // Если l уже инициализировано, обновляем result, умножив его на разницу между текущим индексом и l
                    result *= i - l;
                    // Берем остаток, чтобы предотвратить переполнение
                    result %= MOD;
                    // Обновляем l до текущего индекса i
                    l = i;
                }
            }
        }

        // Преобразуем окончательный результат в int и возвращаем
        return (int) result;
    }
}
