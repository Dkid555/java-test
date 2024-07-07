package com.javatest.oop;


//static - we create variable of class, not of object (if we change in one object from class
// it will be changed everywhere)
public class Static_test {
    public static void main(String[] args) {
        worker Alex = new worker("Alex");
        worker Anthony = new worker("Anthony");
        worker Kristy = new worker("Kristy");

        System.out.println(Alex.getNumberOfWorkers());

        Alex.setNumberOfWorkers(15);

        System.out.println(Anthony.getNumberOfWorkers());

        Anthony.setNumberOfWorkers(16);

        worker Megan = new worker("Megan");

        System.out.println(Kristy.getNumberOfWorkers());

        Kristy.setNumberOfWorkers(1);

        System.out.println(Megan.getNumberOfWorkers());
    }
}

class worker {

    String name;

    // variable for class, not for object
    private static int numberOfWorkers = 0;

    public int getNumberOfWorkers() {
        return numberOfWorkers;
    }

    public void setNumberOfWorkers(int numberOfWorkers) {
        worker.numberOfWorkers = numberOfWorkers;
    }

    public worker(String name) {
        this.name = name;
        numberOfWorkers++;
    }

}