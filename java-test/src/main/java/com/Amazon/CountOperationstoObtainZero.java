package com.Amazon;

public class CountOperationstoObtainZero {
    private int count = 0;
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0)
            return count;
        ++count;
        if(num1 >= num2)
            countOperations(num1 - num2, num1);
        else
            countOperations(num1, num2 - num1);
        return count;
    }
    public int countOperations2(int num1, int num2) {
        int count = 0;
        while (num1 != 0 && num2 != 0){
            if(num2 > num1){
//                int temp = num2;
//                num2 = num1;
//                num1 = temp;
                num2 = num2 + num1;
                num1 = num2 - num1; // num2
                num2 = num2 - num1; // num1
            }
            count += num1 / num2;
            num1 %= num2;
        }
        return count;
    }

}
