package com.Amazon.Dynamic_Programming;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class minChangeStaysPositive {

    // Pnl - positive income, i - month.
    // find out max posible negative (pnl[i] = -pnl[i]) that
    // cumulative income in every month is gona be greater than 0

    public static int minChangePosPnL(List<Integer> PnL){
        int size = PnL.size();
        int[] prefixes = new int[size];
        prefixes[0] = PnL.get(0);
        for(int i = 1; i < size; ++i){
            prefixes[i] += prefixes[i - 1] + PnL.get(i);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> {
            if(PnL.get(a) == PnL.get(b)) {
                return b - a;
            }
            return PnL.get(a) - PnL.get(b);
        });

        IntStream.range(0, size).forEach(pq::add);
        int count = 0;
        while (!pq.isEmpty()){
            int index = pq.poll();
            int current = PnL.get(index) * 2;
            for (int j = index; j < size; ++j){
                prefixes[j] -= current;
                if(prefixes[j] <= 0)
                    return count;
            }
            ++count;
        }

        return count;
    }

//    public void Search()

    public static void main(String[] args) {
        System.out.println(minChangePosPnL(List.of(4,1, 1 ,1 ,3 ,2,  6)));
    }
}
