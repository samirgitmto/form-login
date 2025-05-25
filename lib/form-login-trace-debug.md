# Spring Security TRACE and DEBUG Logs

## Login Request Processing

```
2025-05-25T15:34:46.203+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=Or [Mvc [pattern='/**']], Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@3aaccdbf, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@215b17f9, org.springframework.security.web.context.SecurityContextHolderFilter@65bdf1d6, org.springframework.security.web.header.HeaderWriterFilter@5928b99c, org.springframework.web.filter.CorsFilter@3e9cbf2c, org.springframework.security.web.csrf.CsrfFilter@6c1367e3, org.springframework.security.web.authentication.logout.LogoutFilter@2f1671d7, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@7a7cb49a, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@48ade734, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@3392f76f, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@65e421af, org.springframework.security.web.access.ExceptionTranslationFilter@3294ef5f, org.springframework.security.web.access.intercept.AuthorizationFilter@3665b132]] (1/1)
2025-05-25T15:34:46.206+05:30 DEBUG 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Securing POST /login
2025-05-25T15:34:46.208+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
2025-05-25T15:34:46.209+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
2025-05-25T15:34:46.216+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderFilter (3/13)
2025-05-25T15:34:46.218+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
2025-05-25T15:34:46.220+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
2025-05-25T15:34:46.225+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking CsrfFilter (6/13)
2025-05-25T15:34:46.229+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (7/13)
2025-05-25T15:34:46.230+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.s.w.a.logout.LogoutFilter            : Did not match request to Ant [pattern='/logout', POST]
2025-05-25T15:34:46.232+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.security.web.FilterChainProxy        : Invoking UsernamePasswordAuthenticationFilter (8/13)
2025-05-25T15:34:46.233+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.s.authentication.ProviderManager     : Authenticating request with DaoAuthenticationProvider (1/1)
2025-05-25T15:34:46.440+05:30 DEBUG 10484 --- [nio-8080-exec-2] org.hibernate.SQL                        : 
    select
        u1_0.id,
        u1_0.enabled,
        u1_0.password,
        u1_0.role,
        u1_0.username
    from
        users u1_0
    where
        u1_0.username=?
Hibernate: 
    select
        u1_0.id,
        u1_0.enabled,
        u1_0.password,
        u1_0.role,
        u1_0.username
    from
        users u1_0
    where
        u1_0.username=?
2025-05-25T15:34:46.623+05:30 DEBUG 10484 --- [nio-8080-exec-2] o.s.s.a.dao.DaoAuthenticationProvider    : Authenticated user
2025-05-25T15:34:46.624+05:30 TRACE 10484 --- [nio-8080-exec-2] s.CompositeSessionAuthenticationStrategy : Preparing session with ChangeSessionIdAuthenticationStrategy (1/2)
2025-05-25T15:34:46.626+05:30 DEBUG 10484 --- [nio-8080-exec-2] .s.ChangeSessionIdAuthenticationStrategy : Changed session id from F04F0E02FFAEC9EBE9A7538D01931216
2025-05-25T15:34:46.628+05:30 TRACE 10484 --- [nio-8080-exec-2] s.CompositeSessionAuthenticationStrategy : Preparing session with CsrfAuthenticationStrategy (2/2)
2025-05-25T15:34:46.629+05:30 DEBUG 10484 --- [nio-8080-exec-2] o.s.s.w.csrf.CsrfAuthenticationStrategy  : Replaced CSRF Token
2025-05-25T15:34:46.631+05:30 DEBUG 10484 --- [nio-8080-exec-2] w.c.HttpSessionSecurityContextRepository : Stored SecurityContextImpl [Authentication=UsernamePasswordAuthenticationToken [Principal=User(id=2, username=user, password=$2a$10$QOh9RouMiaDYVc6Y7zW4H.Plv6RpwmMmpLwgqCVRwVjR656RFQjHq, role=USER, enabled=true), Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=F04F0E02FFAEC9EBE9A7538D01931216], Granted Authorities=[ROLE_USER]]] to HttpSession [org.apache.catalina.session.StandardSessionFacade@7755b1a5]
2025-05-25T15:34:46.633+05:30 DEBUG 10484 --- [nio-8080-exec-2] w.a.UsernamePasswordAuthenticationFilter : Set SecurityContextHolder to UsernamePasswordAuthenticationToken [Principal=User(id=2, username=user, password=$2a$10$QOh9RouMiaDYVc6Y7zW4H.Plv6RpwmMmpLwgqCVRwVjR656RFQjHq, role=USER, enabled=true), Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=F04F0E02FFAEC9EBE9A7538D01931216], Granted Authorities=[ROLE_USER]]
2025-05-25T15:34:46.634+05:30 DEBUG 10484 --- [nio-8080-exec-2] o.s.s.web.DefaultRedirectStrategy        : Redirecting to /home
2025-05-25T15:34:46.636+05:30 TRACE 10484 --- [nio-8080-exec-2] o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
```

## Home Page Access

```
2025-05-25T15:34:46.646+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Trying to match request against DefaultSecurityFilterChain [RequestMatcher=Or [Mvc [pattern='/**']], Filters=[org.springframework.security.web.session.DisableEncodeUrlFilter@3aaccdbf, org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter@215b17f9, org.springframework.security.web.context.SecurityContextHolderFilter@65bdf1d6, org.springframework.security.web.header.HeaderWriterFilter@5928b99c, org.springframework.web.filter.CorsFilter@3e9cbf2c, org.springframework.security.web.csrf.CsrfFilter@6c1367e3, org.springframework.security.web.authentication.logout.LogoutFilter@2f1671d7, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter@7a7cb49a, org.springframework.security.web.savedrequest.RequestCacheAwareFilter@48ade734, org.springframework.security.web.servletapi.SecurityContextHolderAwareRequestFilter@3392f76f, org.springframework.security.web.authentication.AnonymousAuthenticationFilter@65e421af, org.springframework.security.web.access.ExceptionTranslationFilter@3294ef5f, org.springframework.security.web.access.intercept.AuthorizationFilter@3665b132]] (1/1)
2025-05-25T15:34:46.649+05:30 DEBUG 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Securing GET /home
2025-05-25T15:34:46.650+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking DisableEncodeUrlFilter (1/13)
2025-05-25T15:34:46.651+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking WebAsyncManagerIntegrationFilter (2/13)
2025-05-25T15:34:46.652+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderFilter (3/13)
2025-05-25T15:34:46.655+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking HeaderWriterFilter (4/13)
2025-05-25T15:34:46.656+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking CorsFilter (5/13)
2025-05-25T15:34:46.658+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking CsrfFilter (6/13)
2025-05-25T15:34:46.659+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.csrf.CsrfFilter         : Did not protect against CSRF since request did not match And [CsrfNotRequired [TRACE, HEAD, GET, OPTIONS], Not [Or [org.springframework.boot.autoconfigure.security.servlet.PathRequest$H2ConsoleRequestMatcher@7bfbe8c4]]]
2025-05-25T15:34:46.662+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking LogoutFilter (7/13)
2025-05-25T15:34:46.663+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.s.w.a.logout.LogoutFilter            : Did not match request to Ant [pattern='/logout', POST]
2025-05-25T15:34:46.663+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking UsernamePasswordAuthenticationFilter (8/13)
2025-05-25T15:34:46.664+05:30 TRACE 10484 --- [nio-8080-exec-3] w.a.UsernamePasswordAuthenticationFilter : Did not match request to Ant [pattern='/login', POST]
2025-05-25T15:34:46.664+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking RequestCacheAwareFilter (9/13)
2025-05-25T15:34:46.665+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.s.w.s.HttpSessionRequestCache        : matchingRequestParameterName is required for getMatchingRequest to lookup a value, but not provided
2025-05-25T15:34:46.666+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking SecurityContextHolderAwareRequestFilter (10/13)
2025-05-25T15:34:46.668+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking AnonymousAuthenticationFilter (11/13)
2025-05-25T15:34:46.670+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking ExceptionTranslationFilter (12/13)
2025-05-25T15:34:46.672+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Invoking AuthorizationFilter (13/13)
2025-05-25T15:34:46.673+05:30 TRACE 10484 --- [nio-8080-exec-3] estMatcherDelegatingAuthorizationManager : Authorizing SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@1e5d9de3]
2025-05-25T15:34:46.676+05:30 TRACE 10484 --- [nio-8080-exec-3] estMatcherDelegatingAuthorizationManager : Checking authorization on SecurityContextHolderAwareRequestWrapper[ org.springframework.security.web.header.HeaderWriterFilter$HeaderWriterRequest@1e5d9de3] using org.springframework.security.authorization.AuthenticatedAuthorizationManager@4bd000d8     
2025-05-25T15:34:46.680+05:30 TRACE 10484 --- [nio-8080-exec-3] w.c.HttpSessionSecurityContextRepository : Retrieved SecurityContextImpl [Authentication=UsernamePasswordAuthenticationToken [Principal=User(id=2, username=user, password=$2a$10$QOh9RouMiaDYVc6Y7zW4H.Plv6RpwmMmpLwgqCVRwVjR656RFQjHq, role=USER, enabled=true), Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=F04F0E02FFAEC9EBE9A7538D01931216], Granted Authorities=[ROLE_USER]]] from SPRING_SECURITY_CONTEXT
2025-05-25T15:34:46.681+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.s.w.a.AnonymousAuthenticationFilter  : Did not set SecurityContextHolder since already authenticated UsernamePasswordAuthenticationToken [Principal=User(id=2, username=user, password=$2a$10$QOh9RouMiaDYVc6Y7zW4H.Plv6RpwmMmpLwgqCVRwVjR656RFQjHq, role=USER, enabled=true), Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=F04F0E02FFAEC9EBE9A7538D01931216], Granted Authorities=[ROLE_USER]]
2025-05-25T15:34:46.683+05:30 DEBUG 10484 --- [nio-8080-exec-3] o.s.security.web.FilterChainProxy        : Secured GET /home
Home page requested
2025-05-25T15:34:46.696+05:30 TRACE 10484 --- [nio-8080-exec-3] o.s.s.w.header.writers.HstsHeaderWriter  : Not injecting HSTS header since it did not match request to [Is Secure]
``` 