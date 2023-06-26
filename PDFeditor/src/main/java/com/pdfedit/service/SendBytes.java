package com.pdfedit.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class SendBytes {
    public ResponseEntity<byte[]> convertandsend(String Path, String Filename, MediaType type, String outfile) throws IOException {
        Path path = Paths.get(Path + "\\" + Filename);

        byte[] contents = Files.readAllBytes(path);

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(type);

//        String filename = "merge.pdf";
        headers.setContentDispositionFormData(outfile, outfile);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }
}
