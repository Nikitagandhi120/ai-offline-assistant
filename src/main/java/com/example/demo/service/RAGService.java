package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class RAGService {

    private final PdfService pdfService;

    public RAGService(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    public String getContext(String question) {

        File folder =
                new File("src/main/resources/data");

        String[] keywords =
                question.toLowerCase().split(" ");

        for (File file : folder.listFiles()) {

            String text =
                    pdfService.readPdf(file.getAbsolutePath());

            String[] chunks = text.split("\n\n");

            for (String chunk : chunks) {

                int score = 0;

                for (String word : keywords) {
                    if (chunk.toLowerCase().contains(word)) {
                        score++;
                    }
                }

                // if chunk matches at least 2 keywords
                if (score >= 2) {
                    return chunk;
                }
            }
        }

        return "";
    }
}