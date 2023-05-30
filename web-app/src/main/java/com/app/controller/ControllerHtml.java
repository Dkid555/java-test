package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerHtml {
    @RequestMapping("/h1")
    public String hellopage() {
        return "hello";
    }

    @RequestMapping("/goodbye")
    public String goodbyePage() {
        return "goodbye";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

}
