package com.meta;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class Kaitenzushi {


    // Метод для подсчета количества съеденных блюд
    public static int getMaximumEatenDishCount(int N, int[] D, int K) {
        Set<Integer> eaten = new HashSet<>(); // Множество для хранения типов съеденных блюд
        Deque<Integer> window = new ArrayDeque<>(); // Дек для отслеживания последних K съеденных блюд
        int count = 0; // Счетчик съеденных блюд

        // Проходим по каждому блюду
        for (int dish : D) {
            // Если тип блюда не был съеден ранее
            if (!eaten.contains(dish)) {
                // Если размер окна достиг максимального значения K, удаляем самое старое блюдо из окна
                if (window.size() == K) {
                    eaten.remove(window.pollFirst());
                }
                // Добавляем текущее блюдо в окно
                window.offerLast(dish);
                // Добавляем тип текущего блюда в множество съеденных блюд
                eaten.add(dish);
                // Увеличиваем счетчик съеденных блюд
                count++;
            }
        }

        return count;
    }

    public static int getMaximumEatenDishCount2(int N, int[] D, int K) {
        int count = 0;
        Deque<Integer> sliding_window = new ArrayDeque<>();
        Set<Integer> eaten_dishes = new HashSet<>();
        for (int dish : D) {
            if (!eaten_dishes.contains(dish)) {
                if (sliding_window.size() == K) {
                    eaten_dishes.remove(sliding_window.pollFirst());
                }
                sliding_window.offerLast(dish);
                eaten_dishes.add(dish);
                ++count;
            }
            eaten_dishes.add(dish);
        }
        return count;
    }


    public static void main(String[] args) {
        int[] D = new int[]{1, 2, 3, 3, 2, 1};
        int N = 6;
        int K = 2;
        System.out.println(getMaximumEatenDishCount(N, D, K));
    }
}
//There are N dishes in a row on a kaiten belt, with the ith dish being of type D. Some dishes may be of the same type as one another.
//You're very hungry, but you'd also like to keep things interesting. The N dishes will arrive in front of you,
// one after another in order, and for each one you'll eat it as long as it isn't the same type as any of the previous
// K dishes you've eaten. You eat very fast, so you can consume a dish before the next one gets to you.
// Any dishes you choose not to eat as they pass will be eaten by others. Determine how many dishes you'll end up eating.
//Please take care to write a solution which runs within the time limit.