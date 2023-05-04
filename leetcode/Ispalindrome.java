package leetcode;

public class Ispalindrome {


    public static boolean Palindrom(int x){
        int j = 10;
        int p;
        String k = new String(String.valueOf(x));
        //har c;
        for (char c : k.toCharArray()){
            p = x % 10;
            x = (x - p) / 10;
            //j = j * 10;
            if (Character.getNumericValue(c) != p){
                return false;
            }
        }
    return true;
    }

    public static void main(String[] args) {
        int x = 1213;
        System.out.println(Palindrom(x));

    }


}
