package com.javatest.meta.other;

public class ElementSwapping {
    public int[] findMinArray(int[] arr, int k) {
        for (int i = 0; i < arr.length && k > 0; i++) {
            int minIndex = findMinAtDistanceK(arr, i, k);
            // Если минимальный элемент уже находится на позиции i, ничего не нужно делать
            if (minIndex == i) {
                continue;
            }
            // Обмен значениями между позициями i и minIndex
            swap(arr, i, minIndex);
            // Мы использовали k смещений для добора minIndex к позиции i
            k -= minIndex - i;
        }
        return arr;
    }

    // Поиск минимального элемента на расстоянии k от начальной позиции
    private int findMinAtDistanceK(int[] arr, int start, int k) {
        int index = 0, min = Integer.MAX_VALUE;
        // Находим минимальный элемент на расстоянии k от start
        for (int i = start; i <= start + k; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }

    // Обмен значениями между start и end
    private void swap(int[] arr, int start, int end) {
        // Перемещение элемента на позиции end к позиции start
        while (end > start) {
            int temp = arr[end];
            arr[end] = arr[end - 1];
            arr[end - 1] = temp;
            end--;
        }
    }

}
//Given a sequence of n integers arr, determine the lexicographically
// smallest sequence which may be obtained from it after performing
// at most k element swaps, each involving a pair of consecutive elements in the sequence.
//Note: A list x is lexicographically smaller than a different equal-length
// list y if and only if, for the earliest index at which the two lists differ,
// x's element at that index is smaller than y's element at that index.