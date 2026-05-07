package com.example.demo.service;

import com.example.demo.model.TestCase;
import com.example.demo.model.TestResult;
import org.springframework.stereotype.Service;

@Service
public class BenchmarkService {

    private final OllamaService ollama;

    public BenchmarkService(OllamaService ollama) {
        this.ollama = ollama;
    }

    public TestResult runTest(String model, TestCase testCase) {

        long start = System.currentTimeMillis();

        String response = ollama.askModel(model, testCase.getQuestion());

        long end = System.currentTimeMillis();

        double latency = (end - start) / 1000.0;

        int tokens = response.length() / 4; // approx
        double tps = tokens / latency;

        double quality = calculateScore(response, testCase.getExpected());

        boolean passed = quality > 0.6;

        return new TestResult(model,
                testCase.getQuestion(),
                latency,
                tps,
                quality,
                passed);
    }

    private double calculateScore(String response, String expected) {

        response = response.toLowerCase();
        expected = expected.toLowerCase();

        int match = 0;

        for (String word : expected.split(" ")) {
            if (response.contains(word)) {
                match++;
            }
        }

        return (double) match / expected.split(" ").length;
    }
}