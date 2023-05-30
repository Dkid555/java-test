package com.app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
    @RequestMapping("/")
    public String index() {
        return "Start page of Boot!";
    }

//    @RequestMapping("/hello")
//    public String hello() {
//        return "Hello from from Spring Boot!";
//    }

    @RequestMapping("/run")
    public void run() {
        int i = 0;
        while (i < 10) {
            System.out.println(i);
            i++;
        }
    }

    @RequestMapping("/hello/{name}")
    public String method7(@PathVariable("name") String name) {
        return "hello from: " + name;
    }
//    @RequestMapping("/{name}")
//    public String loh(@PathVariable("name") String name){
//        return "Yeah, this guy " + name + " is loh";
//    }
}
