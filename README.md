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

## 3. customized authentication provider

- authentication provider는 내부적으로 customized userDetailsService를 참조
- provider의 supports에 부합하면 authenticate 진행

## 4. customized logout

- customized login
- customized logout을 통한 처리(*GetMapping/PostMapping 모두 가능, postMapping을 강력 권장)
- 로그인 : sec:authroize="isAnonymous()", 로그아웃 : sec:authorize="isAuthenticated()"
  - xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity6"
  - thymleaf에서 제공하는 springsecurity 전용 표현식(sec:authroize = {...}) 등 활용

# 5. authentication details

- 기본 id/password 뿐만 아니라, 사용자 IP주소 및 session id 등을 저장하는 곳.
- setDetails