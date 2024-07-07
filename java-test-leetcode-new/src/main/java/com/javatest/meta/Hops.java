package com.javatest.meta;


import java.util.Arrays;

public class Hops {

    // N - number of Lilypads from 1 to N
    // F - number of Frogs from 1 to F
    // P -
    public static long getSecondsRequired(long N, int F, long[] P) {
        // Write your code here
        Arrays.sort(P);
        long Start_Pond = P[0];


        long seconds = 0L;
        for (int i = 1; i < P.length; ++i) {
            // так мы найдем количество секунд, которое необходимо, для того что-бы лягушкам сгруппирваться в непрерывный отрезок
            seconds += P[i] - Start_Pond - 1;
            Start_Pond = P[i];
        }

        // секунды до финальной кувшинки, чтобы сдвинуть наш отрезок из лягушек
        seconds += N - ((P[P.length - 1])) - 1;

        seconds += F; // с самого конца отрезка все лягушки перепригивают

        return seconds;
    }

    public static long getSecondsRequiredFaster(long N, int F, long[] P) {
        // Write your code here
        long Start_Pond = P[0];
//        long Max_Pond = P[0];


        long seconds = 0L;
        for (int i = 1; i < P.length; ++i) {
            // так мы найдем количество секунд, которое необходимо, для того что-бы лягушкам сгруппирваться в непрерывный отрезок
            Start_Pond = Math.min(Start_Pond, P[i]);
        }

        // количество пустых кувшинок, исключая последнюю
        // так как когда они склеиваются в единый отрезок, то по сути они начинают двигаться как одно целое, то есть +1s каждый раз
        // - 1 так как  последняя по дефолту не тронута
        // - F - количество лягушек (занятых кувшинок)

        seconds += (N - 1 - F);

        // и теперь нам надо вычесть кол-во кувшинок до стартовой лягушки
        seconds -= (Start_Pond - 1); // исключаем стартовую кувшинку, с учетом того что она не занята

        seconds += F; // с самого конца отрезка все лягушки перепригивают

        return seconds;
    }

    // либо
    public static long getSecondsRequiredFaster2(long N, int F, long[] P) {
        // Write your code here
        long Start_Pond = P[0];

        long seconds = 0L;
        for (int i = 1; i < P.length; ++i) {
            // так мы найдем количество секунд, которое необходимо, для того что-бы лягушкам сгруппирваться в непрерывный отрезок
            Start_Pond = Math.min(Start_Pond, P[i]);
        }
        return N - Start_Pond;
    }

    public static void main(String[] args) {
        System.out.println(
                getSecondsRequiredFaster(3, 1, new long[]{1})
        );
    }
}
//A family of frogs in a pond are traveling towards dry land to hibernate.
// They hope to do so by hopping across a trail of N lily pads, numbered from 1 to N in order.
// There are F frogs, numbered from 1 to F. Frog i is currently perched atop lily pad P-i. No two frogs are currently
// on the same lily pad. Lily pad N is right next to the shore, and none of the frogs are initially on lily pad N.
//Each second, one frog may hop along the trail towards lily pad N.
// When a frog hops, it moves to the nearest lily pad after its current lily pad which is not currently
// occupied by another frog (hopping over any other frogs on intermediate lily pads along the way).
// If this causes it to reach lily pad N, it will immediately exit onto the shore.
// Multiple frogs may not simultaneously hop during the same second.
//Assuming the frogs work together optimally when deciding which frog should hop during each second,
// determine the minimum number of seconds required for all F of them to reach the shore.