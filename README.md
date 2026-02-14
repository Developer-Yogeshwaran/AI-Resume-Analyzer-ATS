# AI Resume Analyzer (ATS)

[![License: MIT](https://img.shields.io/badge/License-MIT-green.svg)](https://opensource.org/licenses/MIT)
[![Java](https://img.shields.io/badge/Java-17-orange?logo=java)](https://www.java.com/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen?logo=spring)](https://spring.io/projects/spring-boot)
[![Docker](https://img.shields.io/badge/Docker-Yes-blue?logo=docker)](https://www.docker.com/)
[![Grok AI](https://img.shields.io/badge/Grok%20AI-Integrated-lightgrey)](https://grok.ai/)

**AI Resume Analyzer (ATS)** is a smart tool that analyzes resumes and matches them with job descriptions using **Grok AI API**, helping job seekers optimize resumes and assisting recruiters in evaluating candidates efficiently.

---

## Table of Contents

- [Features](#features)  
- [Tech Stack](#tech-stack)  
- [Project Structure](#project-structure)  
- [Installation](#installation)  
- [Docker Setup](#docker-setup)  
- [live Demo](#live-demo)  
- [Grok AI Integration](#grok-ai-integration)  
- [Contributing](#contributing)  
- [License](#license)  

---

## Features

- ✅ Upload resumes in **PDF, DOCX** formats  
- ✅ Analyze **skills, education, experience, and keywords**  
- ✅ Match resumes with job descriptions for **ATS optimization**  
- ✅ Generate **summary insights** for recruiters  
- ✅ Clean, modular **Spring Boot backend** architecture  
- ✅ **Dockerized** for easy deployment  

---

## Tech Stack

| Layer | Technology |
|-------|------------|
| Backend | Java 17, Spring Boot 3.2.2, Maven |
| AI Integration | Grok AI API for resume analysis and matching |
| Parsing | Apache POI (DOCX), PDFBox (PDF) |
| Deployment | Docker, Docker Compose |
| Version Control | Git & GitHub |
| Build Tool | Maven |
| Testing | JUnit |

---

## Project Structure
```text
AI-Resume-Analyzer-ATS/
│
├─ src/
│  ├─ main/
│  │  ├─ java/
│  │  └─ resources/
│  │     └─ application.properties.example
│  └─ test/
├─ Dockerfile
├─ docker-compose.yml
├─ pom.xml
├─ README.md
└─ .gitignore
```
---
## Installation

1. Clone the repository:

```bash

git clone https://github.com/Developer-Yogeshwaran/AI-Resume-Analyzer-ATS.git
cd AI-Resume-Analyzer-ATS

2.Configure your Grok AI API key:

# src/main/resources/application.properties
grok.api.key=YOUR_GROK_API_KEY

3.Build the project with Maven:

mvn clean install
```
---
## Docker Setup

1.Build Docker image:
docker build -t ai-resume-analyzer .

2.Run with Docker:
docker run -p 8080:8080 ai-resume-analyzer

3.Alternatively, use Docker Compose:
docker-compose up --build

The application will run at http://localhost:8080.

```
```
## live Demo


Experience the **AI Resume Analyzer (ATS)** live:
🔗 Click here to try the live demo](https://ai-resume-analyzer-ats.onrender.com/) 
```
```
## Grok AI Integration
The backend uses Grok AI API to analyze resumes:

Extracts skills, experience, education

Scores resumes against job descriptions

Provides recommendations for ATS optimization

Configuration: Store your API key in application.properties

Security: Do not commit your API key. Use .gitignore to exclude

src/main/resources/application.properties

---
---
## Contributing

We welcome contributions!

Fork the repository

Create a branch: git checkout -b feature/feature-name

Commit your changes: git commit -m "Add feature"

Push to the branch: git push origin feature/feature-name

Open a Pull Request

---
---
## License

This project is licensed under the MIT License – see the LICENSE
 file for details.
```

```
## Developed by A. Yogeshwaran
