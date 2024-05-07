package com.Amazon;

import java.util.*;
import java.util.stream.IntStream;

public class MaximumFrequencyStack {

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        //[5], [7], [5], [7], [4], [5]
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);


        System.out.println(stack.pop());
        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());

        System.out.println(stack.pop());

    }

    private static class FreqStack{
        Map<Integer, Integer> map_freq;

        Map<Integer, Stack<Integer>> freq_map_list;

        int max_freq;

        public FreqStack() {
            this.freq_map_list = new HashMap<>();
            this.map_freq = new HashMap<>();
            max_freq = Integer.MIN_VALUE;
        }

        public void push(int val) {
            if(map_freq.containsKey(val)){
                int prev_freq = map_freq.get(val);
                int current_freq = prev_freq + 1;
                max_freq = Math.max(current_freq, max_freq);
                freq_map_list.putIfAbsent(current_freq, new Stack<>());
                freq_map_list.get(current_freq).push(val);
                map_freq.put(val, current_freq);
            }
            else{
                max_freq = Math.max(max_freq, 1);
                map_freq.put(val, 1);
                freq_map_list.putIfAbsent(1, new Stack<>());
                freq_map_list.get(1).push(val);
            }
        }
        public int pop() {
            if(freq_map_list.containsKey(max_freq) && !freq_map_list.get(max_freq).isEmpty()){
                Stack<Integer> stack = freq_map_list.get(max_freq);
                int pop = stack.pop();
                if(stack.isEmpty()){
                    freq_map_list.remove(max_freq);
                    --max_freq;
                }
                map_freq.put(pop, map_freq.get(pop) - 1);
                if(map_freq.get(pop) <= 0)
                    map_freq.remove(pop);
                return pop;
            }
            return -1;
        }
    }
    private static class FreqStack2 {

        private static class Value{
            boolean ignore = false;
            int val;
            public Value(int val){
                this.val = val;
            }
        }

        Map<Integer, Integer> map_freq;

        Map<Integer, List<Value>> freq_map_list;

        int max_freq;

        public FreqStack2() {
            this.freq_map_list = new HashMap<>();
            this.map_freq = new HashMap<>();
            max_freq = Integer.MIN_VALUE;
        }

        public void push(int val) {
            if(map_freq.containsKey(val)){
                int prev_freq = map_freq.get(val);
                int current_freq = prev_freq + 1;
                max_freq = Math.max(current_freq, max_freq);
                if(freq_map_list.containsKey(prev_freq)){
                    for(Value value : freq_map_list.get(prev_freq)){
                        if(value.val == val)
                            value.ignore = true;
                    }
                }
                freq_map_list.putIfAbsent(current_freq, new ArrayList<>());
                freq_map_list.get(current_freq).add(new Value(val));
                map_freq.put(val, current_freq);
            }
            else{
                max_freq = Math.max(max_freq, 1);
                map_freq.put(val, 1);
                freq_map_list.putIfAbsent(1, new ArrayList<>());
                freq_map_list.get(1).add(new Value(val));
            }
        }
        public int pop() {
            if(freq_map_list.containsKey(max_freq) && !freq_map_list.get(max_freq).isEmpty()){
                List<Value> stack = freq_map_list.get(max_freq);
                int i = stack.size() - 1;
                for(; i >= 0; --i){
                    if(!stack.get(i).ignore){
                        break;
                    }
                }
                int pop = stack.get(i).val;
                stack.remove(i);
                if(stack.isEmpty()){
                    freq_map_list.remove(max_freq);
                    --max_freq;
                }
                map_freq.put(pop, map_freq.get(pop) - 1);
                if(map_freq.get(pop) <= 0)
                    map_freq.remove(pop);
                else {
                    int freq = map_freq.get(pop);
                    for(Value value : freq_map_list.get(freq)){
                        if(value.val == pop){
                            value.ignore = false;
                            break;
                        }
                    }
                }
                return pop;
            }
            return -1;
        }
    }
}
