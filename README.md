# 기본인증 회원관리 시스템

## 1. formLogin 유의사항

[customized login/logout]

```java
.formLogin(form -> form.loginPage("/login").permitAll());
```

- login customized = logout customized

[csrf]

- thymeleaf + formlogin /login 
- th:action="@{/login} method=post"

## 2. password encoding 방식

- 기본 : bcrypt
- idap, md4, md5, noop, pbkdf2, scrypt, SHA-1, SHA-256, argon2