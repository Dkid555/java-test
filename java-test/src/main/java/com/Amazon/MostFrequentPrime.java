package com.Amazon;

import java.util.*;

public class MostFrequentPrime {
    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int[][] mat2 = {
                {9, 7, 8}, {4, 6, 5}, {2, 8, 6}
        };
        int[][] mat3 = {{9, 3, 8}, {4, 2, 5}, {3, 8, 6}};
        int[][] mat4 = {{4, 5, 3}};
        System.out.println(mostFrequentPrime(mat4));
    }

    public static int mostFrequentPrime(int[][] mat) {
        int[][] directions = {
                {0, 1},
                {0, -1},
                {1, 0},
                {-1, 0},
                {1, 1},
                {-1, 1},
                {-1, -1},
                {1, -1}
        };
        int max_freq = 0;
        Map<Integer, Integer> prime_freq = new HashMap<>();
        Map<Integer, Set<Integer>> most_freq = new HashMap<>();
        Set<Integer> not_Prime = new HashSet<>();
        for (int row = 0; row < mat.length; ++row) {
            for (int column = 0; column < mat[row].length; ++column) {
                for (int[] direction : directions) {

                    List<String> temp_res = new ArrayList<>();
                    diver(mat, row, column, direction, temp_res);
                    String num = "";

                    Collections.reverse(temp_res);
                    for (String t : temp_res) {
                        num += t;
                        int number = Integer.parseInt(num);
                        if (number > 10) {

                            if (prime_freq.containsKey(number)) {
                                int previous_freq = prime_freq.get(number);
                                if (most_freq.containsKey(previous_freq)) {
                                    most_freq.get(previous_freq).remove(number);
                                    if (most_freq.get(previous_freq).isEmpty())
                                        most_freq.remove(previous_freq);
                                }
                                ++previous_freq;
                                prime_freq.put(number, previous_freq);
                                most_freq.putIfAbsent(previous_freq, new HashSet<>());
                                most_freq.get(previous_freq).add(number);
                                max_freq = Math.max(max_freq, previous_freq);
                            } else {
                                if (!not_Prime.contains(number)) {
                                    if (isPrime(number)) {
                                        prime_freq.put(number, 1);
                                        most_freq.putIfAbsent(1, new HashSet<>());
                                        most_freq.get(1).add(number);
                                        max_freq = Math.max(max_freq, 1);
                                    } else {
                                        not_Prime.add(number);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (max_freq > 0 && most_freq.containsKey(max_freq)) {
            int result = -1;
            for (int i : most_freq.get(max_freq))
                result = Math.max(result, i);
            return result;
        }
        return -1;
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void diver(int[][] mat, int row, int column, int[] direction,
                              List<String> result
    ) {
        if (row < 0 || row >= mat.length || column < 0 || column >= mat[row].length) {
            return;
        }
        diver(mat, row + direction[0], column + direction[1], direction, result);
        result.add(String.valueOf(mat[row][column]));
    }
}
//You are given a m x n 0-indexed 2D matrix mat.
// From every cell, you can create numbers in the following way:
//
//There could be at most 8 paths from the cells namely: east,
// south-east, south, south-west, west, north-west, north, and north-east.
//Select a path from them and append digits in this path to the
// number being formed by traveling in this direction.
//Note that numbers are generated at every step, for example, if
// the digits along the path are 1, 9, 1, then there will be three numbers generated along the way: 1, 19, 191.
//Return the most frequent
//prime number
// greater than 10 out of all the numbers created by traversing the
// matrix or -1 if no such prime number exists. If there are multiple
// prime numbers with the highest frequency, then return the largest among them.
//
//Note: It is invalid to change the direction during the move.