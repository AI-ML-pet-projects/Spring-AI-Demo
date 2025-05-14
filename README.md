# 🤖 Spring AI Demo – Multimodal AI API (Chat, Image, PromptTemplate, Transcribe)

## 📌 Overview

This project is a **Spring Boot demo** showcasing how to integrate and expose multiple **AI-powered endpoints** through a RESTful API. It leverages Spring AI capabilities to demonstrate **text generation, image creation, prompt templating, and audio transcription** in a modular and extensible way.

---

## 🚀 Features

* 🧠 **/ai/ask** – Chat endpoint to get intelligent responses based on user prompt
* 🍽 **/ai/recipe** – Generates a recipe using ingredients, cuisine, and dietary preferences
* 🎨 **/ai/image** – Converts text prompts into images using generative models
* 🎧 **/ai/transcribe** – Accepts an audio file and returns transcribed text (speech-to-text)

---

## 🔧 API Documentation

Base URL: `http://localhost:8080`

### 1. 📥 `/ai/ask` – Chat (Text Completion)

**GET**
Query param:

* `prompt` (string, required) – question or statement

🧪 Example:

```
GET /ai/ask?prompt=What are some resume tips for software engineers?
```

---

### 2. 🧾 `/ai/recipe` – PromptTemplate

**GET**
Query params:

* `ingredients` (string, required) – comma-separated ingredients
* `cuisine` (string, optional, default = "any")
* `dietaryRestrictions` (string, optional)

🧪 Example:

```
GET /ai/recipe?ingredients=tofu,tomato&cuisine=Vietnamese&dietaryRestrictions=vegan
```

---

### 3. 🖼 `/ai/image` – Image Generation

**GET**
Query param:

* `prompt` (string, required) – image description

🧪 Example:

```
GET /ai/image?prompt=A robot chef cooking pho
```

---

### 4. 🎙 `/ai/transcribe` – Audio Transcription

**GET**
Query param:

* `audioFile` (string, required – path or encoded audio file reference)

🧪 Example:

```
GET /ai/transcribe?audioFile=https://example.com/audio/sample.mp3
```

> ⚠️ Note: You may need to adapt this to use `multipart/form-data` in a POST request if handling real binary uploads locally.

---

## ⚙️ Setup & Run

```bash
git clone https://github.com/yourname/spring-ai-demo.git
cd spring-ai-demo
./mvnw spring-boot:run
```

Ensure you have:

* Java 17+
* Spring Boot 3.1+
* Proper API keys/configs for any external AI services (e.g., OpenAI, Azure)

---

## 📒 Notes

* This project is ideal for testing and demonstrating multimodal AI integrations.
* Make sure to adjust the `application.properties` to include provider credentials (if any).
* The `/ai/transcribe` endpoint is mocked to use query param — consider switching to `POST` with `MultipartFile` for real audio uploads.
