sequenceDiagram
    participant User
    participant Browser
    participant FilterChainProxy
    participant DisableEncodeUrlFilter
    participant WebAsyncManagerIntegrationFilter
    participant SecurityContextHolderFilter
    participant HeaderWriterFilter
    participant CorsFilter
    participant CsrfFilter
    participant LogoutFilter
    participant UsernamePasswordAuthFilter
    participant ProviderManager
    participant DaoAuthenticationProvider
    participant Database
    participant SessionAuthStrategy
    participant RequestCacheAwareFilter
    participant SecurityContextAwareFilter
    participant AnonymousAuthFilter
    participant ExceptionTranslationFilter
    participant AuthorizationFilter
    participant HomeController

    Note over User,Browser: POST /login (Authentication Flow)
    User->>Browser: POST /login (credentials)
    Browser->>FilterChainProxy: POST /login
    Note right of FilterChainProxy: DEBUG: Securing POST /login
    
    loop Filter Chain Execution (1-13)
        FilterChainProxy->>DisableEncodeUrlFilter: (1/13)
        DisableEncodeUrlFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>WebAsyncManagerIntegrationFilter: (2/13)
        WebAsyncManagerIntegrationFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>SecurityContextHolderFilter: (3/13)
        Note right of SecurityContextHolderFilter: TRACE: Initializes empty context
        SecurityContextHolderFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>HeaderWriterFilter: (4/13)
        HeaderWriterFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>CorsFilter: (5/13)
        CorsFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>CsrfFilter: (6/13)
        CsrfFilter-->>FilterChainProxy: Valid CSRF token
        
        FilterChainProxy->>LogoutFilter: (7/13)
        Note right of LogoutFilter: TRACE: Not /logout request
        LogoutFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>UsernamePasswordAuthFilter: (8/13)
        UsernamePasswordAuthFilter->>ProviderManager: Authenticate
        ProviderManager->>DaoAuthenticationProvider: (1/1 provider)
        DaoAuthenticationProvider->>Database: Query user
        Note right of Database: DEBUG: SELECT u1_0.id...WHERE username=?
        Database-->>DaoAuthenticationProvider: User details
        DaoAuthenticationProvider-->>ProviderManager: Authentication
        ProviderManager-->>UsernamePasswordAuthFilter: Success
        Note right of DaoAuthenticationProvider: DEBUG: Authenticated user
        
        UsernamePasswordAuthFilter->>SessionAuthStrategy: Change session
        Note right of SessionAuthStrategy: DEBUG: Changed session id\nDEBUG: Replaced CSRF Token
        SessionAuthStrategy-->>UsernamePasswordAuthFilter: Session updated
        
        UsernamePasswordAuthFilter->>SecurityContextHolderFilter: Store context
        Note right of SecurityContextHolderFilter: DEBUG: Stored SecurityContextImpl
        SecurityContextHolderFilter-->>UsernamePasswordAuthFilter: Stored
        
        UsernamePasswordAuthFilter-->>FilterChainProxy: Authentication success
        
        FilterChainProxy->>RequestCacheAwareFilter: (9/13)
        Note right of RequestCacheAwareFilter: TRACE: No cached request
        RequestCacheAwareFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>SecurityContextAwareFilter: (10/13)
        SecurityContextAwareFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>AnonymousAuthFilter: (11/13)
        Note right of AnonymousAuthFilter: TRACE: Already authenticated
        AnonymousAuthFilter-->>FilterChainProxy: Skip
        
        FilterChainProxy->>ExceptionTranslationFilter: (12/13)
        ExceptionTranslationFilter-->>FilterChainProxy: No exceptions
        
        FilterChainProxy->>AuthorizationFilter: (13/13)
        AuthorizationFilter-->>FilterChainProxy: Access granted
    end
    
    FilterChainProxy->>Browser: 302 Redirect to /home
    Note right of FilterChainProxy: DEBUG: Redirecting to /home

    Note over User,Browser: GET /home (Authenticated Access)
    Browser->>FilterChainProxy: GET /home
    Note right of FilterChainProxy: DEBUG: Securing GET /home
    
    loop Filter Chain Execution (1-13)
        FilterChainProxy->>DisableEncodeUrlFilter: (1/13)
        DisableEncodeUrlFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>WebAsyncManagerIntegrationFilter: (2/13)
        WebAsyncManagerIntegrationFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>SecurityContextHolderFilter: (3/13)
        Note right of SecurityContextHolderFilter: DEBUG: Retrieved SecurityContextImpl
        SecurityContextHolderFilter-->>FilterChainProxy: Authenticated context
        
        FilterChainProxy->>HeaderWriterFilter: (4/13)
        HeaderWriterFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>CorsFilter: (5/13)
        CorsFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>CsrfFilter: (6/13)
        Note right of CsrfFilter: TRACE: CSRF not required for GET
        CsrfFilter-->>FilterChainProxy: Skip
        
        FilterChainProxy->>LogoutFilter: (7/13)
        LogoutFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>UsernamePasswordAuthFilter: (8/13)
        Note right of UsernamePasswordAuthFilter: TRACE: Not /login request
        UsernamePasswordAuthFilter-->>FilterChainProxy: Skip
        
        FilterChainProxy->>RequestCacheAwareFilter: (9/13)
        RequestCacheAwareFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>SecurityContextAwareFilter: (10/13)
        SecurityContextAwareFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>AnonymousAuthFilter: (11/13)
        AnonymousAuthFilter-->>FilterChainProxy: Skip
        
        FilterChainProxy->>ExceptionTranslationFilter: (12/13)
        ExceptionTranslationFilter-->>FilterChainProxy: Continue
        
        FilterChainProxy->>AuthorizationFilter: (13/13)
        Note right of AuthorizationFilter: TRACE: Checking authorization
        AuthorizationFilter-->>FilterChainProxy: Access granted
    end
    
    FilterChainProxy->>HomeController: Forward request
    HomeController-->>FilterChainProxy: Home page content
    FilterChainProxy-->>Browser: 200 OK
    Browser->>User: Render home page
    Note right of Browser: Home page requested