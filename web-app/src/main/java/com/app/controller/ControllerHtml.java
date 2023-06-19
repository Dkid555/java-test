package com.app.controller;


import com.app.service.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerHtml {


    //    private StorageService storageService;
//
//    @Autowired
//    public void FileUploadController(StorageService storageService) {
//        this.storageService = storageService;
//    }
    @RequestMapping("/hello")
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

    @RequestMapping("/Secure")
    public String Secure() {
        return "SecurePage";
    }


    @RequestMapping(value = "/thymeleaf")
    public String thyme() {
        return "/thyme";
    }

    @RequestMapping("/demo")
    public String hi(Model model) {
        model.addAttribute("message", "Greeting from JAVA");
        model.addAttribute("second_message", "Yeah, it's still from java");
        return "/helloworld";
    }

    @RequestMapping("/boot")
    public String bootstra(Model model) {

        return "/bootstraptest";
    }

    private final List<Person> persons = new ArrayList<>();

    @RequestMapping("/iteration")
    public String bootstr(Model model) {

        persons.add(new Person("Dmitrii", "Krutogolov"));
        persons.add(new Person("Andrey", "Krutogolov"));
        persons.add(new Person("Tatiana", "Kirillova"));
        persons.add(new Person("Kristina", "Krutogolova"));
        persons.add(new Person("Irina", "Chvey"));
        model.addAttribute("persons", persons);
        return "thyme";
    }

    @RequestMapping("/thyme")
    public String go(Model model) {
        model.addAttribute("persons", persons);
        return "/thyme";
    }

    @PostMapping("/send")
    public String send(Model model, @RequestParam("first") String firstname, @RequestParam("second") String lastname) {
        persons.add(new Person(firstname, lastname));
        model.addAttribute("persons", persons);
        return "redirect:/thyme";
    }

}
