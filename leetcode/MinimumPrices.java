package leetcode;

import java.util.Stack;

public class MinimumPrices {
    static int[] discount(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[i] >= prices[j]) {
                    prices[i] = prices[i] - prices[j];
                    break;
                }
            }
        }
        System.gc();
        return prices;
    }

    static int[] discount2(int[] prices) {
        int n = prices.length;
        int[] arr = new int[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[n - 1]);
        arr[n - 1] = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() > prices[i])
                stack.pop();
            if (stack.isEmpty())
                arr[i] = prices[i];
            else
                arr[i] = prices[i] - stack.peek();
            stack.push(prices[i]);
        }
        return arr;
    }
    static int[] discount3(int[] prices){
        int i = prices.length;
        int arr[] = new int[i];
        arr[i-1] = prices[i-1];
        Stack<Integer> stack = new Stack<>();
        stack.push(prices[i-1]);
        for(int j = i - 2; j > -1; j--){
            while(!stack.isEmpty() && stack.peek() > prices[j]){
                stack.pop();
            }
            if(stack.isEmpty()) arr[j] = prices[j];
            else arr[j] = prices[j] - stack.peek();
            stack.push(prices[j]);
        }
        return arr;
    }
    static int next(int price, int[] prices, int index) {
        for(; index < prices.length; index++)
            if(prices[index] <= price)
                return price - prices[index];
        return price;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{8, 4, 6, 2, 3};
        prices = discount(prices);
        /*for(int i = 0; i < prices.length; i++)
            prices[i] = next(prices[i], prices, i+1);*/
        String s = null;
        for (int i = 0; i < prices.length; i++) {
            s = s + " " + prices[i];
        }
        System.out.println(s.replaceAll("null", ""));

    }
}
