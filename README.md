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
- [Usage](#usage)  
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
AI-Resume-Analyzer-ATS/
│
├─ src/
│  ├─ main/
│  │  ├─ java/                   # All Java source code
│  │  └─ resources/
│  │     └─ application.properties.example  # Config template only
│  └─ test/                       # Unit test files
├─ Dockerfile                     # Docker build instructions
├─ docker-compose.yml             # Docker Compose setup
├─ pom.xml                        # Maven project file
├─ README.md                      # Project documentation
└─ .gitignore                     # Files to ignore in Git


