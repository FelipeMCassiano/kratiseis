# Kratiseis

[![Java](https://img.shields.io/badge/language-Java-blue?logo=java)](https://www.java.com/)
[![License](https://img.shields.io/github/license/FelipeMCassiano/kratiseis)](LICENSE)

Kratiseis is a Java application designed for robust, scalable solutions.  
Whether you’re a developer, contributor, or user, this project aims to provide clarity, stability, and a foundation for further growth.

---

## 🚀 Getting Started

### Prerequisites

- Java 21 or later
- Maven (for building from source)
- Docker (optional, for containerization)

### Running Locally

1. **Clone the repository:**
   ```bash
   git clone https://github.com/FelipeMCassiano/kratiseis.git
   cd kratiseis
   ```

2. **Build the project:**
   - Using Maven:
     ```bash
     ./mvnw package
     ```
   - Or using Gradle:
     ```bash
     ./gradlew build
     ```

3. **Run the application:**
   ```bash
   java -jar target/kratiseis.jar
   ```

### 🐳 Run with Docker

You can quickly run the application in a container:

```bash
docker build -t kratiseis .
docker run -p 8080:8080 kratiseis
```

---

## 📝 Features

- 100% Java codebase
- Easy to build and deploy
- Docker support out-of-the-box
- Designed for extensibility

---

## 📁 Project Structure

```
kratiseis/
├── src/            # Java source code
├── Dockerfile      # Docker container instructions
├── pom.xml         # Maven build configuration
├── build.gradle    # Gradle build configuration (if available)
└── README.md       # You're here!
```

---

## 🤝 Contributing

Contributions are welcome! Please fork the repository and open a pull request with your changes.  
Check the [issues](https://github.com/FelipeMCassiano/kratiseis/issues) page for things to work on.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

---

## 📜 License

Distributed under the MIT License. See [LICENSE](LICENSE) for more information.

---

## 🙋‍♂️ Questions?

Open an issue or contact [FelipeMCassiano](https://github.com/FelipeMCassiano).

---
