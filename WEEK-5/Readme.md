# 🏦 Microservices: Account, Loan, Discovery Server & API Gateway

## 📌 Objective
Build and run microservices for a banking application:
- Account Microservice
- Loan Microservice
- Eureka Discovery Server
- API Gateway with Global Logging Filter

---

## 1️⃣ Account Microservice
### ✅ Setup
- Use [https://start.spring.io](https://start.spring.io)
- Group: `com.cognizant`
- Artifact: `account`
- Dependencies:
  - Spring Web
  - Spring Boot DevTools

### ✅ Controller Endpoint
```java
@GetMapping("/accounts/{number}")
public Map<String, Object> getAccountDetails(@PathVariable String number) {
    return Map.of(
        "number", number,
        "type", "savings",
        "balance", 234343
    );
}

✅ application.properties
server.port=8080
spring.application.name=account-service
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

2️⃣ Loan Microservice
✅ Setup
Artifact: loan
Same dependencies as account service

✅ Controller Endpoint
@GetMapping("/loans/{number}")
public Map<String, Object> getLoanDetails(@PathVariable String number) {
    return Map.of(
        "number", number,
        "type", "car",
        "loan", 400000,
        "emi", 3258,
        "tenure", 18
    );
}

✅ application.properties
server.port=8081
spring.application.name=loan-service
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

3️⃣ Eureka Discovery Server
✅ Setup
Artifact: eureka-discovery-server
Dependency:
Spring Cloud Discovery → Eureka Server

✅ application.properties
server.port=8761
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
logging.level.com.netflix.eureka=OFF
logging.level.com.netflix.discovery=OFF

✅ Main Class
@EnableEurekaServer
@SpringBootApplication
public class EurekaDiscoveryServerApplication { }
✅ Test URL
Visit: http://localhost:8761

4️⃣ Register Microservices to Eureka
Add @EnableDiscoveryClient to both account and loan services
Define spring.application.name in their respective application.properties
Verify in Eureka UI under Instances currently registered with Eureka

5️⃣ API Gateway
✅ Setup
Artifact: api-gateway
Dependencies:
Spring Cloud Gateway
Eureka Discovery Client

✅ application.properties

server.port=9090
spring.application.name=api-gateway
spring.cloud.gateway.discovery.locator.enabled=true
spring.cloud.gateway.discovery.locator.lower-case-service-id=true
eureka.client.service-url.defaultZone=http://localhost:8761/eureka

✅ Route Access Examples
http://localhost:9090/account-service/accounts/001

http://localhost:9090/loan-service/loans/H001

6️⃣ Global Logging Filter
✅ LogFilter.java

@Component
public class LogFilter implements GlobalFilter {

    private static final Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        logger.info("Incoming Request: {}", exchange.getRequest().getURI());
        return chain.filter(exchange);
    }
}
Check the logs in the API Gateway console for each incoming request.

✅ Final Notes
All services run independently on separate ports

Registered dynamically with Eureka Discovery Server

Routed via Spring Cloud Gateway

All requests are logged via a global filter

Demonstrates the evolution from Monolithic to Microservices
