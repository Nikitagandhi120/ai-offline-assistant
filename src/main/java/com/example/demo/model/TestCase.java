package com.example.demo.model;

public class TestCase {

    private String question;
    private String expected;

    public TestCase(String question, String expected) {
        this.question = question;
        this.expected = expected;
    }

    public String getQuestion() {
        return question;
    }

    public String getExpected() {
        return expected;
    }
}