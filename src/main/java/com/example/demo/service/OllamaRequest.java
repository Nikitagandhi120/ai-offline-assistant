package com.example.demo.service;


public class OllamaRequest {
        private String model;
        private String prompt;
        private boolean stream = false;

        public OllamaRequest(String model, String prompt) {
            this.model = model;
            this.prompt = prompt;
        }

        public String getModel() { return model; }
        public String getPrompt() { return prompt; }
        public boolean isStream() { return stream; }

}
