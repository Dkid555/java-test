package leetcode;

import static jdk.javadoc.internal.doclets.toolkit.util.Utils.toLowerCase;

public class LongPalindSub {
    /*static boolean check(String s){
        return s.equals(reverse(s));
    }
    static String reverse(String s){
        String ns = "";
        //ns = ns;
        char[] c = s.toCharArray();
        for(int i = s.length() - 1; i != -1; i--)
            ns = ns + c[i];
        return ns;//.replaceAll("null", "");
    }
    static String longestsub(String s){
        if(s.length() <= 1) return s;
        if(s.length() == 2 && s.charAt(0) == s.charAt(1)) return s;
        String sub = "";
        String max = "";
        for (int i = 0; i < s.length()+1; i++)
            for (int j = i; j < s.length() + 1; j++){
                sub = s.substring(i,j);
                if(check(sub) && max.length() < sub.length()){
                    max = sub;
                }
            }

        return max;
    }*/
    public static void main(String[] args) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        //String s = "lol kek";
        //StringBuilder ;
        s = s.toLowerCase();
        //longestsub(s);
        System.out.println(longestPalindrome(s));
        //System.out.println(longestsub(s));
    }
    /////////////
    static int maxLen = 0;
    static int lo = 0;
    static public String longestPalindrome(String s) {
        char[] input = s.toCharArray();
        if(s.length() < 2) {
            return s;
        }

        for(int i = 0; i<input.length; i++) {
            expandPalindrome(input, i, i);
            expandPalindrome(input, i, i+1);
        }
        return s.substring(lo, lo+maxLen);
    }

    static public void expandPalindrome(char[] s, int j, int k) {
        while(j >= 0 && k < s.length && s[j] == s[k]) {
            j--;
            k++;
        }
        if(maxLen < k - j - 1) {
            maxLen = k - j - 1;
            lo = j+1;
        }
    }
}
