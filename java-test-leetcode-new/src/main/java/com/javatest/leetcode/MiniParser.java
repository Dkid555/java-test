package com.javatest.leetcode;

public class MiniParser {

//    private class NestedInteger {
//        public void NestedInteger(int ni) {
//        }
//
//        public void add(NestedInteger ni) {
//        }
//    }
//
//    public NestedInteger deserialize(String s) {
//        if (s.contains(",") || s.contains("[")) {
//            return split(s);
//        } else {
//            return new NestedInteger(Integer.parseInt(s));
//        }
//    }
//
//    private NestedInteger split(String s) {
//        if (s.startsWith("[")) {
//            s = s.substring(1, s.length() - 1);
//        }
//        int level = 0;
//        NestedInteger nested = new NestedInteger();
//        int start = 0;
//        int end = 0;
//        while (end < s.length()) {
//            if (s.charAt(end) == ',' && level == 0) {
//                if (end - start > 0) nested.add(deserialize(s.substring(start, end)));
//                start = end + 1;
//            } else if (s.charAt(end) == '[') {
//                level++;
//            } else if (s.charAt(end) == ']') {
//                level--;
//                if (level == 0) {
//                    nested.add(deserialize(s.substring(start, end + 1)));
//                    start = end + 1;
//                }
//            }
//            end++;
//        }
//        if (end - start > 0) nested.add(deserialize(s.substring(start, end)));
//        return nested;
//    }

}
