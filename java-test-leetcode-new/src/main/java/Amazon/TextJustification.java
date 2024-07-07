package com.Amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TextJustification {

    public static void main(String[] args) {
        System.out.println(fullJustify(new String[]{"What","must","be","acknowledgment","shall","be"},16));
    }
    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<StringBuilder> temp = new ArrayList<>();
        List<String> result = new ArrayList<>();
        temp.add(new StringBuilder(words[0]));
        int cumulative_len = words[0].length();
        List<Integer> spaces = new ArrayList<>();

        for (int i = 1; i < words.length; ++i){
            if(cumulative_len + words[i].length() + 1 <= maxWidth) {
                temp.add(new StringBuilder(" "));
                spaces.add(temp.size() - 1);
                temp.add(new StringBuilder(words[i]));
                cumulative_len += words[i].length() + 1;
            }
            else {
                if(cumulative_len < maxWidth){
                    if(temp.size() == 1){
                        temp.add(new StringBuilder(" "));
                        ++cumulative_len;
                        spaces.add(temp.size() - 1);
                    }
                    while (cumulative_len < maxWidth){
                        for (int index : spaces){
                            temp.get(index).append(' ');
                            ++cumulative_len;
                            if(cumulative_len == maxWidth)
                                 break;
                        }
                    }
                }
                result.add(temp.stream().map(StringBuilder::toString).collect(Collectors.joining()));
                temp.clear();
                temp.add(new StringBuilder(words[i]));
                cumulative_len = words[i].length();
                spaces.clear();
            }
        }
        if(!temp.isEmpty()){
            String temp_res = temp.stream().map(StringBuilder::toString).collect(Collectors.joining());
            temp_res += " ".repeat(maxWidth - temp_res.length());
            result.add(temp_res);
            //StringBuilder temp_res = new StringBuilder(temp.stream().collect(Collectors.joining()));
            //            temp_res.append(" ".repeat(maxWidth - temp_res.length()));
            //            result.add(temp_res.toString());
        }
        return result;
    }
}
//Given an array of strings words and a width maxWidth,
// format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
//
//You should pack your words in a greedy approach; that is,
// pack as many words as you can in each line. Pad extra spaces ' '
// when necessary so that each line has exactly maxWidth characters.
//
//Extra spaces between words should be distributed as evenly as
// possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
//
//For the last line of text, it should be left-justified, and no extra space is inserted between words.