# Microservice

This folder contains complete Spring Boot 3 and Spring Cloud solutions for the Microservices handouts.

## Projects

- `account-service` - bank account microservice with `GET /accounts/{number}`.
- `loan-service` - bank loan microservice with `GET /loans/{number}` on port `8081`.
- `discovery-server` - Eureka server on port `8761`.
- `greet-service` - simple `Hello World` service registered in Eureka.
- `api-gateway` - Spring Cloud Gateway with routing, logging filter, local rate limit, response cache marker, path rewriting, load-balanced `lb://` routes, and circuit breaker fallback.
- `user-service` and `order-service` - user/order management system where order service uses `WebClient` to call user service.
- `config-server`, `product-service`, and `inventory-service` - inventory lab with service discovery and centralized config.
- `customer-service` and `billing-service` - services routed through the gateway.
- `payment-service` - Resilience4j circuit breaker and fallback logging.
- `security-lab` - OAuth2/OIDC client configuration, OAuth2 resource server, and JWT generation/validation examples.

## Run Order

For the discovery/gateway labs:

```powershell
cd Microservice
mvn -pl discovery-server spring-boot:run
mvn -pl account-service spring-boot:run
mvn -pl loan-service spring-boot:run
mvn -pl greet-service spring-boot:run
mvn -pl customer-service spring-boot:run
mvn -pl billing-service spring-boot:run
mvn -pl payment-service spring-boot:run
mvn -pl api-gateway spring-boot:run
```

For config/inventory labs, start `config-server`, then `product-service`, then `inventory-service`.

## Exercise Map

See `docs/exercise-map.md` for a source-by-source mapping of each handout exercise to the implemented projects.
