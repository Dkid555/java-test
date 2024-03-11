package com.meta;

import java.util.HashSet;
import java.util.Set;

public class MatchingPairs {
    int matchingPairs(String s, String t) {
        // Создание множества для хранения несоответствий
        Set<String> mismatchS = new HashSet<>();
        // Преобразование строк в массивы символов
        char[] sToChar = s.toCharArray();
        char[] tToChar = t.toCharArray();
        // Инициализация счетчика совпадений
        int matching = 0;

        // Проверка каждой пары символов из строк
        for (int i = 0; i < sToChar.length; i++) {
            if (sToChar[i] != tToChar[i]) {
                // Если символы не совпадают, добавляем их в множество несоответствий
                mismatchS.add(sToChar[i] + "" + tToChar[i]);
            } else {
                // Иначе увеличиваем счетчик совпадений
                matching++;
            }
        }

        // Проверка наличия обратного несоответствия для каждого элемента в множестве
        for (String mism : mismatchS) {
            String reverse = mism.charAt(1) + "" + mism.charAt(0);
            if (mismatchS.contains(reverse)) {
                // Если обратное несоответствие найдено, возвращаем количество совпадений плюс 2
                return matching + 2;
            }
        }

        // Уменьшение количества совпадений на основе условий
        if (mismatchS.size() <= 1)
            matching--;
        if (mismatchS.isEmpty())
            matching--;

        // Возвращаем итоговое количество совпадений
        return matching;
    }

    
}
//Given two strings s and t of length N, find the maximum number
// of possible matching pairs in strings s and t after swapping exactly two characters within s.
//A swap is switching s[i] and s[j], where s[i] and s[j] denotes the character that is present
// at the ith and jth index of s, respectively.
// The matching pairs of the two strings are defined as the number of indices for which s[i] and t[i] are equal.
//Note: This means you must swap two characters at different indices.
//Signature
//int matchingPairs(String s, String t)
//Input
//s and t are strings of length N
//N is between 2 and 1,000,000
//Output
//Return an integer denoting the maximum number of matching pairs