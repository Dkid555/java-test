package com.leet_easy;

public class _1bitand2bitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        while (i < bits.length) {
            if (i == bits.length - 1) {
                return true;
            }
            i += (bits[i] == 1) ? 2 : 1;
        }
        return false;
    }
}
