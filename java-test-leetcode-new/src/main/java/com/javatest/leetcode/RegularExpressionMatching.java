package com.javatest.leetcode;

public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];// массив dp для пропуска
        return helper(s, 0, p, 0, dp);// перекрывающиеся подзадачи
    }

    public static boolean helper(String s, int i, String p, int j, Boolean dp[][]){
        if(i == s.length() && j == p.length()) return true;// если мы достигли конца обеих строк, значит, обе строки совпадают, вернуть true
        if(j == p.length()) return false;// если j достиг конца шаблона, мы не можем сравнивать больше
        if(dp[i][j] != null) return dp[i][j];// если dp не содержит null, значит, мы уже вычислили
        boolean ans;// переменная для хранения ответа
        boolean charMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        // переменная для предварительного вычисления: если i не превышает длину s, и символы в обеих строках совпадают или в шаблоне есть '.'
        if(j + 1 < p.length() && p.charAt(j + 1) == '*'){
            ans = helper(s, i, p, j + 2, dp) || charMatch && helper(s, i + 1, p, j, dp);
        }// первое условие -> j + 2 потому что, если символ повторяется 0 раз, то строка s и шаблон должны начинаться с j + 2
        // Или если символ совпадает, или в шаблоне символ на j - это *, что означает, что символ также совпадает
        // так что оставьте j на том же месте, может быть, символ повторяется более 0 раз, и затем проверьте с i + 1
        else ans = charMatch && helper(s, i + 1, p, j + 1, dp);
        return dp[i][j] = ans;
    }

    //Given an input string s and a pattern p,
    // implement regular expression matching with support for '.' and '*' where:
    //
    //'.' Matches any single character.​​​​
    //'*' Matches zero or more of the preceding element.
    //The matching should cover the entire input string (not partial).
}
