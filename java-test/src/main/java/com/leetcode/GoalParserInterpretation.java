package com.leetcode;

import java.util.Map;

public class GoalParserInterpretation {
    public static String interpret(String command) {
        String temp = "";
        StringBuilder result = new StringBuilder();
        Map<String, String> replace = Map.of("G", "G", "()", "o", "(al)", "al");
        for (int i = 0; i < command.length(); ++i) {
            temp += command.charAt(i);
            if (replace.containsKey(temp)) {
                result.append(replace.get(temp));
                temp = "";
            }
        }
        return result.toString();
    }

    public static String interpret2(String command) {
        return command.replace("()", "o").replace("(al)", "al");
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));

    }
}
