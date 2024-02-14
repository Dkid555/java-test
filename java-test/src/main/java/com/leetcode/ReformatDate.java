package com.leetcode;

import java.util.Map;

public class ReformatDate {

    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        sb.append(date.substring(date.length() - 4)).append("-");
        String m = date.length() == 13 ? date.substring(5, 8) : date.substring(4, 7);

        switch(m){
            case "Jan": sb.append("01-"); break;
            case "Feb": sb.append("02-"); break;
            case "Mar": sb.append("03-"); break;
            case "Apr": sb.append("04-"); break;
            case "May": sb.append("05-"); break;
            case "Jun": sb.append("06-"); break;
            case "Jul": sb.append("07-"); break;
            case "Aug": sb.append("08-"); break;
            case "Sep": sb.append("09-"); break;
            case "Oct": sb.append("10-"); break;
            case "Nov": sb.append("11-"); break;
            case "Dec": sb.append("12-"); break;
        }

        if(date.length() < 13){
            sb.append("0");
            sb.append(date.substring(0,1));
        }else{
            sb.append(date.substring(0,2));
        }

        return sb.toString();
    }
}
//Given a date string in the form Day Month Year, where:
//
//Day is in the set {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}.
//Month is in the set {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}.
//Year is in the range [1900, 2100].
//Convert the date string to the format YYYY-MM-DD, where:
//
//YYYY denotes the 4 digit year.
//MM denotes the 2 digit month.
//DD denotes the 2 digit day.