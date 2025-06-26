# 🚀 Spring Boot Dockerized – Zero to Container in Minutes! 🐳☕

This project is a Spring Boot application with MySQL backend, built using Gradle and containerized with Docker. It demonstrates basic CRUD operations with JPA, and exposes REST APIs documented via Swagger/OpenAPI.

> Fully containerized Spring Boot app – built for modern DevOps workflows, cloud-ready, and blazing fast to deploy!

![Docker + Spring Boot](https://img.shields.io/badge/SpringBoot-Dockerized-blue?logo=docker)
![GitHub stars](https://img.shields.io/github/stars/rahuldongre-us/spring-boot-dockerized?style=social) 

---

## 🔥 Why This Project?

In a world where microservices and containers dominate the landscape, knowing how to package a Spring Boot app into a lightweight, production-grade Docker image is essential.

This repo is your go-to **starter kit** for:

- 📦 Containerizing a Spring Boot App
- 🧪 Testing it locally
- ☁️ Deploying it to the cloud (EKS, GCP, Azure, or your own server!)

---

## 📂 What's Inside?

- ✅ **Simple Spring Boot API** (REST)
- 🐳 **Dockerfile** – Minimal, production-ready
- 📄 **Docker Compose** (optional, for local testing)
- 🛠️ Clean folder structure
- 🧪 Sample endpoint to verify everything works
- 📖 Swagger UI for API documentation

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

## 🚀 Quick Start

### Prerequisites

- Docker & Docker Compose installed
- Java 21 (for manual builds)
- Gradle (optional if you use Docker)

```bash 
# Clone the repo
git clone https://github.com/rahuldongre-us/spring-boot-dockerized.git
cd spring-boot-dockerized

# Build JAR
./mvnw clean package
./gradlew clean build

# Build Docker image
docker build -t spring-boot-dockerized .

# Run the container
docker-compose up 
``` 

---

🧪 Test it:
Visit 👉 http://localhost:8085/swagger-ui/index.html

---

🌐 Perfect For:

Devs learning Docker with Java 

Bootstrapping microservices 

Kubernetes deployments 

Cloud-native application patterns

---

❤️ Support & Contribute

If this helps you:

⭐ Star the repo

🔁 Share on LinkedIn or Twitter

🛠️ Fork and build your next service on top of it!

---

🤝 Let’s Connect!

👨‍💻 Rahul Dongre on LinkedIn
🐙 Check out more on GitHub
