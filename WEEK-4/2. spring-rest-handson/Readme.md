# 🌍 Spring Boot RESTful Country Web Service

This project demonstrates how to build a basic Spring Boot RESTful web service with the following features:

1. ✅ **Hello World RESTful Web Service**
2. 🌐 **Country Web Service** – Expose a list of countries
3. 🔍 **Get Country by Country Code** – Fetch a specific country using its code

---

## 🧰 Technologies Used

- Java 8+
- Spring Boot (Web Starter)
- Maven
- Spring MVC (REST)
- Jackson (for JSON serialization)

---

## 🚀 Getting Started

### 📦 Prerequisites

- Java 8 or higher
- Maven
- Any IDE (e.g., IntelliJ, Eclipse)
- Optional: Postman or curl for testing endpoints

---

## ⚙️ Project Structure

spring-boot-country-rest/
├── src/
│ ├── main/
│ │ ├── java/com/example/country/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ └── CountryRestApplication.java
│ │ └── resources/
│ │ └── application.properties
├── pom.xml
└── README.md



---

## 📄 REST Endpoints

### 1️⃣ Hello World RESTful API

- **URL:** `GET /hello`
- **Description:** Returns a simple "Hello, World!" message.
- **Sample Response:**
```json
{
  "message": "Hello, World!"
}
2️⃣ Get All Countries
URL: GET /countries

Description: Returns a list of all available countries.

Sample Response:

[
  {
    "code": "IN",
    "name": "India",
    "capital": "New Delhi"
  },
  {
    "code": "US",
    "name": "United States",
    "capital": "Washington, D.C."
  }
]
3️⃣ Get Country by Code
URL: GET /countries/{code}

Description: Fetch a single country by its code (case-insensitive).

Example: /countries/in

Sample Response:


{
  "code": "IN",
  "name": "India",
  "capital": "New Delhi"
}
404 Response:

json
Copy
Edit
{
  "error": "Country not found"
}
🧑‍💻 Code Snippets
✅ Country.java (Model)

public class Country {
    private String code;
    private String name;
    private String capital;
    
    // Constructors, Getters, Setters
}
🌍 CountryController.java

@RestController
public class CountryController {

    private static List<Country> countries = List.of(
        new Country("IN", "India", "New Delhi"),
        new Country("US", "United States", "Washington, D.C.")
    );

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hello, World!");
    }

    @GetMapping("/countries")
    public List<Country> getAllCountries() {
        return countries;
    }

    @GetMapping("/countries/{code}")
    public ResponseEntity<?> getCountryByCode(@PathVariable String code) {
        return countries.stream()
                .filter(c -> c.getCode().equalsIgnoreCase(code))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Country not found")));
    }
}
🚀 CountryRestApplication.java (Main Class)

@SpringBootApplication
public class CountryRestApplication {
    public static void main(String[] args) {
        SpringApplication.run(CountryRestApplication.class, args);
    }
}
🛠️ How to Run
Clone or download the repository.

Run using your IDE or command line:


mvn spring-boot:run
Test endpoints using browser, curl, or Postman.

📫 Example Requests Using curl

curl http://localhost:8080/hello
curl http://localhost:8080/countries
curl http://localhost:8080/countries/IN
📜 License
This project is open source and provided for learning purposes.
