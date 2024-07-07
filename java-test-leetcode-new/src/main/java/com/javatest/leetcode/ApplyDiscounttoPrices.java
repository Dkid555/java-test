package com.javatest.leetcode;


//A sentence is a string of single-space separated words where each word can contain digits,
// lowercase letters, and the dollar sign '$'.
// A word represents a price if it is a sequence of digits preceded by a dollar sign.
//
//For example, "$100", "$23", and "$6" represent prices while "100", "$", and "$1e5" do not.
//You are given a string sentence representing a sentence and an integer discount.
// For each word representing a price, apply a discount of discount% on the price and update the word in the sentence.
// All updated prices should be represented with exactly two decimal places.
//
//Return a string representing the modified sentence.
//
//Note that all prices will contain at most 10 digits.
public class ApplyDiscounttoPrices {
    public static String discountPrices(String sentence, int discount) {
        String x[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : x) {
            if (isPrice(s)) sb.append(calc(Double.parseDouble(s.substring(1)), discount) + " ");
            else sb.append(s + " ");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Starts with $ and all other is a digits from 0 to 9;
    static boolean isPrice(String s) {
        return s.startsWith("$") && s.substring(1).matches("\\d+");
    }

    //converts string to new price
    static String calc(double num, double discount) {
        double ans = num - (double) ((double) num * discount / 100.00);
        return "$" + String.format("%.2f", ans);
    }

    static boolean isPriceCheck(String s) {
        return s.startsWith("$") && s.substring(1).matches("\\d+");
    }

    public static void main(String[] args) {
        System.out.println(discountPrices("there are $1 $2 and 5$ candies in the shop", 50));
    }
}
