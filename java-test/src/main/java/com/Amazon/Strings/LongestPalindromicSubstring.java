package com.Amazon.Strings;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.*;

public class LongestPalindromicSubstring {
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Getter
//    @Setter
    private static class letter_connected{
        private char letter;
        letter_connected next;
        letter_connected previous;

    public letter_connected(char letter, letter_connected next, letter_connected previous) {
        this.letter = letter;
        this.next = next;
        this.previous = previous;
    }
}
    public static String longestPalindrome(String s) {
        List<letter_connected> list = new ArrayList<>();
        for (int i = 0 ; i < s.length(); i++){
            letter_connected letter = new letter_connected(s.charAt(i), null, null);
            if(i > 0){
                letter_connected previous = list.get(i - 1);
                previous.next = letter;
                letter.previous = previous;
            }
            list.add(letter);
        }

        int max = 0;
        List<letter_connected> result = null;


        for(letter_connected letter : list){
            Stack<List<letter_connected>> stack = new Stack<>();
            Stack<Integer> count = new Stack<>();
            binary_search(letter, letter, stack, count, 1);
            List<letter_connected> res = stack.pop();
            int current_size = count.pop();
            if(max < current_size){
                result = res;
                max = current_size;
            }
        }
        Set<letter_connected> visited = new HashSet<>();
        for(int i = list.size() - 1; i > 0; --i){
            letter_connected letter = list.get(i);
            if(!visited.contains(letter) && letter.previous.letter == letter.letter){
                letter_connected temp = letter;
                int count = 1;
                while (temp != null && temp.letter == letter.letter){
                    visited.add(temp);
                    ++count;
                    temp = temp.previous;
                }
                if(temp == null){
                    temp = list.get(0);
                }else
                    temp = temp.next;
                if(count > max){
                    result = List.of(temp, letter);
                    max = count;
                }
            }
        }


        if(result.size() == 2)
            return generateString(result.get(0), result.get(1));
        else
            return "";
    }


    private static String generateString(letter_connected previous, letter_connected next){
        StringBuilder result = new StringBuilder();
        while (previous != next){
            result.append(previous.letter);
            previous = previous.next;
        }
        return result.toString() + previous.letter;
    }

    private static void binary_search(letter_connected previous, letter_connected next,
                                      Stack<List<letter_connected>> stack, Stack<Integer> count, int curr_count){
        if(previous.letter != next.letter)
            return;
        if(!stack.isEmpty())
            stack.pop();
        if(!count.isEmpty())
            count.pop();
        stack.push(List.of(previous, next));
        count.push(curr_count);
        if(previous.previous != null && next.next != null)
            binary_search(previous.previous, next.next, stack, count, curr_count + 2);
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abbc"));
    }
}


//Given a string s, return the longest
//palindromic
//
//substring
// in s.