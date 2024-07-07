package com.javatest.meta;

import java.util.Stack;

public class ContiguousSubarrays {
    // Метод для подсчета количества подмассивов
    public int[] countSubarrays(int[] arr) {
        // Создаем стек для хранения индексов элементов массива
        Stack<Integer> stack = new Stack<>();
        // Массив для хранения результата
        int[] result = new int[arr.length];

        // Проходим по массиву слева направо
        for (int i = 0; i < arr.length; i++) {
            // Пока стек не пуст и текущий элемент больше элемента на вершине стека
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // Увеличиваем количество подмассивов для текущего элемента
                result[i] += result[stack.pop()];
            }
            // Добавляем текущий индекс в стек
            stack.push(i);
            // Увеличиваем количество подмассивов для текущего элемента на 1
            result[i]++;
        }

        // Очищаем стек
        stack.clear();
        // Временный массив для хранения дополнительной информации
        int[] temp = new int[arr.length];

        // Проходим по массиву справа налево
        for (int i = arr.length - 1; i >= 0; i--) {
            // Пока стек не пуст и текущий элемент больше элемента на вершине стека
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // Получаем индекс элемента на вершине стека
                int idx = stack.pop();
                // Увеличиваем количество подмассивов для текущего элемента
                result[i] += temp[idx];
                // Увеличиваем количество подмассивов для текущего элемента во временном массиве
                temp[i] += temp[idx];
            }
            // Добавляем текущий индекс в стек
            stack.push(i);
            // Увеличиваем количество подмассивов для текущего элемента во временном массиве на 1
            temp[i]++;
        }

        // Возвращаем результат
        return result;
    }
}
//You are given an array arr of N integers. For each index i,
// you are required to determine the number of contiguous subarrays that fulfill the following conditions:
//The value at index i must be the maximum element in the contiguous subarrays, and
//These contiguous subarrays must either start from or end on index i.
//Signature
//int[] countSubarrays(int[] arr)
//Input
//Array arr is a non-empty list of unique integers that range between 1 to 1,000,000,000
//Size N is between 1 and 1,000,000
//Output
//An array where each index i contains an integer denoting the maximum number of contiguous subarrays of arr[i]