# JPA, Hibernate, and Spring Data JPA

- JPA is a Java specification for persistence. It defines annotations and APIs but does not provide the persistence implementation.
- Hibernate is an ORM framework and one common JPA implementation.
- Spring Data JPA sits above JPA and removes boilerplate repository code through interfaces such as `JpaRepository`.

## Code Comparison

Hibernate code manually opens sessions, starts transactions, saves entities, commits, rolls back on exception, and closes sessions.

Spring Data JPA lets the service call `repository.save(entity)` inside a `@Transactional` method while Spring manages the persistence context and transaction boundaries.
