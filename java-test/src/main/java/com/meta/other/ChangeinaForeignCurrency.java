package com.meta.other;

public class ChangeinaForeignCurrency {
    static boolean canGetExactChange(int targetMoney, int[] denominations) {
        // Write your code here
        if(targetMoney < 0)
            return false;
        if(targetMoney == 0)
            return true;
        for (int denomination : denominations) {
            if(targetMoney % denomination == 0)
                return true;
            if (canGetExactChange(targetMoney - denomination, denominations)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(canGetExactChange(204,new int[] {5, 10, 25, 100, 200}));
    }
}
//You likely know that different currencies have coins and bills of different
// denominations. In some currencies,
// it's actually impossible to receive change for a given amount of money. For example,
// Canada has given up the 1-cent penny. If you're owed 94 cents in Canada,
// a shopkeeper will graciously supply you with 95 cents instead since there exists a 5-cent coin.
//Given a list of the available denominations, determine if it's
// possible to receive exact change for an amount of money targetMoney.
// Both the denominations and target amount will be given in generic units of that currency.