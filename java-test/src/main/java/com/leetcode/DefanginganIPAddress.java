package com.leetcode;

public class DefanginganIPAddress {
    public String defangIPaddr(String address) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < address.length(); ++i) {
            switch (address.charAt(i)) {
                case '.' -> result.append("[.]");
                default -> result.append(address.charAt(i));
            }
        }
        return result.toString();
    }
}
