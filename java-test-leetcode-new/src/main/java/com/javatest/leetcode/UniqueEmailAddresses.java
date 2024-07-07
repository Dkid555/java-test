package com.javatest.leetcode;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public static int numUniqueEmails(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            String[] emailSplit = email.split("@");
            String name = emailSplit[0];
            name = name.replaceAll("\\.", "");
            if (name.contains("+")) {
                name = name.substring(0, name.indexOf("+"));
//                System.out.println(name);
            }
//            System.out.println(name + "@"+ emailSplit[1]);
            unique.add(name + "@" + emailSplit[1]);
        }
        return unique.size();
    }


    public static void main(String[] args) {
        System.out.println(numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.email.leet+alex@code.com"}));
    }

    public int numUniqueEmails2(String[] emails) {
        Set<String> unique = new HashSet<>();
        for (String email : emails) {
            unique.add(formatEmail(email));
        }
        return unique.size();
    }

    private String formatEmail(String s) {
        int i = 0;
        int j = 0;
        char[] chars = s.toCharArray();
        int n = chars.length;
        boolean check = false;
        while (i < n - 4) {
            if (!check) {
                if (chars[i] == '.') {
                    i++;
                }
                if (chars[i] == '+') {
                    while (chars[i] != '@') {
                        i++;
                    }
                }
            }
            if (chars[i] == '@') {
                check = true;
            }
            chars[j] = chars[i];
            i++;
            j++;
        }
        return String.valueOf(chars, 0, j);
    }
}
