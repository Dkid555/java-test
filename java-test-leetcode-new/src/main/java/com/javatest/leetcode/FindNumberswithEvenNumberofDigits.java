package com.javatest.leetcode;

import java.util.Arrays;

public class FindNumberswithEvenNumberofDigits {
    public static int findNumbers2(int[] nums) {
        return Arrays.stream(nums).filter(val -> String.valueOf(val).length() % 2 == 0).
                boxed().toList().size();
    }

    public static int findNumbers(int[] nums) {
        var count = 0;
        for (int x : nums) {
            count = String.valueOf(x).length() % 2 == 0 ? ++count : count;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));

        System.out.println(findNumbers2(new int[]{12, 345, 2, 6, 7896}));
    }
}


class Runner {
    public static void main(String[] args) {
        Sounding cat = new Cat();
        cat.makeSound();

        Sounding bird = () -> {
            System.out.println("Птичка чикирает");
        };
        bird.makeSound();
    }
}

@FunctionalInterface
interface Sounding {
    void makeSound();


}

class Cat implements Sounding {

    @Override
    public void makeSound() {
        System.out.println("Кот мяукает");
    }
}
