# Spring Data JPA and Hibernate

This folder contains solutions for the Spring Data JPA and Hibernate exercise handouts.

## Projects

1. `orm-learn` - covers the three numbered hands-on documents:
   - Spring Data JPA quick example with `Country`
   - country CRUD services
   - country and stock query methods
   - payroll mappings: many-to-one, one-to-many, many-to-many
   - HQL, fetch joins, aggregate HQL, native query, quiz attempt fetch, and criteria query

2. `employee-management-system` - covers all 10 exercises from `Spring Data JPA and Hibernate.docx`:
   - setup, entities, repositories, CRUD REST APIs
   - derived queries, `@Query`, named queries
   - pagination and sorting
   - auditing
   - projections
   - data source configuration
   - Hibernate-specific features and batching

Both projects use H2 in-memory database so the solutions are self-contained.

## Run

If Maven is installed:

```powershell
cd "Spring Data JPA and Hibernate\orm-learn"
mvn spring-boot:run
```

```powershell
cd "Spring Data JPA and Hibernate\employee-management-system"
mvn spring-boot:run
```

H2 console is enabled at `/h2-console`.
