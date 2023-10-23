package com.oop;

import junit.framework.TestCase;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class myServerTest extends TestCase {
    //    @Test
    public void myServerTest(String[] args) {
//        final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
        ExecutorService service = Executors.newSingleThreadExecutor();
        service.execute(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    URL myURL = new URL("http://localhost:8000/test?name=Andrey");
                    HttpURLConnection connection = (HttpURLConnection) myURL.openConnection();
                    connection.setRequestMethod("GET");
                    connection.connect();
                    System.out.println(connection.getResponseCode());
//                    emitter.send(new JSONObject("{'name' : 'Andrey'}"), MediaType.APPLICATION_JSON);
//                    Thread.sleep(10);
                } catch (Exception e) {
//                    e.printStackTrace();
//                    emitter.completeWithError(e);
//                    return;
                }
            }
//            emitter.complete();
        });
    }
}