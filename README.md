# spring-study

## 라이브러리 살펴보기
- Gradle은 의존 관계가 있는 라이브러리를 다운로드 한다.

### Spring Boot Library
- Spring-boot-starter-web
  * spring-boot-web-tomecat: 톰캣(웹서버)
  * spring-webmvc: 스프링 웹 MVC
- spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)
- spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
  * spring-boot
    * spring-core
  * spring-boot-starter-logging
    * logback, slf4j

### Test Library 
- spring-boot-starter-test
  * junit: 테스트 프레임워크
  * mockito: 목 라이브러리
  * assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
  * spring-test: 스프링 통합 테스트 지원

## View 환경설정

### Welcome Page 만들기
- 스프링 부트가 제공하는 Welcome Page 기능
  * static/index.html 을 생성해놓으면 Welcome page 기능을 제공한다
  * https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web

### thymeleaf 템플릿 엔진
- thymeleaf 공식 사이트:https://www.thymeleaf.org/
- 스프링 공식 튜토리얼:https://spring.io/guides/gs/serving-web-content/
- 스프링부트 메뉴얼:https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web

### thymeleaf 템플릿 엔진 동작 확인*
- 실행: http://localhost:8080/hello
- Controller에서 리턴 값으로 문자를 반환하면 `viewResolver`가 화면을 찾아서 처리한다.
  * 스프링부트 템플릿엔진 기본 viewName 매핑
  * `resources:templates/` + {ViewName} + `.html`
  * 참고: `spring-boot-devtools` 라이브러리 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이 View 파일 변경이 가능하다.

** 출처: https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8&unitId=49605
