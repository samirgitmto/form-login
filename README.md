# Spring Security Form Login Implementation

This project demonstrates the implementation of form-based authentication in Spring Security, covering basic to advanced configurations.

## Project Structure

```
src/main/java/com/example/formlogin/
├── config/
│   ├── basic/          # Basic security configurations
│   ├── intermediate/   # Intermediate security configurations
│   └── advanced/       # Advanced security configurations
├── controller/
│   ├── web/           # Thymeleaf controllers
│   └── api/           # REST controllers
├── model/             # Entity classes
├── repository/        # Data access layer
├── service/          # Business logic
└── security/         # Security related classes
    ├── basic/
    ├── intermediate/
    └── advanced/
```

## Technology Stack

- Spring Boot 3.2.3
- Spring Security
- Thymeleaf
- Spring Data JPA
- H2 Database
- Lombok
- Spring Boot DevTools

## Setup Instructions

1. Clone the repository
2. Import the project into your IDE
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```

## Configuration Profiles

The project uses different Spring profiles for different security configurations:

- `basic-form-login`: Basic form login implementation
- `intermediate-form-login`: Intermediate security features
- `advanced-form-login`: Advanced security features

To switch between profiles, modify the `spring.profiles.active` property in `application.properties` or use the command line:
```bash
mvn spring-boot:run -Dspring.profiles.active=basic-form-login
```

## Features

### Basic Level
- Simple form login
- Basic user authentication
- Role-based access control
- Password encryption

### Intermediate Level
- Custom authentication
- Session management
- Remember-me functionality
- Account locking

### Advanced Level
- Multi-factor authentication
- Custom filters
- Rate limiting
- Audit logging

## Development

1. Start with the basic configuration
2. Implement features incrementally
3. Test each security configuration
4. Document changes and security considerations

## Testing

- Unit tests for security components
- Integration tests for authentication flows
- Security testing for each configuration

## Security Considerations

- CSRF protection
- XSS prevention
- Session management
- Password policies
- Account security
- Audit logging 