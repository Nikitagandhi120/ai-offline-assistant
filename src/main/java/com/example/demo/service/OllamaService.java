package com.example.demo.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OllamaService {

    private final String URL = "http://localhost:11434/api/generate";

    public String ask(String context, String prompt) {

        RestTemplate restTemplate = new RestTemplate();
        ObjectMapper mapper = new ObjectMapper();

        String body = """
        {
          "model": "mistral",
          "prompt": "%s",
          "stream": false
        }
        """.formatted(prompt);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<String> response =
                restTemplate.postForEntity(URL, request, String.class);

        try {
            JsonNode json = mapper.readTree(response.getBody());
            return json.get("response").asText();
        } catch (Exception e) {
            return "Error calling LLM";
        }
    }
}