package com.javatest.leetcode;

import java.util.ArrayList;
import java.util.HashSet;

//import static sun.jvm.hotspot.HelloWorld.c;

public class Sams1 {

    static int find(int[][][] badge, int leng) {
        HashSet<Integer> help = new HashSet<>();
        ArrayList<int[]> al = new ArrayList<>();
        int min = 0;
        int max;
        for (int i = 0; i < 1000; i++)
            help.add(i);
        for (int i = 0; i < badge.length; i++)
            for (int j = 0; j < badge[i].length; j++)
                //int[] a =
                //help.remove(());
                return 0;
        return min;
    }

    public static void main(String[] args) {
        int[][][] badge = new int[][][]{{{60, 150}, {180, 240}}, {{0, 210}, {360, 420}}};
        int leng = 240; // длительность миттинга
        find(badge, leng);
    }
}
