package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.List;

public class OccurrencesAfterBigram {
    public String[] findOcurrences(String text, String first, String second) {
        String[] textArray = text.split(" ");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < textArray.length - 2; ++i) {
            if (textArray[i].equals(first) && textArray[i + 1].equals(second))
                stringList.add(textArray[i + 2]);
        }
        return stringList.toArray(new String[0]);
    }


}
