package com.Amazon.Strings;

public class OptimalPartitionofString {
    public int partitionString2(String s) {
        char[] arr = s.toCharArray();
        int i = 0;
        int count = 0;

        while (i < arr.length) {
            int j = i + 1;
            boolean[] seen = new boolean[26];// массив посещенных чаров
            seen[arr[i] - 'a'] = true;

            while (j < arr.length && !seen[arr[j] - 'a']) {
                seen[arr[j] - 'a'] = true;
                j++;
            }
            count++;
            i = j;
        }

        return count;
    }
    public int partitionString(String s){
        char[] chars = s.toCharArray();
        int i = 0;
        int count = 0;
        if(chars.length == 1)
            return 1;
        while (i < chars.length){
            boolean[] seen_chars = new boolean[26];
            int j = i + 1;
            seen_chars[chars[i] - 'a'] = true;
            while(j < chars.length && !seen_chars[chars[j] - 'a']){
                seen_chars[chars[j++] - 'a'] = true;
            }
            i = j;
            ++count;
        }
        return count;
    }

}
