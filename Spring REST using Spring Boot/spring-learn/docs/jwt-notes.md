# JWT Notes

## Basic Security

`SecurityConfig` defines two in-memory users:

- `user` with role `USER`
- `admin` with role `ADMIN`

The password for both users is `pwd`.

## Authentication Flow

1. The client calls `GET /authenticate` with HTTP Basic credentials.
2. `AuthenticationController` reads the `Authorization` header.
3. The controller decodes the Base64 `username:password` value and extracts the username.
4. `JwtService` creates a signed JWT with the username as the subject and a 20-minute expiry.
5. The endpoint returns a JSON response containing the token.

Example:

```powershell
curl -u user:pwd http://localhost:8090/authenticate
```

## Authorization Flow

1. The client sends `Authorization: Bearer <token>` on later requests.
2. `JwtAuthorizationFilter` extracts and validates the token.
3. If the token is valid, Spring Security receives an authenticated principal.
4. Secured endpoints such as `/countries`, `/employees`, and `/departments` can then be accessed.

Example:

```powershell
curl -H "Authorization: Bearer <token>" http://localhost:8090/countries
```
