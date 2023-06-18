package com.app.controller;


import com.app.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Stack;

@Controller
public class ControllerHtml {
    Stack<String> filequery = new Stack<>();

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

    @RequestMapping("/MergePDF")
    public String MergePDF() {
        return "MergePDF";
    }


    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/upload")

    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.fileUpload(file);
        filequery.push(file.getOriginalFilename());
        System.out.println(filequery.peek());
        return "redirect:/MergePDF";
    }


    @RequestMapping(value = "/pdf1/", method = RequestMethod.GET)

    public ResponseEntity<byte[]> merge2() throws IOException {
        new mergepdf().merge2("C:\\test_upload\\" + filequery.pop(), "C:\\test_upload\\" + filequery.pop());
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
}
