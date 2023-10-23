package com.oop;


import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.apache.commons.codec.binary.StringUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


public class myServer {
    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.setExecutor(Executors.newCachedThreadPool()); // creates a default executor
//        ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        server.start();
        System.out.println("server Started");
    }

    static class MyHandler implements HttpHandler {
        //        @Override
//        public void handle(HttpExchange t) throws IOException {
//            String response = "<b>This is the response</b>";
//            t.sendResponseHeaders(200, response.length());
//            OutputStream os = t.getResponseBody();
//            os.write(response.getBytes());
//            os.close();
//        }
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            String requestParamValue = null;
            if ("GET".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handleGetRequest(httpExchange);
            } else if ("POST".equals(httpExchange.getRequestMethod())) {
                requestParamValue = handlePostRequest(httpExchange);
//                requestParamValue = "safasf";
            }
            handleResponse(httpExchange, requestParamValue);
        }


        private String handleGetRequest(HttpExchange httpExchange) {
            return httpExchange.
                    getRequestURI()
                    .toString()
                    .split("\\?")[1]
                    .split("=")[1];
        }

        //TODO used with gson
        class GFG {
            String name;

            public GFG() {
                this.name = "";
            }
        }

        private String handlePostRequest(HttpExchange httpExchange) throws IOException {

            byte[] bytes = httpExchange.getRequestBody().readAllBytes();

            //TODO gson
//            GFG gfg = null;
//            Gson gson = new Gson();
//            gfg = gson.fromJson(new String(bytes), GFG.class);
//            return gfg.name;

            //TODO JSONObject
            //JSONObject object = new JSONObject(new String(bytes,StandardCharsets.UTF_8));
            JSONObject object = new JSONObject(StringUtils.newStringUtf8(bytes));
            return object.getString("name");
        }

        private void handleResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
            OutputStream outputStream = httpExchange.getResponseBody();
            // encode HTML content
            String htmlResponse = "<html>" +
                    "<body>" +
                    "<h1>" +
                    "Hey, how are you? " +
                    requestParamValue +
                    "</h1>" +
                    "</body>" +
                    "</html>"
                    // encode HTML content
                    ;//StringEscapeUtils.escapeHtml4(htmlBuilder.toString());
            // this line is a must
            httpExchange.sendResponseHeaders(200, htmlResponse.length());
            outputStream.write(htmlResponse.getBytes());
            outputStream.flush();
            outputStream.close();
        }
    }
}
