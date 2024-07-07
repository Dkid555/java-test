package com.javatest.meta.other.graphs;

import java.util.Random;

public class RabbitHoleRandom {

    // 100 holes
    // rabbits moving everytime

    public static void downTheRabbitHole() {

        Random gen = new Random();

        int Rabbit = gen.nextInt(0, 101);

        for (int i = 0; ; ++i) {
            if (Rabbit == gen.nextInt(0, 100)) {
                System.out.println("Got in hole: " + Rabbit + " on iteraton: " + i);
                break;
            }
            Rabbit = gen.nextInt(0, 101);
//            System.out.println(Rabbit);
        }


    }

    public static void main(String[] args) {
        downTheRabbitHole();
    }
}
