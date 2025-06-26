# Spring Boot + MySQL + Docker Demo App

This project is a Spring Boot application with MySQL backend, built using Gradle and containerized with Docker. It demonstrates basic CRUD operations with JPA, and exposes REST APIs documented via Swagger/OpenAPI.

---

## 🧰 Tech Stack

- **Java 21**
- **Spring Boot 3.5.3**
- **Spring Data JPA**
- **MySQL 8**
- **Gradle**
- **Docker + Docker Compose**
- **Swagger/OpenAPI (springdoc)**

---

## 🚀 Getting Started

### Prerequisites

- Docker & Docker Compose installed
- Java 21 (for manual builds)
- Gradle (optional if you use Docker)

---
### 🔧 Build with Gradle

```bash
# Ensure you have Gradle installed
./gradlew clean build
# Build the Docker image
docker build -t sb-saic-app .
# Run the Docker container
docker-compose up
```

### 🔧 Build & Run with Docker

```bash
docker-compose up --build
```

