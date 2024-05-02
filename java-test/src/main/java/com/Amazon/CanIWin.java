package com.Amazon;

import java.util.*;

public class CanIWin {

    static Map<List<Boolean>, Boolean> memo = new HashMap<>();
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal)
            return true;
        int sum = 0;
        for (int i = 1; i <= maxChoosableInteger; i++) {
            sum += i;
        }
        if (sum < desiredTotal) return false;
        List<Boolean> taken = new ArrayList<>();
        for (int i = 0; i <= maxChoosableInteger; i++) {
            taken.add(false);
        }
        return solver(maxChoosableInteger, desiredTotal, taken);
    }

    public static boolean solver(int maxChoosableInteger, int desiredTotal, List<Boolean> taken) {
        if (desiredTotal <= 0) return false;
        if (memo.containsKey(taken)) return memo.get(taken);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            if (taken.get(i)) continue;
            taken.set(i, true);
            boolean secondPersonWinOrNot = solver(maxChoosableInteger, desiredTotal - i, taken);
            taken.set(i, false);
            if (!secondPersonWinOrNot){
                memo.put(taken, true);
                return true;
            }
        }
        memo.put(taken, false);
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canIWin(10, 19));
    }
//    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
////        if(maxChoosableInteger > desiredTotal)
////            return true;
//        Set<Integer> coins = new HashSet<>();
////        Set<Integer> coins_of_opponent = new HashSet<>();
//        for (int coin = 1; coin <= maxChoosableInteger; ++coin){
//            coins.add(coin);
////            coins_of_opponent.add(coin);
//        }
//        List<Boolean> canI = new ArrayList<>();
//        canI.add(false);
//        canIWin(coins, maxChoosableInteger, desiredTotal, canI);
//
//        return canI.get(0);
//
//    }
//    private static void canIWin(Set<Integer> coins, int maxChoosableInteger,
//                                int left_sum,
//                                List<Boolean> canI){
//        if(left_sum <= 0) // ход оппонента
//            return;
//        for(int mycoin = maxChoosableInteger; mycoin >= 1; --mycoin ){
//            if(canI.get(0))
//                return;
//            if(coins.contains(mycoin)){
//                coins.remove(mycoin);
//                left_sum -= mycoin;
//                if(left_sum <= 0){
//                    canI.set(0, true);
//                    return;
//                }
//                for (int opp_coin = 1; opp_coin <= maxChoosableInteger; ++opp_coin){
//                    if(canI.get(0))
//                        break;
//                    if(coins.contains(opp_coin)){
//                        coins.remove(opp_coin);
//
//                        canIWin(coins, maxChoosableInteger,
//                                left_sum - opp_coin, canI);
//
//                        coins.add(opp_coin);
//                    }
//                }
//                left_sum += mycoin;
//                coins.add(mycoin);
//            }
//        }
//    }

}
//In the "100 game" two players take turns adding, to a running total,
// any integer from 1 to 10. The player who first
// causes the running total to reach or exceed 100 wins.
//
//What if we change the game so that players cannot re-use integers?
//
//For example, two players might take turns drawing
// from a common pool of numbers from 1 to 15 without
// replacement until they reach a total >= 100.
//
//Given two integers maxChoosableInteger and desiredTotal,
// return true if the first player to move can force a win,
// otherwise, return false. Assume both players play optimally.