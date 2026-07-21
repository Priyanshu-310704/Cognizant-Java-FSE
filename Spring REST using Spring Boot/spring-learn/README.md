# spring-learn

Spring Boot REST solution for the Spring REST using Spring Boot handsons.

## Exercise Coverage

- Handson 1:
  - Spring Boot project setup
  - `SpringLearnApplication`
  - XML bean loading for `SimpleDateFormat`
  - XML bean loading for `Country`
  - singleton/prototype bean notes through `country.xml`
  - XML list of countries
  - logging configuration

- Handson 2:
  - `GET /hello`
  - `GET /country`
  - `GET /countries`
  - `GET /countries/{code}`
  - `CountryNotFoundException`
  - MockMVC tests for success and exceptional scenarios

- Handson 3:
  - XML employee and department lists
  - DAO, service, and controller layers
  - `GET /employees`
  - `GET /departments`

- Handson 4:
  - resource naming with plural paths
  - `POST /countries`
  - `@RequestBody` JSON mapping
  - bean validation with `@Valid`
  - global validation error handling
  - employee update with `PUT /employees`
  - malformed JSON handling
  - employee delete with `DELETE /employees/{id}`

- JWT handson:
  - Spring Security
  - in-memory `admin` and `user` accounts
  - `/authenticate` endpoint
  - Basic auth header decoding
  - JWT creation
  - JWT validation filter

Explanation-style topics are summarized in:

- `docs/http-and-rest-notes.md`
- `docs/jwt-notes.md`

## Run

```powershell
mvn spring-boot:run
```

## Example Requests

```powershell
curl http://localhost:8090/hello
curl -u user:pwd http://localhost:8090/authenticate
curl -H "Authorization: Bearer <token>" http://localhost:8090/countries
```
