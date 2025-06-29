# Exercise-1: Logging Error and Warning Using SLF4J

## ✅ Scenario
You need to write a Java application that demonstrates logging **error messages** and **warning messages** using **SLF4J**.

---

## 🛠️ Steps
1. Add SLF4J and Logback dependencies to your Maven `pom.xml`:
```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.30</version>
</dependency>
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>

2.Create a Java class that logs error and warning messages using SLF4J.

📄 File Description
LoggingExample.java: A simple Java program that logs:

One error-level message using logger.error()

One warning-level message using logger.warn()

💻 Sample Output
When you run the class, you'll see output like this in your console:

[main] ERROR LoggingExample - This is an error message
[main] WARN  LoggingExample - This is a warning message
▶️ How to Run
Compile and run LoggingExample.java in your IDE.

Make sure the pom.xml is properly configured with dependencies.

Observe the logs in your console output.

📝 Notes
SLF4J acts as a logging facade, and Logback provides the actual logging implementation.

You can later configure logging formats and destinations (like files) using logback.xml.


