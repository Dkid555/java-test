package com.oop;

import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(3);
        priorityQueue.add(10);
        priorityQueue.add(1);
        priorityQueue.add(4);
        priorityQueue.add(-1);

        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}

class PriorityQueueEx2 {
    public static void main(String[] args) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("Adam");
        priorityQueue.add("Biba");
        priorityQueue.add("Zelda");
        priorityQueue.add("Alah");
        priorityQueue.add("Boba");
        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}

class PriorityQueueEx3 {
    public static void main(String[] args) {
        Student st1 = new Student("Alex", 1);
        Student st2 = new Student("Biba", 2);
        Student st3 = new Student("Boba", 1);
        Student st4 = new Student("Madison", 3);
        Student st5 = new Student("Igor", 4);
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(st1);
        priorityQueue.add(st2);
        priorityQueue.add(st3);
        priorityQueue.add(st4);
        priorityQueue.add(st5);
        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int course;

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public Student(String name, int course) {
        this.name = name;
        this.course = course;
    }


    @Override
    public int compareTo(Student other) {
        // if other - this it will be reverse
        return this.course - other.course;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "{\nName: " + this.name + "\nCourse: " + this.course + "\n}";
    }
}