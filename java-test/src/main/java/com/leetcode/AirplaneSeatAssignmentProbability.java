package com.leetcode;

public class AirplaneSeatAssignmentProbability {
    public double nthPersonGetsNthSeat(int n) {
        return n == 1 ? 1.0 : 0.5;
    }//if seat is one then there is one seat and the person will seat in correct seat.

    //for ex:if 10 seat are available the person will sit either the person seat or the another seat,
    // then the probability will be 1/2.

}
