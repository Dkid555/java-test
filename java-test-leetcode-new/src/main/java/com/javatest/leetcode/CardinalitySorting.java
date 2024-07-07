package com.javatest.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class CardinalitySorting {

    private static class SetBit {
        Set<Integer> set = new HashSet<>();
        public SetBit(){
            this.set =  new HashSet<>();
        }
    }
    public static List<Integer> cardinalitySort(List<Integer> nums) {
        SetBit[] BitSet = new SetBit[32];
        for (int num : nums){
            int BitNum = Integer.bitCount(num);
            if(BitSet[BitNum] == null){
                BitSet[BitNum] = new SetBit();
            }
            BitSet[BitNum].set.add(num);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < BitSet.length; ++i){
            if(BitSet[i] != null && !BitSet[i].set.isEmpty()){
                List<Integer> temparr = new ArrayList<>(BitSet[i].set);
                Collections.sort(temparr);
                result.addAll(temparr);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        List<Integer> s = List.of(65536,
                144,
                2176,
                3072);
        System.out.println(cardinalitySort(s));
    }
}
