package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    private static class Palindromic {
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<>();
            helper(s, 0, new ArrayList<>(), result);
            return result;
        }

        private void helper(String string, int index, List<String> path, List<List<String>> result) {
            if (index == string.length()) {
                result.add(new ArrayList<>(path));
                return;
            }
            for (int i = index; i < string.length(); ++i) {
                if (isPalindrome(string, index, i)) {
                    path.add(string.substring(index, i + 1));
                    helper(string, i + 1, path, result);
                    path.remove(path.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String string, int start, int end) {
            while (start <= end)
                if (string.charAt(start++) != string.charAt(end--)) return false;

            return true;
        }
    }

    public static void main(String[] args) {
        Palindromic palindromic = new Palindromic();

        System.out.println(palindromic.partition("aabbc"));
    }

}
