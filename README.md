# Offline AI Assistant (Java + Ollama)

An offline AI assistant built using Java (Spring Boot) and Ollama, capable of answering questions using local Large Language Models (LLMs) 
and document-based Retrieval-Augmented Generation (RAG) — without any cloud dependency.


##  Project Overview

This project demonstrates how to build a fully local AI system  that:
- Runs  without internet 
- Uses  small language models (SLMs)  locally
- Supports  document-based question answering 
- Mimics core functionality of ChatGPT using  Java backend 

---

## Key Features

- ✅ Offline AI assistant (no external APIs)
- ✅ Integration with  Ollama (local LLM runtime)
- ✅ REST API for chat interaction
- ✅ PDF/document upload support
- ✅ RAG (Retrieval-Augmented Generation)
- ✅ Keyword-based context retrieval
- ✅ Lightweight and extensible architecture

---

## Architecture
User Request
↓
Spring Boot API (ChatController)
↓
RAG Layer (Document Retrieval)
↓
Ollama API (Local LLM)
↓
Response Generated



## Tech Stack

| Category        | Technology                     |
|----------------|-------------------------------|
| Backend        | Java, Spring Boot             |
| AI Runtime     | Ollama                        |
| Model Used     | Mistral (7B)                  |
| Document Parsing | Apache PDFBox               |
| Build Tool     | Maven                         |
| IDE            | IntelliJ IDEA (Community)     |


## Project Structure


src/main/java/com/example/demo
│
├── controller/
│ ├── ChatController.java
│ └── UploadController.java
│
├── service/
│ ├── OllamaService.java
│ ├── PdfService.java
│ └── RAGService.java
│
└── DemoApplication.java

src/main/resources/
├── data/ 
├── static/ 
└── application.properties



## Setup Instructions

### 1. Install Ollama
```bash
brew install ollama
2. Run Local Model
ollama run mistral
3. Start Ollama Server
ollama serve
4. Run Spring Boot Application
mvn spring-boot:run
🧪 API Endpoints
🔹 Chat Endpoint
GET /chat?prompt=Your question
Example:
http://localhost:8080/chat?prompt=What is API testing?
🔹 Upload Document
POST /upload
Example:
curl -F "file=@/path/to/file.pdf" http://localhost:8080/upload

Key Learnings
-Integration of LLMs in Java applications
-Building offline AI systems
-Implementing RAG architecture
-Prompt engineering fundamentals
-Backend design for AI-driven systems

Portfolio Highlight
Built a fully offline AI assistant using Java and Ollama, integrating Retrieval-Augmented Generation (RAG) 
for document-based question answering without relying on external APIs or cloud services.

Author
Nikita Gandhi

Support
If you found this project useful, consider giving it a ⭐ on GitHub!