package com.javatest.meta;

import java.util.Arrays;

public class Cafeteria {
    public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {
        Arrays.sort(S);

        long extra_guests = 0; // финальное количество гостей
        long start = 1; //стол от которого мы стартуем
        long range; // расстояние от начала до занятого стола

        for (long seatedDiner : S) {
            range = seatedDiner - start; // количество столов от старта до стола где уже сидит клиент
            extra_guests += range / (K + 1); // найти количество пустых столов, которые можно заполнить с учетом расстояния K необходимым между ними
            start = seatedDiner + K + 1; // смещаем старт до следующего необходимого стола
        }

        range = N - start + 1; // расстояние от последнего занятого стола до последнего стола N
        extra_guests += (long) Math.ceil((double) range / (K + 1)); // Добавление оставшихся дополнительных посетителей с учетом остаточного расстояния

        return extra_guests;
    }


}
//A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right.
// Social distancing guidelines require that every diner be seated such that K seats to their left and K seats to their right remain empty.
// There are currently M diners seated at the table, the ith of whom is in seat Si​.
// No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
//Determine the maximum number of additional diners who can potentially sit at the table without social
// distancing guidelines being violated for any new or existing diners, assuming that the existing diners
// cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
//Sample Test Case #1
//N = 10 K = 1 M = 2 S = [2, 6]Expected Return Value = 3
//Sample Test Case #2
//N = 15 K = 2 M = 3 S = [11, 6, 14]Expected Return Value = 1