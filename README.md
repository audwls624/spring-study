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

## 빌드하고 실행하기

- 콘솔로 이동
1. `./gradlew build`
2. `cd build/libs`
3. `java -jar hello-spring-0.0.1-SNAPSHOT.jar`
4. 실행 확인

# 스프랭 웹 개발 기초

## 정적 컨텐츠
- 스프링 부트 정적 컨텐츠 기능
- https://docs.spring.io/spring-boot/docs/current/reference/html/web.html#web

*실행*
- http://localhost:8080/hello-static.html
1. `hello-static` 관련 컨트롤러 탐색
2. 1이 없으면 resources: `statc/hello-static.html` 가져옴

## MVC, 템플릿 엔진
- MVC: Model, View, Controller


*실행*
- http://localhost:8080/hello-mvc?name=spring
1. `helloController`에서 model(name:spring) 에 데이터를 담아 `hello-template` return
2. `ViewResolver` 에서 `templates/hello-template.html` (Tymeleaf 템플릿 엔진 처리) HTML 변환 후 렌더링

## API
*@ResponseBody 문자 반환*
- `@ResponseBody`를 사용하면 `viewResolver`를 사용하지 않음
- 대신에 HTTP BODY에 문자 내용을 직접 반환(HTTP BODY TAG를 말하는 것이 아님)
*실행*
- http://locahost:8080/hello-string?name=spring

*ResponseBody 객체 반환*
- `@ResponseBody`를 사용하고, 객체를 반환하면 객체가 JSON으로 변환됨.
*실행*
- http://localhost:8080/hello-adpi?name=spring
- `@ResponseBody`를 사용
  * HTTP BODY에 문자 내용을 직접 반환
  * `viewResolver` 대신에 `HttpMessageConverter`가 동작
  * 기본 문자 처리: `StringHttpMessageConverter`
  * 기본 객체 처리: `MappingJackson2HttpMessageConverter`
  * byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음
  * 참고: 클라이언트의 HTTP Accept 헤더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서 `HttpMessageConverter`가 선택된다.


** 출처: https://www.inflearn.com/course/lecture?courseSlug=%EC%8A%A4%ED%94%84%EB%A7%81-%EC%9E%85%EB%AC%B8-%EC%8A%A4%ED%94%84%EB%A7%81%EB%B6%80%ED%8A%B8&unitId=49605
