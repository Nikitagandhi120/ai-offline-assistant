package com.example.demo.controller;
import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/upload")
public class UploadController {

    private final String UPLOAD_DIR =
            "src/main/resources/data/";

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file)
            throws IOException {

        File dest = new File(UPLOAD_DIR + file.getOriginalFilename());
        file.transferTo(dest);

        return "Uploaded: " + file.getOriginalFilename();
    }
}

