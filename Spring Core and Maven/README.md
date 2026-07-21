# Spring Core and Maven

This folder contains solutions for every exercise in `Spring Core_Maven.docx`.

## Projects

- `LibraryManagement` - classic Maven + Spring Core project for exercises 1 through 8:
  - Maven setup
  - XML application context
  - service and repository beans
  - setter and constructor dependency injection
  - annotation-based beans
  - Spring AOP execution-time logging

- `LibraryManagementBoot` - Spring Boot project for exercise 9:
  - Spring Web
  - Spring Data JPA
  - H2 database
  - `Book` entity and repository
  - REST CRUD controller

## Run

Classic Spring Core project:

```powershell
cd "Spring Core and Maven\LibraryManagement"
mvn exec:java
```

Spring Boot project:

```powershell
cd "Spring Core and Maven\LibraryManagementBoot"
mvn spring-boot:run
```
