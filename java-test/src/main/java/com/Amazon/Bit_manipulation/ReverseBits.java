package com.Amazon.Bit_manipulation;

public class ReverseBits {

    public int reverseBits(int n) {
        int result = 0;   // make variable result to store the final answer.
        for (int i = 0; i < 32; ++i) {   // Iterate the loop 1 to 31 times and in the loop make variable lsb as 0.
            int lsb = 0;
            if (((n >> i) & 1) == 1) {   // go to the every bit and check ith bit in i is set or not if ith bit is set make first to ith bit set(1<<31-i) and store in to the lsb.
                lsb = 1 << 31 - i;
                result = result | lsb;   // every time time set lsb th bit into the result using or(|) bitwise operator.
            }
        }
        return result;///  return result.
    }

    public int reverseBits_Best(int n) {
        return Integer.reverse(n);
    }
}
