package com.javatest.multithreading;


class Shar {
    public String getName() {
        return name;
    }

    public Shar(String name) {
        this.name = name;
    }

    private String name;

    synchronized void lock1(Shar shar) {
        System.out.println(name + ":lock1 >>>");
        shar.lock2(this);
        System.out.println(name + ":lock1 <<<");
    }

    synchronized void lock2(Shar shar) {
        System.out.println(name + ":lock2 >>>");
        shar.lock1(this);
        System.out.println(name + ":lock2 <<<");
    }
}


class runnable1 implements Runnable {
    public runnable1(Shar s1, Shar s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    private Shar s1, s2;

    @Override
    public void run() {
        s1.lock1(s2);
    }
}

class runnable2 implements Runnable {

    public runnable2(Shar s1, Shar s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    private Shar s1, s2;

    @Override
    public void run() {
        s2.lock2(s1);
    }
}

public class DeadlockWithRunnable {
    public static void main(String[] args) {
        System.out.println("start");
        Shar s1 = new Shar("s1");
        Shar s2 = new Shar("s2");
        Runnable run1 = new runnable1(s1, s2);
        Runnable run2 = new runnable2(s1, s2);
        Thread t1 = new Thread(run1);
        Thread t2 = new Thread(run2);
        t1.start();
        t2.start();
        System.out.println("end");

    }
}