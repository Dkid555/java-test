package com.leetcode;

import java.util.Map;

public class HTMLEntityParser {

    public static String entityParser(String text) {
        Map<String, String> map = Map.of(
                "&quot;", "\"",
                "&apos;", "'",
                "&amp;", "&",
                "&gt;", ">",
                "&lt;", "<",
                "&frasl;", "/"
        );
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); ++i) {
            if (text.charAt(i) == '&') {
                StringBuilder temp = new StringBuilder();
                boolean checkAnd = false;
                while (i < text.length() && (text.charAt(i) != ';')) {
                    temp.append(text.charAt(i));
                    i++;
                    if (i < text.length() && text.charAt(i) == '&') {
                        checkAnd = true;
                        break;
                    }
                }
                if (checkAnd) {
                    i--;
                    result.append(temp);
                    continue;
                } else if (i < text.length()) {
                    temp.append(text.charAt(i));
                }

                result.append(map.getOrDefault(temp.toString(), temp.toString()));
            } else
                result.append(text.charAt(i));
        }

        return result.toString();
//        return Arrays.stream(text.split(" ")).map(x -> map.getOrDefault(x, x)).collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        System.out.println(entityParser("&amp; is an HTML entity but &ambassador; is not."));
    }

}
