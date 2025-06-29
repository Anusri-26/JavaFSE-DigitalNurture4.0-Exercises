# Exercise-1: Mocking and Stubbing

## ✅ Scenario
You need to test a service that depends on an external API. Use Mockito to mock the external API and stub its methods.

## 🧩 Steps
1. Create a mock object for the external API using `Mockito.mock()`.
2. Stub a method using `when(...).thenReturn(...)` to simulate API behavior.
3. Inject the mock into your service and test the method that depends on it.

## 📄 Files
- `ExternalApi.java`: Interface representing the API.
- `MyService.java`: Service that depends on `ExternalApi`.
- `MyServiceTest.java`: Test class that mocks and stubs the API.

## 🧪 How to Run
- Make sure your Maven project includes the following dependencies:
```xml
<dependency>
    <groupId>org.mockito</groupId>
    <artifactId>mockito-core</artifactId>
    <version>4.0.0</version>
    <scope>test</scope>
</dependency>
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>



---

### 📁 `Mockito/Exercise-2/README.md`
```markdown
# Exercise-2: Verifying Interactions

## ✅ Scenario
You need to ensure that a method is called with specific arguments during the test.

## 🧩 Steps
1. Create a mock object using `Mockito.mock()`.
2. Inject it into the service class.
3. Use `verify(mock).method()` to confirm the method was invoked.

## 📄 Files
- `ExternalApi.java`: Mocked API interface.
- `MyService.java`: Contains the method that calls the API.
- `MyServiceTest.java`: Verifies that the API method is invoked.

## 🔍 Key Concept
- `verify(api).getData();` ensures that the method `getData()` was actually called during test execution.

## 🧪 How to Run
- Make sure you have the same Mockito and JUnit dependencies in your `pom.xml` as in Exercise-1.
- Run `MyServiceTest.java` using your IDE’s test runner (JUnit).

