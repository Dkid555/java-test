package com.Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class OpentheLock {

    private static class Diadem{
        Diadem[] diadems = new Diadem[10];
        Boolean bad_choice = false;
    }

    public static void main(String[] args) {
        String[] deadens = {"0201","0101","0102","1212","2002"};
        System.out.println(openLock(deadens, "0202"));
    }
    public static int openLock(String[] deadends, String target) {
        int[] pow10 = {1, 10, 100, 1000};
        int[] visit = new int[10000]; // 0: not visited, 1: visited through forward direction, -1: visited through backward direction, 2: deadends
        for(String dead: deadends) {
            visit[Integer.parseInt(dead)] = 2;
        }
        int src = 0, dest = Integer.parseInt(target), steps = 0, dir = 1;
        if(visit[src] == 2 || visit[dest] == 2) return -1;
        if(src == dest) return 0;
        Queue<Integer> forward = new LinkedList<>(), backward = new LinkedList<>();
        forward.add(src);
        visit[src] = 1;
        backward.add(dest);
        visit[dest] = -1;
        while(!forward.isEmpty() && !backward.isEmpty()) {
            if(forward.size() > backward.size()) {
                Queue<Integer> tmp = forward; forward = backward; backward = tmp;
                dir = -dir;
            }
            steps++;
            int size = forward.size();
            while(size-- > 0) {
                int cur = forward.poll();
                for(int p: pow10) {
                    int d = (cur / p) % 10;
                    for(int i = -1; i <= 1; i += 2) {
                        int z = d + i;
                        z = z == -1 ? 9 : (z == 10 ? 0 : z);
                        int next = cur + (z - d) * p;
                        if(visit[next] == -dir) return steps;
                        if(visit[next] == 0) {
                            forward.add(next);
                            visit[next] = dir;
                        }
                    }
                }
            }
        }
        return -1;


    }

}
//You have a lock in front of you with 4 circular wheels. Each wheel has 10 slots:
// '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
// The wheels can rotate freely and wrap around: for example we
// can turn '9' to be '0', or '0' to be '9'. Each move consists of turning one wheel one slot.
//
//The lock initially starts at '0000', a string
// representing the state of the 4 wheels.
//
//You are given a list of deadends dead ends, meaning if
// the lock displays any of these codes, the wheels of the lock will stop turning and you will be unable to open it.
//
//Given a target representing the value of the wheels that will
// unlock the lock, return the minimum total number of turns required to open the lock, or -1 if it is impossible.