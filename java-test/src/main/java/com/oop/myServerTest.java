package com.oop;

import javax.net.ssl.HttpsURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class myServerTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 1; i < 100; ++i) {
            service.execute(() -> {
                try {
//                    URL myURL = new URL("http://localhost:8000/test?name=Andrey");
//                    URLConnection myURLConnection = myURL.openConnection();
//                    myURLConnection.connect();
                    //System.out.println(i);
                    URL myURL = new URL("https://plitkazavr.ru/Kutahya/Visconte/");//http://localhost:8000/test?name=Andrey
                    HttpsURLConnection connection = (HttpsURLConnection) myURL.openConnection();
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

//            emitter.complete();
            });
        }
        service.shutdown();
    }
}
