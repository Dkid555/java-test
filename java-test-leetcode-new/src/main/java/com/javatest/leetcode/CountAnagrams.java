package com.javatest.leetcode;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.LongStream;


// count anagrams in string with ' '
//You are given a string s containing one or more words. \
//Every consecutive pair of words is separated by a single space ' '.
//
//A string t is an anagram of string s if the ith word of t is a permutation of the ith word of s.
//
//For example, "acb dfe" is an anagram of "abc def", but "def cab" and "adc bef" are not.
//Return the number of distinct anagrams of s. Since the answer may be very large, return it modulo 10^9 + 7.

public class CountAnagrams {

    public static int countAnagrams(String s) {
        String[] strings = s.split(" ");
        long mod = (long) 1e9 + 7;
        long multi = 1;
        for (String str : strings
        ) {
            long temp = count(str);
            System.out.println(temp);

            multi *= count(str);
            multi = multi % mod;
        }
//        multi =

        return (int) multi;
    }

    static long count(String word) {
        long total = 1;
        long mod = (long) 1e9 + 7;
        Map<Character, Integer> all = new HashMap<>();
        Map<Character, Integer> moreThanOne = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            all.put(word.charAt(i), all.getOrDefault(word.charAt(i), 0) + 1);
            if (all.get(word.charAt(i)) != 1) moreThanOne.put(word.charAt(i), all.get(word.charAt(i)));
        }
        total = LongStream.rangeClosed(1, word.length()).reduce(1, (long x, long y) -> (x * y) % mod);
        for (Character key : moreThanOne.keySet()) {
            total /= LongStream.rangeClosed(1, moreThanOne.get(key)).reduce(1, (long x, long y) -> (x * y) % mod);
        }
        return total % mod;
    }
////////////////////////////////////////////////////////////////

    // works but takes too much memory


    public static int countAnagrams2(String s) {
        String[] strings = s.split(" ");
        long mod = (long) 1e9 + 7;
        BigInteger multi = BigInteger.ONE;
        for (String str : strings
        ) {
            BigInteger temp = count2(str);
            System.out.println(temp);

            multi = multi.multiply(temp);
        }
        multi = multi.mod(BigInteger.valueOf(mod));
        return multi.intValue();
    }

    static BigInteger count2(String word) {
        Map<Character, Integer> all = new HashMap<>();
        Map<Character, Integer> moreThanOne = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            all.put(word.charAt(i), all.getOrDefault(word.charAt(i), 0) + 1);
            if (all.get(word.charAt(i)) != 1) moreThanOne.put(word.charAt(i), all.get(word.charAt(i)));
        }
        BigInteger total = factorial(BigInteger.valueOf(word.length()));
        for (Character key : moreThanOne.keySet()) {
            total = total.divide(factorial(BigInteger.valueOf(moreThanOne.get(key))));
        }
        return total;
    }

    public static BigInteger factorial(BigInteger number) {

        // factorial of 0 and 1 is always 1 - base case
        if (number == BigInteger.ZERO || number == BigInteger.ONE) {
            return BigInteger.ONE;
        }

        // !n = n*!n-1 - recursive call
        return number.multiply(factorial(number.subtract(BigInteger.ONE)));

    }

    public static void main(String[] args) {
//        System.out.println(count("ab"));

        System.out.println(countAnagrams2(""));
//        countAnagrams("smuiquglfwdepzuyqtgujaisius ithsczpelfqp rjm");
    }
}


/////////////////////////////
// works, converts on each step factorial to factorial % mod
class Solution {
    public static int countAnagrams(String s) {
        long mod = (long) (1e9 + 7);
        long[] factorialMap = new long[s.length() + 1];
        factorialMap[1] = 1;
        for (int i = 2; i <= s.length(); i++) {
            factorialMap[i] = (factorialMap[i - 1] * i) % mod;
        }
        String[] strings = s.split(" ");
        long result = 1;
        for (String word : strings) {
            result = (result * calculate(word, factorialMap, mod)) % mod;
        }
        return (int) result;
    }

    private static long calculate(String word, long[] factorialMap, long mod) {
        Map<Character, Integer> mapAll = new HashMap<>();
        Map<Character, Integer> mapMoreThanOne = new HashMap<>();
        for (char ch : word.toCharArray()) {
            mapAll.put(ch, mapAll.getOrDefault(ch, 0) + 1);
            if (mapAll.get(ch) > 1) mapMoreThanOne.put(ch, mapAll.get(ch));
        }
        long AnagramsCount = factorialMap[word.length()];
        for (Character ch : mapMoreThanOne.keySet()) {
            long divider = BigInteger.valueOf(factorialMap[mapMoreThanOne.get(ch)]).
                    modInverse(BigInteger.valueOf(mod)).longValue();
            AnagramsCount = AnagramsCount * divider % mod;
        }
        return AnagramsCount;
    }

    public static void main(String[] args) {
        System.out.println(countAnagrams("too hot"));


    }
}
