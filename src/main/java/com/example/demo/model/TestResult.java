package com.example.demo.model;

public class TestResult {

    private String model;
    private String question;
    private double latency;
    private double tokensPerSecond;
    private double qualityScore;
    private boolean passed;

    public TestResult(String model, String question,
                      double latency, double tps,
                      double qualityScore, boolean passed) {
        this.model = model;
        this.question = question;
        this.latency = latency;
        this.tokensPerSecond = tps;
        this.qualityScore = qualityScore;
        this.passed = passed;
    }

    public String toCSV() {
        return model + "," + question + "," +
                latency + "," + tokensPerSecond + "," +
                qualityScore + "," + passed;
    }
}
