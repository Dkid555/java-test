package com.Amazon;

import java.util.*;

public class KnightDialer {
    public static void main(String[] args) {
        System.out.println(knightDialer(3131));
    }
    static final int mod = (int) 1e9 + 7;
    static final int[][] MOVES = {
            /*0*/ {4, 6},
            /*1*/ {6, 8},
            /*2*/ {7, 9},
            /*3*/ {4, 8},
            /*4*/ {0, 3, 9},
            /*5*/ {},
            /*6*/ {0, 1, 7},
            /*7*/ {2, 6},
            /*8*/ {1, 3},
            /*9*/ {2, 4}
    };
    static final int[][] cache = new int[5001][10];

    public static int knightDialer(int n) {
        return knightDialer(n, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
    }

    private  static int knightDialer(int remaining, int[] nextNumbers) {
        if (remaining == 1) return nextNumbers.length;
        int count = 0;

        for (int nextNumber : nextNumbers) {
            int cur = cache[remaining][nextNumber];
            if (cur == 0) {
                cur = knightDialer(remaining - 1, MOVES[nextNumber]);
                cache[remaining][nextNumber] = cur;
            }
            count += cur;
            count %= mod;
        }
        return count;
    }
//    public static int knightDialer(int n) {
//        char[][] phone = {
//                {'1','2','3'},
//                {'4','5','6'},
//                {'7','8','9'},
//                {'*','0','#'},
//        };
//        Map<Character, Set<String>> memory = new HashMap<>();
//        Set<String> unique = new HashSet<>();
//        for(int row = 0; row < phone.length; ++row){
//            for (int column = 0; column < phone[column].length; ++column){
//                dialer(n, 0, phone, row, column, unique, "", memory);
//            }
//        }
//        return unique.size() % 1000000007;
//    }
//
//    private static void dialer(int n, int level, char[][] phone, int row,
//                               int column, Set<String> result, String number, Map<Character, Set<String>> memory){
//        if(row < 0 || row >= phone.length || column < 0 || column >= phone[row].length
//                || (row == 3 && (column == 0 || column == 2))){
//            return;
//        }
//        if(memory.containsKey(phone[row][column]) && level != n - 1){
//            char f_ch = number.charAt(0);
//            memory.putIfAbsent(f_ch, new HashSet<>());
//            Set<String> current = memory.get(f_ch);
//            Set<String> temp = new HashSet<>(memory.get(phone[row][column]));
//            for(String numb : temp){
//                String num = number + numb.substring(0, n - level);
//                current.add(num);
//                result.add(num);
//            }
//        }else if(level == n - 1){
//                memory.putIfAbsent(number.charAt(0), new HashSet<>());
//                memory.get(number.charAt(0)).add(number + phone[row][column]);
//                result.add(number + phone[row][column]);
//
//        }else {
//            number += phone[row][column];
//            dialer(n, level + 1, phone,row + 2, column + 1, result, number, memory);
//            dialer(n, level + 1, phone,row + 2, column - 1, result, number, memory);
//            dialer(n, level + 1, phone,row - 2, column + 1, result, number, memory);
//            dialer(n, level + 1, phone,row - 2, column - 1, result, number, memory);
//            dialer(n, level + 1, phone,row + 1, column + 2, result, number, memory);
//            dialer(n, level + 1, phone,row - 1, column + 2, result, number,memory);
//            dialer(n, level + 1, phone,row + 1, column - 2, result, number,memory);
//            dialer(n, level + 1, phone,row - 1, column - 2, result, number,memory);
//            number = number.substring(0, number.length() - 1);
//        }
//    }
}
//The chess knight has a unique movement, it may move two squares vertically
// and one square horizontally, or two squares horizontally and one square vertically
// (with both forming the shape of an L). The possible movements of chess knight are shown in this diagram:
//
//A chess knight can move as indicated in the chess diagram below: