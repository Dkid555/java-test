package com.Amazon;

import java.util.ArrayList;
import java.util.List;

public class ShoppingOffers {
    int minPrice;

    private int directlyBuy(List<Integer> price, List<Integer> needs) {
        int cost = 0;
        for (int i = 0; i < price.size(); i++)
            cost += price.get(i) * needs.get(i);

        return cost;
    }

    private boolean canUse(List<Integer> offer, List<Integer> needs) {
        for (int i = 0; i < needs.size(); i++)
            if (offer.get(i) > needs.get(i))
                return false;

        return true;
    }

    private void find(List<Integer> price, List<List<Integer>> special, List<Integer> needs, int index, int currPrice) {
        if (currPrice > minPrice) return;
        if (index == special.size()) {
            currPrice += directlyBuy(price, needs);
            minPrice = Math.min(minPrice, currPrice);
            return;
        }

        List<Integer> offer = special.get(index);
        if (canUse(offer, needs)) {
            List<Integer> updatedNeeds = new ArrayList<>();
            for (int i = 0; i < needs.size(); i++)
                updatedNeeds.add(needs.get(i) - offer.get(i));

            find(price, special, updatedNeeds, index, currPrice + offer.get(needs.size()));
        }
        find(price, special, needs, index + 1, currPrice);
    }

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        minPrice = directlyBuy(price, needs);
        find(price, special, needs, 0, 0);
        return minPrice;
    }
}
