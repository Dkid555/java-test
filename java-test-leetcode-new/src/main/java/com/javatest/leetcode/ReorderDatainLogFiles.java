package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class ReorderDatainLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        List<String> digits = new ArrayList<>();
        List<String> letters = new ArrayList<>();

        for (String log : logs) {
            String remain = log.substring(log.indexOf(" ") + 1);
            if (remain.charAt(0) > 47 && remain.charAt(0) < 58)
                digits.add(log);
            else
                addLetterInOrder(letters, log);
        }

        int i = 0;
        for (String s : letters)
            logs[i++] = s;

        for (String digit : digits)
            logs[i++] = digit;

        return logs;
    }

    private void addLetterInOrder(List<String> list, String log) {
        if (list.isEmpty()) {
            list.add(log);
            return;
        }
        String logRemain = log.substring(log.indexOf(" ") + 1);
        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            String resRemain = current.substring(current.indexOf(" ") + 1);
            int equality = logRemain.compareTo(resRemain);
            if (equality < 0) {
                list.add(i, log);
                return;
            } else if (equality == 0) {
                if (log.compareTo(current) <= 0) {
                    list.add(i, log);
                    return;
                }
            }
        }
        list.add(log);
    }
}
//You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
//
//There are two types of logs:
//
//Letter-logs: All words (except the identifier) consist of lowercase English letters.
//Digit-logs: All words (except the identifier) consist of digits.
//Reorder these logs so that:
//
//The letter-logs come before all digit-logs.
//The letter-logs are sorted lexicographically by their contents.
// If their contents are the same, then sort them lexicographically by their identifiers.
//The digit-logs maintain their relative ordering.
//Return the final order of the logs.