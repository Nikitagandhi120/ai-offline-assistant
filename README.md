# 🚀 Offline AI Assistant (Java + Ollama)

An **offline AI assistant** built using **Java (Spring Boot)** and **Ollama**, capable of answering questions using **local language models** and **PDF documents (RAG)** — without any cloud APIs.

---

## Features

- ✅ Fully offline AI (no internet required)
- ✅ Local LLM integration using Ollama
- ✅ REST API-based chat system
- ✅ PDF upload and processing
- ✅ Document-based Q&A (RAG)
- ✅ Beginner-friendly architecture

---

## Architecture

User → Spring Boot API → Ollama → Local LLM  
↓  
PDF (RAG Context)

---

## Tech Stack

| Layer        | Technology              |
|-------------|------------------------|
| Backend      | Java, Spring Boot      |
| AI Model     | Ollama (Mistral)       |
| PDF Parsing  | Apache PDFBox          |
| Build Tool   | Maven                  |
| IDE          | IntelliJ IDEA (Free)   |

---

## Project Structure

offline-ai-assistant-java/
│
├── src/main/java/com/example/demo
│ ├── controller/
│ │ ├── ChatController.java
│ │ └── UploadController.java
│ │
│ ├── service/
│ │ ├── OllamaService.java
│ │ ├── PdfService.java
│ │ └── RAGService.java
│ │
│ └── DemoApplication.java
│
├── src/main/resources/
│ ├── data/ # PDFs stored here
│ ├── static
│ └── application.properties
│
├── pom.xml
└── README.md

## Upload PDF
http://localhost:8080/chat?prompt=What is API testing?

Attached screenshot of testing