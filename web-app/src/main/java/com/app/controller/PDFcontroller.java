package com.app.controller;

import com.app.service.FileUploadService;
import com.app.service.mergepdf;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PDFcontroller {

    //    Stack<String> filequery = new Stack<>();
    @Autowired
    FileUploadService fileUploadService;
    private final List<String> filenames = new ArrayList<>();

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.fileUpload(file);
//        filequery.push(file.getOriginalFilename());
        filenames.add(file.getOriginalFilename());
        System.out.println(filenames.get(filenames.size() - 1));
//        System.out.println(filequery.peek());
        return "redirect:/MergePDF";
    }


    @RequestMapping(value = "/pdf1/", method = RequestMethod.GET)

    public ResponseEntity<byte[]> merge2() throws IOException {
//        if(filenames.size() == 2){
//            new mergepdf().merge2("C:\\test_upload\\" + filequery.pop(), "C:\\test_upload\\" + filequery.pop());
//        }
        new mergepdf().mergeMore(filenames);

//        return new mergepdf().merge2("C:\\Plitkazavr\\Work258\\Magica\\Marstood\\pdf\\1.pdf", "C:\\Plitkazavr\\Work258\\Magica\\Marstood\\pdf\\1.pdf");
        Path path = Paths.get("C:\\Users\\dima\\Downloads\\merged.pdf");
        byte[] contents = Files.readAllBytes(path);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        String filename = "merge.pdf";
        headers.setContentDispositionFormData(filename, filename);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        FileUtils.cleanDirectory(new File("C:\\test_upload\\"));
        filenames.clear();
        return response;
    }

    @RequestMapping("/MergePDF")
    public String MergePDF(Model model) {
        model.addAttribute("filesnames", filenames);
        return "MergePDF";
    }


}
