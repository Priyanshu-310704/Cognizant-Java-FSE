# Spring REST using Spring Boot

This folder contains a complete solution for the Spring REST and JWT hands-on documents.

## Project

- `spring-learn` - one Spring Boot project that covers all exercises from:
  - `1. spring-rest-handson.docx`
  - `2. spring-rest-handson.docx`
  - `3. spring-rest-handson.docx`
  - `4. spring-rest-handson.docx`
  - `5. JWT-handson.docx`

## Run

```powershell
cd "Spring REST using Spring Boot\spring-learn"
mvn spring-boot:run
```

The application runs on port `8090`, matching the curl examples in the handouts.

## Important URLs

- `GET /hello`
- `GET /country`
- `GET /countries`
- `GET /countries/{code}`
- `POST /countries`
- `GET /employees`
- `PUT /employees`
- `DELETE /employees/{id}`
- `GET /departments`
- `GET /authenticate`

Use HTTP Basic credentials `user:pwd` or `admin:pwd` on `/authenticate` to get a JWT. Use the returned token as `Authorization: Bearer <token>` for secured endpoints.
