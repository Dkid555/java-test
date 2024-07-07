package com.javatest.meta;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class TunnelTime {
    public static long getSecondsElapsed(long C, int N, long[] A, long[] B, long K) {
        long time_tunnels_total_per_cycle = 0;
        long last_B = 0L;
        Map<Long, Long> map = new HashMap<>();
        for (int A_B = 0; A_B < A.length; ++A_B) {
            time_tunnels_total_per_cycle += B[A_B] - A[A_B];
            last_B = Math.max(B[A_B], last_B);
            map.put(A[A_B], B[A_B]);
        }
        if (K % time_tunnels_total_per_cycle == 0) {
            //(C * ((K / time_tunnels_total_per_cycle) - 1)) - это количество полных циклов до финального цикла,
            // где мы должны доехать только до конца последего тонеля
            // last_B - координата полследнего тонеля
            return (C * ((K / time_tunnels_total_per_cycle) - 1)) + (last_B);
        }

        long fullCycles_time = (C * ((K / time_tunnels_total_per_cycle))); // - это количество полных циклов до финального цикла
        long time_left = K % time_tunnels_total_per_cycle; // время которое осталось в тунелях провести, за неполный цикл

        long last_cycle = 0;

        Set<Long> keys_of_map = map.keySet().stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        for (Long A_coord : keys_of_map) {
            last_cycle = A_coord; // координата начала последнего цикда, мы ее все время сдвигаем по циклу,
            Long B_coord = map.get(A_coord); // координата финала тунеля
            long current_time_in_tunnel = B_coord - A_coord; // время в тунеле, если его полностью проходить
            time_left -= current_time_in_tunnel; // считаем оставшееся время в тунелях, с учетом проведенного
            if (time_left <= 0) { // если у нас время в тунелях стало меньше 0, это означает что текцщий тунель финальный
                if (time_left == 0) { // если сравним с нулем, то значит в финальной координате тунеля мы исчерпали
                    // всё время и можем ее вернуть в качестве финальной координаты цикла
                    last_cycle = B_coord;
                    break;
                }
                last_cycle += (time_left + current_time_in_tunnel); // иначе возвращаем стартовую координату
                // текущего тунеля + time_left (до последнего вычета current_time_in_tunnel самособой)
                break;
            }
        }
        return fullCycles_time + last_cycle;
    }

    public static void main(String[] args) {
        System.out.println(getSecondsElapsed(10, 2, new long[]{1, 6}, new long[]{3, 7}, 6));
    }
}
//There's a circular train track with a circumference of C meters.
// Positions along the track are measured in meters, clockwise from its topmost point.
// For example, the topmost point is position 0, 1 meter clockwise along the track is position 1,
// and 1 meter counterclockwise along the track is position C-1.
//
//A train with negligible length runs clockwise along this track at a speed of 1 meter
// per second, starting from position 0. After C seconds go by, the train will have
// driven around the entire track and returned to position 0, at which point it will
// continue going around again, with this process repeated indefinitely.
//
//There are N tunnels covering sections of the track, the i-th of which begins at position
// Ai and ends at position Bi (and therefore has a length of Bi - Ai meters).
// No tunnel covers or touches position 0 (including at its endpoints), and no two tunnels
// intersect or touch one another (including at their endpoints).
// For example, if there's a tunnel spanning the interval of positions [1,4],
// there cannot be another tunnel spanning intervals [2,3] nor [4,5].
//
//The train’s tunnel time is the total number of seconds it has spent going through
// tunnels so far. Determine the total number of seconds which will go by before the train’s tunnel time becomes K.