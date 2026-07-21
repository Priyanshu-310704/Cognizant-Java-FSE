# LibraryManagementBoot

Spring Boot solution for exercise 9.

## Exercise Coverage

- Spring Boot project setup
- Spring Web, Spring Data JPA, and H2 database dependencies
- H2 configuration in `application.properties`
- `Book` entity
- `BookRepository`
- `BookService`
- REST CRUD controller

## Run

```powershell
mvn spring-boot:run
```

## Endpoints

- `GET /books`
- `GET /books/{id}`
- `POST /books`
- `PUT /books/{id}`
- `DELETE /books/{id}`

H2 console: `http://localhost:8080/h2-console`
