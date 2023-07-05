package com.pdfedit.controller;

import com.pdfedit.service.FileUploadService;
import com.pdfedit.service.SendBytes;
import com.pdfedit.service.mergepdf;
import lombok.Getter;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
import java.util.ArrayList;
import java.util.List;

@Controller
@Getter
public class PDFMergeController {


    @Value("${property.PathtoUploadM}")
    private String PATHtoUPLOADtoMerge;

    @Value("${property.PathToMerge}")
    private String PATHtoMERGE;
    //    Stack<String> filequery = new Stack<>();

    @Autowired
    FileUploadService fileUploadService;

    private final List<String> filenames = new ArrayList<>();

    @PostMapping("/uploadMerge")
    public String upload(@RequestParam("file") MultipartFile file) throws IOException {
        fileUploadService.fileUpload(file, PATHtoUPLOADtoMerge + "\\");
        filenames.add(file.getOriginalFilename());
        System.out.println(filenames.get(filenames.size() - 1));
        return "redirect:/MergePDF";
    }


    @RequestMapping(value = "/pdfmerge/", method = RequestMethod.GET)

    public ResponseEntity<byte[]> merge2() throws IOException {

        // merging our PDF's
        new mergepdf().mergeMore(filenames, PATHtoMERGE, PATHtoUPLOADtoMerge);

        // creating entity to return for download
        ResponseEntity<byte[]> response = new SendBytes().convertandsend(PATHtoMERGE, "merged.pdf",
                MediaType.APPLICATION_PDF, "merged.pdf");


        //Cleaning Directories from files (ours uploaded pdf and merged)
        FileUtils.cleanDirectory(new File(PATHtoUPLOADtoMerge));
        FileUtils.cleanDirectory(new File(PATHtoMERGE));

        filenames.clear();
        return response;
    }

    @RequestMapping("/MergePDF")
    public String MergePDF(Model model) {
        model.addAttribute("filesnames", filenames);
        return "MergePDF";
    }


}
