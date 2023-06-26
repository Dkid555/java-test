package com.pdfedit.controller;

import com.pdfedit.service.FileUploadService;
import com.pdfedit.service.SendBytes;
import com.pdfedit.service.ZipUtil;
import com.pdfedit.service.pdfextractallimages;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Stack;


@Controller

public class PDFtoIMGController {

    @Value("${PATHtoUPLOADtoIMG}")
    private String PATHtoUPLOADtoIMG;
    @Value("${PicsPath}")
    private String PicsPath;
    @Value("${ZipPath}")
    private String ZipPath;

    private int progress;
    private Stack<String> fileofPics = new Stack<>();

    @Autowired
    FileUploadService fileUploadService;

    @PostMapping("/uploadIMG")
    public String upload(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        progress = 0;
        model.addAttribute("progress", progress);
        fileUploadService.fileUpload(file, PATHtoUPLOADtoIMG + "\\");

        if (!fileofPics.isEmpty()) fileofPics.clear();
        fileofPics.add(file.getOriginalFilename());
        System.out.println(fileofPics.peek());

        progress = 100;
        model.addAttribute("progress", progress);
        return "redirect:/ExtractIMG";
    }

    @GetMapping("/Generate")
    public String generate() throws Exception {
        new File(PicsPath + "\\" + fileofPics.peek().replaceAll(".pdf", "")).mkdirs();
        new pdfextractallimages().extractpdf(PATHtoUPLOADtoIMG + "\\" + fileofPics.peek(),
                PicsPath + "\\" + fileofPics.peek().replaceAll(".pdf", ""));
        return "redirect:/ExtractIMG";
    }

    @GetMapping("/Zip")
    public ResponseEntity<byte[]> zip() throws IOException {
        new ZipUtil().run(PicsPath + "\\" + fileofPics.peek().replaceAll(".pdf", ""), ZipPath, fileofPics.peek().replaceAll(".pdf", ""));
        FileUtils.cleanDirectory(new File(PicsPath));
        return new SendBytes().convertandsend(ZipPath, fileofPics.pop().replaceAll(".pdf", ".zip"), MediaType.MULTIPART_FORM_DATA, "out.zip");
    }

    @GetMapping(value = "/ExtractIMG")
    public String page(Model model) throws IOException {
        model.addAttribute("fileofPics", fileofPics);
        FileUtils.cleanDirectory(new File(ZipPath));
        return "ExtractIMG";
    }
}
