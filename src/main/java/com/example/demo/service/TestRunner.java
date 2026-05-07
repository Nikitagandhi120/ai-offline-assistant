package com.example.demo.service;

import com.example.demo.model.TestCase;
import com.example.demo.model.TestResult;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.util.List;

@Component
public class TestRunner {

    private final BenchmarkService benchmark;

    public TestRunner(BenchmarkService benchmark) {
        this.benchmark = benchmark;
    }

    public void runAll() throws Exception {

        List<String> models = List.of("mistral", "phi3");

        List<TestCase> tests = List.of(
                new TestCase("What is API testing",
                        "testing apis functionality"),
                new TestCase("Who is the client",
                        "client name")
        );

        FileWriter writer = new FileWriter("report.csv");

        writer.write("model,question,latency,tps,quality,passed\n");

        for (String model : models) {
            for (TestCase test : tests) {

                TestResult result = benchmark.runTest(model, test);

                writer.write(result.toCSV() + "\n");
            }
        }

        writer.close();
    }
}