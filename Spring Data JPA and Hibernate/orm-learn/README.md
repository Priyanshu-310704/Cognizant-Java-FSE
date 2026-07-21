# orm-learn

Solution project for the numbered Spring Data JPA with Hibernate hands-on files.

## Exercise Coverage

- Handout 1, Hands-on 1: project setup, logging, `Country` entity, repository, service, and `findAll`.
- Handout 1, Hands-on 2 and 3: Hibernate XML and annotation walk-through notes are summarized in `docs/hibernate-walkthrough.md`.
- Handout 1, Hands-on 4: JPA vs Hibernate vs Spring Data JPA comparison is summarized in `docs/jpa-hibernate-spring-data-jpa.md`.
- Handout 1, Hands-on 5-9: country service features: find, add, update, delete, and search by partial name.
- Handout 2, Hands-on 1: country query methods.
- Handout 2, Hands-on 2: stock query methods.
- Handout 2, Hands-on 3-6: payroll entities and relationships.
- Handout 3, Hands-on 1-6: HQL/JPQL notes, fetch join, quiz attempt fetch, aggregate query, native query, and criteria query.

## Run

```powershell
mvn spring-boot:run
```

The `CommandLineRunner` in `OrmLearnApplication` executes demonstration methods for the exercises and logs the output.
