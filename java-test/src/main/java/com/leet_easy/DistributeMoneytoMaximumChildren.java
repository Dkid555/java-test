package com.leet_easy;

public class DistributeMoneytoMaximumChildren {
    public int distMoney(int money, int children) {
//if the amount is lesser than the number of children, then its impossible for the money to be divided among them, such that, each child gets atleast 1
        if (money < children) return -1;

        money -= children; //Allocating 1 to each children, then the remaining amount.

        int count = money / 7; //number of money=7 that can be given to children. (7+1=8)

        int remaining = money - (count * 7); //remaining amount after allocating each child with 1

        if (count > children) //if the count is much more than children, then one particular child will be given more amount.
            return children - 1;

        else if (count < children) { //if count is less than number of children:
            if (remaining == 3 && children - count == 1) //if there is a case such that only one child has 1 and remaining amount=3, but we know that 1+3 cannot be given, so we have to distribute the remaining amount with another child as well
                return count - 1;
            else
                return count;
        } else if (remaining != 0)
            return count - 1; //if there is a remaining sum and all children have been assigned 8, then we have to allocate the remaining sum to a child

        else
            return count;
    }
}
//You are given an integer money denoting the amount of money (in dollars) that you have and another integer children denoting the number of children that you must distribute the money to.
//
//You have to distribute the money according to the following rules:
//
//All money must be distributed.
//Everyone must receive at least 1 dollar.
//Nobody receives 4 dollars.
//Return the maximum number of children who may receive exactly 8 dollars if you distribute the money according to the aforementioned rules. If there is no way to distribute the money, return -1.