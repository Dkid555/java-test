package com.oop;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class myServerTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(1000);
        service.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
//                    URL myURL = new URL("http://localhost:8000/test?name=Andrey");
//                    URLConnection myURLConnection = myURL.openConnection();
//                    myURLConnection.connect();
                    URL myURL = new URL("http://localhost:8000/test?name=Andrey");
                    HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    System.out.println(connection.getResponseMessage());
                    sleep(1);
//                    emitter.send(new JSONObject("{'name' : 'Andrey'}"), MediaType.APPLICATION_JSON);
//                    Thread.sleep(10);
                } catch (Exception e) {
                    System.out.println(e);
//                    e.printStackTrace();
//                    emitter.completeWithError(e);
//                    return;
                }
            }
//            emitter.complete();
        });
        service.shutdown();
    }
}
