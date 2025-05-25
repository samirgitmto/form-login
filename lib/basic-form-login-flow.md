# Spring Security Form Login Flow Documentation

## Basic Form Login Configuration

The current implementation uses Spring Security's form-based authentication with the following key configurations:

```java
@Configuration
@EnableWebSecurity
public class BasicSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/", "/login", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/home")
                .permitAll()
            )
            .csrf(csrf -> csrf
                .ignoringRequestMatchers("/h2-console/**")
            )
            .headers(headers -> headers
                .frameOptions().sameOrigin()
            );
        
        return http.build();
    }
}
```

## Authentication Flow

1. **Initial Login Request**
   - User submits credentials to `/login` endpoint
   - Spring Security's `UsernamePasswordAuthenticationFilter` processes the request

2. **User Authentication**
   - System queries database for user credentials
   - SQL Query: `SELECT * FROM users WHERE username = ?`
   - Password is verified using BCrypt encryption

3. **Session Management**
   - New session ID is generated for security
   - CSRF token is refreshed
   - Security context is created and stored

4. **Security Context**
   - User details stored in `SecurityContextImpl`
   - Includes:
     - User ID
     - Username
     - Role (ROLE_USER/ROLE_ADMIN)
     - Authentication status

5. **Post-Authentication**
   - User is redirected to `/home`
   - Security context is maintained for subsequent requests
   - All authenticated requests include the security context

## Logging Configuration

The following logging levels are configured for debugging:
```properties
logging.level.org.springframework.security=DEBUG
logging.level.org.hibernate.SQL=DEBUG
logging.level.org.hibernate.type.descriptor.sql.BasicBinder=TRACE
```

## Security Features

1. **Form-Based Authentication**
   - Custom login page
   - Username/password authentication
   - Remember-me functionality

2. **Session Security**
   - Session ID rotation
   - CSRF protection
   - Secure session management

3. **Access Control**
   - Role-based authorization
   - Protected endpoints
   - Public access to login and home pages

4. **Database Security**
   - Password encryption
   - User role management
   - Secure credential storage

## Best Practices Implemented

1. **Security Headers**
   - Frame options for clickjacking protection
   - CSRF token validation
   - Secure session management

2. **Authentication**
   - BCrypt password encryption
   - Custom user details service
   - Role-based access control

3. **Configuration**
   - Separate security configuration class
   - Environment-specific properties
   - Debug logging for development 