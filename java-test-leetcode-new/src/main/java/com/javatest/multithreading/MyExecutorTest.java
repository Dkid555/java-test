package com.javatest.multithreading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class MyExecutorTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService service = Executors.newFixedThreadPool(3);
//        ExecutorService service = Executors.newWorkStealingPool(3);
////        ExecutorService service2 = Executors.newSingleThreadExecutor();
        service.execute(new Runnable() {
            public void run() {
                int i = 0;
                while (i < 10) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("from 1-st thread: " + i++);
                }
                service.shutdown();
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("from 2-st thread: " + i++);
                }
                service.shutdown();
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (i < 10) {
                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("from 3rd thread: " + i++);
                }
                service.shutdown();
            }
        });
    }

}
