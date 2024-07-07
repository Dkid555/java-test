package com.javatest.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DeadLockWithExecutor {
    public static void main(String[] args) {
        ExecShared s1 = new ExecShared("s1");
        ExecShared s2 = new ExecShared("s2");
        ExecutorService executor = Executors.newFixedThreadPool(2);
        executor.execute(new Runnable() {
            @Override
            public void run() {
                s1.lock1(s2);
                executor.shutdown();
            }
        });
        executor.execute(new Runnable() {
            @Override
            public void run() {
                s2.lock2(s1);
                executor.shutdown();
            }
        });
    }
}


class ExecShared {
    public ExecShared(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    synchronized void lock1(ExecShared shared) {
        System.out.println(name + ":lock1 >>>");
        shared.lock2(this);
        System.out.println(name + ":lock1 <<<");
    }

    synchronized void lock2(ExecShared shared) {
        System.out.println(name + ":lock2 >>>");
        shared.lock1(this);
        System.out.println(name + ":lock2 <<<");
    }
}