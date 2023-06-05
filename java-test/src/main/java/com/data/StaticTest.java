package com.data;

public class StaticTest {
    public static void main(String[] args) {
        new Car("Jaguar", "V8");
        new Car("Bugatti", "W16");
        new Car("Hover", "i6");
        System.out.println(Car.numberOfCars);
    }
}

class Car {
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        numberOfCars++;
    }

    private String name;
    private String engine;
    static int numberOfCars;

    static {
        numberOfCars = 5;
    }
}
