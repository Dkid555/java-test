package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SorttheStudentsbyTheirKthScore {

    private class Rates {
        int k_th_Elem;
        int[] rates;

        public Rates(int[] rates, int k) {
            this.k_th_Elem = rates[k];
            this.rates = rates;
        }

        public int getbyIndex() {
            return this.k_th_Elem;
        }
    }

    public int[][] sortTheStudents(int[][] score, int k) {
        List<Rates> Students = new ArrayList<>();
        for (int[] sco : score
        ) {
            Students.add(new Rates(sco, k));
        }
        Students.sort(Comparator.comparing(Rates::getbyIndex).reversed());
        int i = 0;
        int[][] result = new int[score.length][score[0].length];
        for (Rates rate : Students) {
            result[i++] = rate.rates;
        }
        return result;
    }

    public int[][] sortTheStudentsw(int[][] score, int k) {
        Arrays.sort(score, (a, b) -> b[k] - a[k]);
        return score;
    }

}
