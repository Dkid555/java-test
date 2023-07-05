package com.leet_easy;

public class PowerofTwo {
    static boolean isPowerBIT(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerBIT(536870912));

        int var = 121;
        int not_var = ~var;
        System.out.println(var + " " + not_var);
        int a = 5, b = 13;
        System.out.println(a | b);
        System.out.println(a ^ b);
    }
}

class codding {
    public static int getKey() {
        return key;
    }

    private static int key = 111;

    static String shifr(String str) {
        char[] s = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            s[i] ^= getKey();
        }
//        str = ;
        return new String(s);
    }

    static String str = "Hello from Hell";

    public static void main(String[] args) {
        String str = "hello from Java";
        System.out.println("Your String: " + str);
        str = shifr(str);
        System.out.println("Your Shifr String: " + str);
        str = shifr(str);
        System.out.println("Your String: " + str);


        int x = 15;

        System.out.println(x << 31);

        System.out.println(x >> 4);
    }
}

class asdP {

    public static void main(String[] args) {
        for (int i = 10; i < 10000; i++) {
            int num = i;
            int begin = num % 10;
            //int pred = begin;
            num = num / 10;
            while (num != 0) {
                if (num % 10 > begin + 1 || num % 10 < begin - 1)
                    break;
                begin = num % 10;
                num = num / 10;
            }
            if (num == 0) System.out.println(i);
        }
    }
}