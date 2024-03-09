package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountLargestGroup2 {
    int countDigits(int n) {
        if(n == 0) return 0;
        return n%10 + countDigits(n/10);
    }

    public int countLargestGroup(int n) {

        List<Integer> list = new ArrayList<>(Collections.nCopies(37, 0));

        for(int i=1;i<=n;i++) {
            int cd = countDigits(i); // count digits
            list.set(cd, list.get(cd)+1); // update count
        }

        return Collections.frequency(list, Collections.max(list));
    }
}
