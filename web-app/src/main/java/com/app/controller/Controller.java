package com.app.controller;

import com.app.service.mergepdf;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController

public class Controller {
//    @RequestMapping("/")
//    public String index() {
//        return "Start page of Boot!";
//    }

//    @RequestMapping("/hello")
//    public String hello() {
//        return "Hello from from Spring Boot!";
//    }

    @RequestMapping("/run")
    public int run() {
        int i = 0;
        while (i < 1165) {
            System.out.print(i);
            i++;
        }
        return i;
    }

    @RequestMapping("/hello/{name}")
    public String method7(@PathVariable("name") String name) {
        return "hello from: " + name;
    }

    @RequestMapping(value = "/pdf/", method = RequestMethod.GET)
    public ResponseEntity<byte[]> megrge1() throws IOException {
//        String name2 = name2;
//        String name1 = name1;
        //String name1;
        new mergepdf().merge2("C:\\Plitkazavr\\Work258\\Magica\\Marstood\\pdf\\1.pdf", "C:\\Plitkazavr\\Work258\\Magica\\Marmo-Apuano\\pdf\\12.pdf");
//        return new mergepdf().merge2("C:\\Plitkazavr\\Work258\\Magica\\Marstood\\pdf\\1.pdf", "C:\\Plitkazavr\\Work258\\Magica\\Marstood\\pdf\\1.pdf");
        Path path = Paths.get("C:\\Users\\dima\\Downloads\\merged.pdf");
        byte[] contents = Files.readAllBytes(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "merge.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }


//    @RequestMapping("/{name}")
//    public String loh(@PathVariable("name") String name){
//        return "Yeah, this guy " + name + " is loh";
//    }


}
