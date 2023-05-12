package leetcode;

public class PerfectSquare {
    public static boolean check(int num) {

        return Math.sqrt(num) == (int) Math.sqrt(num);
    }

    public static void main(String[] args) {
        int num = 15;
        System.out.println(check(num));

    }
}
