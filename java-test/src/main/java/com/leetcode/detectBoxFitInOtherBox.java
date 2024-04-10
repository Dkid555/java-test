package com.leetcode;

public class detectBoxFitInOtherBox {
    public boolean detect (int[] big_one, int[] that_should_fit_in){


        return ((big_one[0] * big_one[0]) +
                (big_one[1] * big_one[1]) +
                (big_one[2] * big_one[2]))
                <=
                ((that_should_fit_in[0] * that_should_fit_in[0]) +
                        (that_should_fit_in[1] * that_should_fit_in[1]) +
                        (that_should_fit_in[2] * that_should_fit_in[2]));
    }
}
