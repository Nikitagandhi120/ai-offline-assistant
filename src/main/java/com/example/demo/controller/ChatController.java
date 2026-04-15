package com.example.demo.controller;

import com.example.demo.service.OllamaService;
import com.example.demo.service.RAGService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final OllamaService ollama;
    private final RAGService rag;

    public ChatController(OllamaService ollama,
                          RAGService rag) {
        this.ollama = ollama;
        this.rag = rag;
    }

    @GetMapping
    public String chat(@RequestParam String prompt) {

        String context = rag.getContext(prompt);

        return ollama.ask(context, prompt);
    }
}
