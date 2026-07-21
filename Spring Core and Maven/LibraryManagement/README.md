# LibraryManagement

Classic Spring Core and Maven solution for exercises 1 through 8.

## Exercise Coverage

1. Basic Spring application configured with Maven and XML.
2. Dependency injection from `BookRepository` into `BookService`.
3. Spring AOP execution-time logging.
4. Maven compiler/plugin configuration for Java 1.8.
5. Spring IoC container configuration in `applicationContext.xml`.
6. Annotation-based bean configuration in `annotationContext.xml`.
7. Constructor and setter injection examples in `BookService`.
8. Basic AOP advice around service methods.

## Run

```powershell
mvn exec:java
```

The main class is `com.library.LibraryManagementApplication`.
