📘 README.md — Spring Data JPA: Exercise 1 – Quick Example

# Spring Data JPA - Exercise 1: Quick Example

## 🎯 Objective
Build a Spring Boot application using Spring Data JPA to interact with a MySQL database and fetch records from a simple `country` table.

---

## 🛠️ Tools & Technologies
- Java 8+
- Spring Boot
- Spring Data JPA
- MySQL Server 8.0
- Eclipse IDE / IntelliJ
- Maven 3.6+
- MySQL Workbench (for testing DB)

---

## 📁 Project Setup

1. Go to [https://start.spring.io](https://start.spring.io)
2. Set the following:
   - **Group**: `com.cognizant`
   - **Artifact**: `orm-learn`
   - **Dependencies**:
     - Spring Boot DevTools
     - Spring Data JPA
     - MySQL Driver
3. Click **Generate**, extract and import into Eclipse as a Maven project.

---

## 🗃️ Database Setup (MySQL)
```sql
CREATE DATABASE ormlearn;

USE ormlearn;

CREATE TABLE country (
  co_code VARCHAR(2) PRIMARY KEY,
  co_name VARCHAR(50)
);

INSERT INTO country VALUES ('IN', 'India');
INSERT INTO country VALUES ('US', 'United States of America');

⚙️ application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/ormlearn
spring.datasource.username=root
spring.datasource.password=root
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect

logging.level.org.hibernate.SQL=trace
logging.level.org.hibernate.type.descriptor.sql=trace

🧩 Java Classes

1. Country.java (Entity)
@Entity
@Table(name = "country")
public class Country {
    @Id
    @Column(name = "co_code")
    private String code;

    @Column(name = "co_name")
    private String name;

    // Getters, Setters, toString()
}

2. CountryRepository.java
@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
}

3. CountryService.java
@Service
public class CountryService {
    @Autowired
    private CountryRepository countryRepository;

    @Transactional
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}

4. OrmLearnApplication.java
@SpringBootApplication
public class OrmLearnApplication {

    private static CountryService countryService;
    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        countryService = context.getBean(CountryService.class);
        testGetAllCountries();
    }

    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("Countries: {}", countries);
        LOGGER.info("End");
    }
}

✅ Sample Output
INFO  Start
DEBUG Countries: [Country [code=IN, name=India], Country [code=US, name=United States of America]]
INFO  End

📂 Folder Structure

orm-learn/
├── src/
│   ├── main/
│   │   ├── java/com/cognizant/ormlearn/
│   │   │   ├── model/Country.java
│   │   │   ├── repository/CountryRepository.java
│   │   │   ├── service/CountryService.java
│   │   │   └── OrmLearnApplication.java
│   └── resources/
│       └── application.properties
├── pom.xml

💡 Notes

Use @Transactional to enable Spring's transaction management.
Set spring.jpa.hibernate.ddl-auto=validate to ensure the table already exists.
The @Entity, @Id, and @Column annotations help map Java classes to DB tables.

📌 Conclusion
This exercise demonstrates a complete flow of how Spring Boot + Spring Data JPA connects to a database and fetches records using minimal code.
