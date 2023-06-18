package com.app.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
@Component
public class FileUploadService {
    public void fileUpload(MultipartFile file) throws IOException {
        file.transferTo(new File("C:\\test_upload\\" + file.getOriginalFilename()));
    }
}
