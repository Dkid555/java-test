package com.leetcode;

import java.util.List;
import java.util.stream.IntStream;

public class FindWordsContainingCharacter {
    public static List<Integer> findWordsContaining(String[] words, char x) {
        return IntStream.range(0, words.length).filter(index -> words[index].indexOf(x) >= 0).boxed().toList();
    }

    public static void main(String[] args) {
        System.out.println(findWordsContaining(new String[]{"xxx", "zxxz", "sxc"}, 'x'));
    }


}
