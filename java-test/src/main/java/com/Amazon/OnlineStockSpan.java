package com.Amazon;

import java.util.Stack;

public class OnlineStockSpan {
    private static class StockSpanner {

        private static class Pair{
            int price;
            int span;
            public Pair(int price){
                this.span = 1;
                this.price = price;
            }
        }
        Stack<Pair> stack;
        public StockSpanner() {
            this.stack = new Stack<>();
        }

        public int next(int price) {
            Pair pair = new Pair(price);
            int span = 1;
            while (!stack.isEmpty() && stack.peek().price <= price){
                span += stack.pop().span;
            }
            pair.span = span;
            stack.add(pair);
            return span;
        }
    }
}
