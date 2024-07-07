package com.javatest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicateLetters {

    private static class Node {
        int val;
        boolean vis;

        Node(int val, boolean vis) {
            this.val = val;
            this.vis = vis;
        }
    }

    public static String removeDuplicateLetters(String s) {
        Map<Character, Node> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            int temp = 1;
            if (map.containsKey(ch)) {
                temp = map.get(ch).val + 1;
            }
            map.put(ch, new Node(temp, false));
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (map.containsKey(ch)) {
                if (!map.get(ch).vis) {
                    int temp = map.get(ch).val;
                    temp--;
                    if (temp != 0) map.put(ch, new Node(temp, true));
                    else map.remove(ch);
                    while (sb.length() != 0 && ch < sb.charAt(sb.length() - 1) && map.containsKey(sb.charAt(sb.length() - 1))) {
                        char c = sb.charAt(sb.length() - 1);
                        map.put(c, new Node(map.get(c).val, false));
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    sb.append(ch);
                } else {
                    int temp = map.get(ch).val - 1;
                    if (temp != 0) map.put(ch, new Node(temp, true));
                    else map.remove(ch);
                }

            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cbacdcbc"));
    }
}
