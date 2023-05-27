package com.leetcode;

public class FinaValofVar {
    static int Opers(String[] operations, int x) {
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i]) {
                case "++X":
                    x++;
                    break;
                case "X++":
                    x++;
                    break;
                case "--X":
                    x--;
                    break;
                default:
                    x--;
                    break;
            }
        }
        return x;
    }

    //OR
    static int Opers2(String[] operations, int x) {
        for (int i = 0; i < operations.length; i++) {
            switch (operations[i].charAt(1)) {
                case '+':
                    x++;
                    break;
                default:
                    x--;
                    break;
            }
        }

        return x;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"++X", "--X", "X++"};
        int x = 0;

        System.out.println(Opers2(operations, x));
    }
}
