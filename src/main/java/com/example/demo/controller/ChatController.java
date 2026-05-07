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

        System.out.println("RAG CONTEXT: " + context);

        String finalPrompt = """
    You are an AI assistant.

    Use ONLY the context below to answer.
    If answer is not found, say "Not found in document".

    Context:
    %s

    Question:
    %s
    """.formatted(context, prompt);

        return ollama.askModel("mistral", finalPrompt);
    }
}
