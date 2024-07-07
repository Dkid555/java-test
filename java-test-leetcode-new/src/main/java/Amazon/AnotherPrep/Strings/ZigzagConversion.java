package Amazon.AnotherPrep.Strings;

import java.util.Arrays;

public class ZigzagConversion {
    public static String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuilder result = new StringBuilder();
        String[] rows = new String[numRows];
        Arrays.fill(rows, "");
        int index = 0;
        int sign = 1;
        for(int i = 0; i < s.length(); ++i){
            if(index >= numRows){
                index-=2;
                sign = - 1;
            }
            else if(index < 0){
                index+=2;
                sign = 1;
            }
            rows[index] += s.charAt(i);
            index += sign;
        }
        for(String row : rows){
            result.append(row);
        }
        return result.toString();
    }
    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 4));
    }
}
