package com.javatest.multithreading;

import java.util.concurrent.*;

public class MyFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> callable = new MyCallable();
        FutureTask futureTask = new FutureTask(callable);
        new Thread(futureTask).start();
        System.out.println(futureTask.get());

//      By Executor service
        ExecutorService service = Executors.newFixedThreadPool(1);
        Future future = service.submit(new Callable() {
            @Override
            public Object call() throws Exception {
                System.out.println("Another thread is running");
                return "result";
            }
        });
        System.out.println(future.get());
    }

    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            int j = 0;
            for (int i = 0; i < 10; i++, j++) {
                Thread.sleep(300);
            }
            return "Your Result: " + j;
        }
    }

}
