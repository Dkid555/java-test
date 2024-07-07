package com.javatest.leetcode;

import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone {
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int moves = 0;
        for (int i = 0; i < seats.length; ++i) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

    public int minMovesToSeat2(int[] seats, int[] students) {
        int[] seatAvailable = new int[101];
        int[] studentSeat = new int[101];
        for (int i = 0; i < seats.length; ++i)
            seatAvailable[seats[i]]++;
        for (int i = 0; i < students.length; ++i)
            studentSeat[students[i]]++;
        int seatIndex = 0, studentIndex = 0, count = 0;
        int moves = 0;
        while (seatIndex < 101 && studentIndex < 101 && count <= students.length) {
            if (seatAvailable[seatIndex] > 0) {
                while (studentIndex < 101 && studentSeat[studentIndex] == 0) studentIndex++;
                count++;
                seatAvailable[seatIndex]--;
                studentSeat[studentIndex]--;
                moves += Math.abs(seatIndex - studentIndex);
            } else if (studentSeat[studentIndex] != 0) {
                while (seatIndex < 101 && seatAvailable[seatIndex] == 0) seatIndex++;
                count++;
                seatAvailable[seatIndex]--;
                studentSeat[studentIndex]--;
                moves += Math.abs(seatIndex - studentIndex);
            } else {
                seatIndex++;
                studentIndex++;
            }
        }
        return moves;
    }
}
//There are n seats and n students in a room. You are given an array seats
// of length n, where seats[i] is the position of the ith seat.
// You are also given the array students of length n, where students[j]
// is the position of the jth student.
//
//You may perform the following move any number of times:
//
//Increase or decrease the position of the ith student by 1 (i.e.,
// moving the ith student from position x to x + 1 or x - 1)
//Return the minimum number of moves required to move each student
// to a seat such that no two students are in the same seat.
//
//Note that there may be multiple seats or students in the same position at the beginning.