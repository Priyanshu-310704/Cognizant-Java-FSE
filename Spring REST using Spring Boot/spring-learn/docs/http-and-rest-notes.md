# HTTP and REST Notes

## HTTP Request and Response

A basic HTTP request contains a request line, headers, and an optional body.

Example:

```http
GET /hello HTTP/1.1
Host: localhost:8090
Accept: text/plain
```

A basic HTTP response contains a status line, headers, and an optional body.

Example:

```http
HTTP/1.1 200 OK
Content-Type: text/plain

Hello World!!
```

## REST URL Naming

- Use plural resource names for collections, such as `/countries` and `/employees`.
- Use `GET /resources` to fetch all resources.
- Use `GET /resources/{id}` to fetch one resource.
- Use `POST /resources` to create a resource.
- Use `PUT /resources` to update a resource.
- Use `DELETE /resources/{id}` to delete a resource.
- Use hyphens for multi-word resource names.

## Implemented Endpoints

- `GET /hello` returns `Hello World!!`.
- `GET /country` returns the India country bean loaded from XML.
- `GET /countries` returns the XML-backed country list.
- `GET /countries/{code}` returns a country by case-insensitive code.
- `POST /countries` accepts a JSON country payload and validates it.
- `GET /employees` returns the XML-backed employee list.
- `PUT /employees` updates an employee by payload id.
- `DELETE /employees/{id}` deletes an employee.
- `GET /departments` returns the XML-backed department list.
