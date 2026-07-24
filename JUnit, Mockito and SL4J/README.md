# JUnit, Mockito and SLF4J Hands-on Solutions

This folder contains a single Maven project that solves all exercises from
the JUnit, Mockito, Spring Test, dependency mocking, and SLF4J PDFs.

## How to run

```powershell
cd "C:\Users\prysh\Downloads\Cognizant-Java-FSE\JUnit, Mockito and SL4J"
mvn test
mvn spring-boot:run
```

Maven is required to download dependencies and run the tests.

## Exercise Map

| PDF | Covered by |
| --- | --- |
| 1. JUnit Basic Testing Exercises | `CalculatorTest`, `AssertionsTest`, `LifecycleTest` |
| 2. JUnit Advanced Testing exercises | `EvenCheckerTest`, `AllTests`, `OrderedTests`, `ExceptionThrowerTest`, `PerformanceTesterTest` |
| 3. Mockito exercises | `MockitoBasicTest` |
| 3. Mockito Advanced exercises | `MockitoAdvancedTest` |
| 4. JUnit Spring Test exercises | `CalculatorServiceTest`, `UserServiceTest`, `UserControllerMockMvcTest`, `UserIntegrationTest`, `UserControllerPostTest`, `UserServiceExceptionTest`, `UserRepositoryQueryTest`, `GlobalExceptionHandlerTest`, `CalculatorParameterizedTest` |
| 5. Mockito Mock dependencies exercises | `ControllerServiceMockTest`, `RepositoryServiceMockTest`, `IntegrationMockBeanTest` |
| 6. SLF4J Logging exercises | `LoggingExample`, `logback-spring.xml`, `LoggingExampleTest` |
