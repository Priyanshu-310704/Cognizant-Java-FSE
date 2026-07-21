# Employee Management System

Spring Boot solution for the 10 exercises in `Spring Data JPA and Hibernate.docx`.

## Exercise Coverage

1. Project setup with Spring Data JPA, H2, Web, and Lombok dependency.
2. `Employee` and `Department` entities with one-to-many and many-to-one mapping.
3. `EmployeeRepository` and `DepartmentRepository` extending `JpaRepository`.
4. REST CRUD APIs through `EmployeeController` and `DepartmentController`.
5. Derived query methods, `@Query`, `@NamedQuery`, and `@NamedQueries`.
6. Pagination and sorting using `Pageable`, `Page`, and `Sort`.
7. Entity auditing using `@CreatedDate`, `@LastModifiedDate`, `@CreatedBy`, and `@LastModifiedBy`.
8. Interface and class-based projections.
9. Explicit data source configuration with externalized properties.
10. Hibernate features: `@DynamicUpdate`, `@BatchSize`, SQL comments, and JDBC batching properties.

## Run

```powershell
mvn spring-boot:run
```

Useful endpoints:

- `GET /employees`
- `POST /employees`
- `GET /employees/search?name=alice`
- `GET /employees/page?page=0&size=5&sort=name,asc`
- `GET /employees/projection/names`
- `GET /departments`
