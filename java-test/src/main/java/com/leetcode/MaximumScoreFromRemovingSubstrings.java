package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    private static class toCheck {
        int xy;
        String check;

        public toCheck(String check, int xy) {
            this.xy = xy;
            this.check = check;
        }
    }

    public static int maximumGain(String s, int x, int y) {
        // ab - x
        // ba = y
        List<toCheck> toCheck = x > y ? List.of(new toCheck("ab", x), new toCheck("ba", y)) :
                List.of(new toCheck("ba", y), new toCheck("ab", x));
        StringBuilder stringBuilder = new StringBuilder(s);
        int sum = 0;
        boolean check = true;
        while (check) {
            check = false;
            for (toCheck ch : toCheck) {
                int lastIndex = stringBuilder.lastIndexOf(ch.check);
                if (lastIndex != -1) {
                    check = true;
                    stringBuilder.delete(lastIndex, lastIndex + 2);
                    sum += ch.xy;
                }
            }
        }
        return sum;
    }

    public int maximumGain2(String s, int x, int y) {
        int total = 0;
        boolean ab = (x > y);
        Deque<Character> stack = new ArrayDeque<>();
        Stack<Character> stack2 = new Stack<>();

        //Pick all maximum value string (ab/ba)
        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty()) {
                if (ab) {
                    if (stack.peek() == 'a' && ch == 'b') {
                        total += x;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                } else {
                    if (stack.peek() == 'b' && ch == 'a') {
                        total += y;
                        stack.pop();
                    } else {
                        stack.push(ch);
                    }
                }
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            char ch = stack.removeLast();

            if (!stack2.empty()) {
                if (!ab) {
                    if (stack2.peek() == 'a' && ch == 'b') {
                        total += x;
                        stack2.pop();
                    } else {
                        stack2.push(ch);
                    }
                } else {
                    if (stack2.peek() == 'b' && ch == 'a') {
                        total += y;
                        stack2.pop();
                    } else {
                        stack2.push(ch);
                    }
                }
            } else {
                stack2.push(ch);
            }
        }


        return total;
    }

    public static void main(String[] args) {
        System.out.println(maximumGain("aabbaaxybbaabb", 5, 4));
    }
}
