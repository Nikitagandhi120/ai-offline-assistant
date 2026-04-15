package com.example.demo.service;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class PdfService {

    public String readPdf(String path) {

        try {
            PDDocument document =
                    PDDocument.load(new File(path));

            PDFTextStripper stripper =
                    new PDFTextStripper();

            String text = stripper.getText(document);

            document.close();

            return text;

        } catch (Exception e) {
            return "";
        }
    }
}