# Hibernate XML and Annotation Configuration Walkthrough

## XML Configuration

- A persistence class contains Java fields and accessor methods.
- A mapping XML file maps class fields to table columns.
- `hibernate.cfg.xml` contains driver, URL, username, password, dialect, and mapping resource entries.
- Runtime flow: build `SessionFactory`, open `Session`, begin `Transaction`, call `save`, `get`, query, or `delete`, then `commit` or `rollback`.

## Annotation Configuration

- `@Entity` marks a persistence class.
- `@Table` maps the class to a table.
- `@Id` marks the primary key.
- `@GeneratedValue` configures automatic id generation.
- `@Column` maps a field to a table column.
- The Hibernate configuration still supplies database connection and dialect properties.
