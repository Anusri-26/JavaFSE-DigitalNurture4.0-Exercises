# 🔐 Spring Boot JWT Authentication Service

This project demonstrates how to build a basic **authentication service using Spring Boot** that generates and returns a **JWT (JSON Web Token)** on successful login.

---

## 🧰 Technologies Used

- Java 8+
- Spring Boot
- Spring Web
- Spring Security
- JWT (io.jsonwebtoken - JJWT library)
- Maven

---

## 🎯 Features

- ✅ POST `/auth/login` – Authenticate user and return JWT
- 🔐 Secured endpoint that requires valid JWT token
- 📦 Token-based authentication (stateless)

---

## 📁 Project Structure

jwt-auth-service/
├── src/
│ ├── main/
│ │ ├── java/com/example/jwt/
│ │ │ ├── controller/
│ │ │ ├── model/
│ │ │ ├── security/
│ │ │ ├── service/
│ │ │ └── JwtAuthApplication.java
│ │ └── resources/
│ │ └── application.properties
├── pom.xml
└── README.md


---

## ⚙️ Endpoints

### 1️⃣ `POST /auth/login`

- **Request:**
json
{
  "username": "admin",
  "password": "admin123"
}
Response:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
2️⃣ GET /hello (Protected Endpoint)
Requires Bearer Token in header:

makefile
Authorization: Bearer <JWT_TOKEN>
Response:


{
  "message": "Hello, authenticated user!"
}
🔐 How It Works
User sends username and password to /auth/login

Server authenticates credentials (in-memory or DB)

If valid, server generates and returns JWT token

Client uses the token to access protected endpoints

📄 Sample Code Snippets
✅ JwtUtil.java – Utility to generate/validate JWT

@Component
public class JwtUtil {
    private final String SECRET = "mysecretkey";

    public String generateToken(String username) {
        return Jwts.builder()
            .setSubject(username)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour
            .signWith(SignatureAlgorithm.HS256, SECRET)
            .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(SECRET)
            .parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token, String username) {
        return username.equals(extractUsername(token));
    }
}
🧑 AuthController.java

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest auth) {
        // Replace with real user validation
        if ("admin".equals(auth.getUsername()) && "admin123".equals(auth.getPassword())) {
            String token = jwtUtil.generateToken(auth.getUsername());
            return ResponseEntity.ok(Map.of("token", token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
    }
}
🔐 JwtFilter.java – Security Filter for JWT

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
                                    throws ServletException, IOException {
        final String authHeader = request.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            String username = jwtUtil.extractUsername(token);

            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                if (jwtUtil.validateToken(token, username)) {
                    UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(username, null, List.of());
                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }
        }

        filterChain.doFilter(request, response);
    }
}
🛡️ SecurityConfig.java

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired private JwtFilter jwtFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll()
            .anyRequest().authenticated();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
🔧 application.properties
properties

server.port=8080

🛠️ How to Run

mvn spring-boot:run
Test using Postman or curl:

curl -X POST http://localhost:8080/auth/login -H "Content-Type: application/json" -d '{"username":"admin","password":"admin123"}'



