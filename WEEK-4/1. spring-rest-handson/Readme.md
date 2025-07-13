# Spring Web Project with Spring Core (Country Bean from XML)

This project demonstrates:
1. A basic Spring Web project setup using Maven.
2. How to load a `Country` bean using Spring Core with an XML-based configuration.

---

## 🧰 Technologies Used

- Java 8+
- Spring Framework (Core + Web)
- Maven
- Apache Tomcat (for deployment)
- IDE: IntelliJ IDEA / Eclipse

---

## 📁 Project Structure

spring-web-country/
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/example/spring/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ └── config/
│ │ ├── resources/
│ │ │ └── applicationContext.xml
│ │ └── webapp/
│ │ └── WEB-INF/
│ │ └── web.xml
├── pom.xml
└── README.md

php-template


---

## ⚙️ Step 1: Create a Spring Web Project Using Maven

### 📄 `pom.xml`

Include the following dependencies in your `pom.xml`:

```xml
<dependencies>
    <!-- Spring Core -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-context</artifactId>
        <version>5.3.34</version>
    </dependency>

    <!-- Spring Web -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.3.34</version>
    </dependency>

    <!-- Servlet API -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>4.0.1</version>
        <scope>provided</scope>
    </dependency>

    <!-- JSTL (Optional if using JSPs) -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>jstl</artifactId>
        <version>1.2</version>
    </dependency>
</dependencies>
🧪 Step 2: Load Country from Spring Configuration XML
📄 Define the Country Bean
Country.java (in com.example.spring.model)

package com.example.spring.model;

public class Country {
    private String name;
    private String capital;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Override
    public String toString() {
        return "Country{name='" + name + "', capital='" + capital + "'}";
    }
}
📄 applicationContext.xml (in src/main/resources)

<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd">

    <bean id="country" class="com.example.spring.model.Country">
        <property name="name" value="India"/>
        <property name="capital" value="New Delhi"/>
    </bean>
</beans>
🧪 Test the Spring Core Configuration
📄 Main.java (in com.example.spring)

package com.example.spring;

import com.example.spring.model.Country;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Country country = (Country) context.getBean("country");
        System.out.println(country);
    }
}
🌐 Web Configuration (Optional if using Web MVC)
📄 web.xml (in WEB-INF/)

<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         version="3.1">

    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>/WEB-INF/applicationContext.xml</param-value>
    </context-param>

    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>

    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value></param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>

    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
✅ Run the Application
To test the Spring Core component:

Run the Main class.

Expected output:

Country{name='India', capital='New Delhi'}
💡 Notes
You can extend this project by creating a CountryController and displaying data via JSP using Spring MVC.

Make sure Maven dependencies are correctly downloaded and IDE is configured with a Tomcat server (if using the web module).
