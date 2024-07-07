package com.Amazon;

public class AverageSalaryExcludingtheMinimumandMaximumSalary {
    public static double average(int[] salary) {
        if(salary.length <= 2){
            return 0;
        }
        double avg = 0;
        int min = salary[0];
        int max = 0;
        for(int sal : salary){
            min = Math.min(sal, min);
            max = Math.max(sal, max);
            avg += sal;
        }
        return (avg - min - max) / (salary.length - 2);
    }

    public static void main(String[] args) {
        System.out.println(average(new int[]{4000,3000,1000,2000}));
    }
}
