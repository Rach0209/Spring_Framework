# IntelliJ IDEA를 사용해보자.

### Java 11, IntelliJ 및 Spring Boot 프로젝트 생성하기
##### Maven이 아닌 Gradle 체험!
#### Spring boot, Gradle Project, IntelliJ, Git Bash, Thymeleaf, ...
<Style>
    summary {
        font-weight: bold;
    }
    .subtitle {
        font-weight: bold;
    }
</Style>
<details>
    <summary>Spring Boot 프로젝트 생성하기</summary>
    </br>
    <p>스프링 부트 스타터 사이트로 이동해서 스프링 프로젝트 생성하기</p>
    <p><a href="https://start.spring.io" >https://start.spring.io</a></p>
    <p>참고 : 버전에서 (SNAPSHOT) 혹은 다른 영어가 붙은 버전은 정식 RELEASE된 버전이 아니다.</p>
    <p>Dependencies : Spring Web, Thymeleaf</p>
    <p>* build.gradle</p>
    <pre>
    <code>
    plugins {
	id 'org.springframework.boot' version '2.7.5'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
	id 'java'
}

group = 'hello'
version = '0.0.1-SNAPSHOT'
sourceCompatibility = '11'

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
}

tasks.named('test') {
	useJUnitPlatform()
}
    </code>
    </pre>
</details>
</br>

<details>
    <summary>설치</summary>
    </br>
    <p>JDK 8 버전을 받을 때와 동일하게 설치한다.</p>
    <p>다만, 이번 연습은 JDK 11을 사용하기 때문에 11을 설치.<a href="https://www.oracle.com/kr/java/technologies/javase/jdk11-archive-downloads.html">JDK 11 설치링크</a></p>
    <p>IntelliJ는 그냥 알아서 무료판 받아서 하면 된다.</p>
    <p><a href="https://goddaehee.tistory.com/195">IntelliJ 설치 참고</a></p>
</details>
</br>

<details>
    <summary>시작하기</summary>
    </br>
    <p class="subtitle">동작 확인</p>
    <li>기본 메인 클래스 실행</li>
    <li>스프링 부트 메인 실행 후 에러페이지로 간단하게 동작 확인( http://localhost:8080 )</li>
    <hr>
    <p class="subtitle">IntelliJ Gradle 대신에 자바 직접 실행 설정하기</p>
    <p>상단 탭 메뉴 중 FIle => Settings => gradle 검색</p>
    <p>Build and run using 및 Run tests using 값 => 'IntelliJ IDEA'로 변경</p>
    <p>참고 : 윈도우에서 단축키 조회하기 : File => Settings => keymap</p>
    <p>Refactor This 단축키 : Ctrl + Alt + Shift + T</p>
    </br>
    <p class="subtitle">IntelliJ JDK 설치 확인</p>
    <li class="subtitle">프로젝트 JDK 설정</li>
    <li class="subtitle">gradle JDK 설정</li>
    </br>
    <p class="subtitle">프로젝트 JDK 설정 확인</p>
    <p>* Windows: File => Project Structure(Ctrl+Alt+Shift+S) => Project SDK에서 java 버전 확인</br>
    * Mac: File => Project Structure (⌘;) => Project SDK에서 java 버전 확인</p>
    </br>
    <p class="subtitle">gradle JDK 설정 ( 위에서 설정 완료 )</p>
    <p>* Windows: File Settings(Ctrl+Alt+S)
    </br>
    * Mac: IntelliJ IDEA | Preferences(⌘,)</p>
    <p> Build and run using를 IntelliJ IDEA로 선택</br>
    Build tests using를 IntelliJ IDEA로 선택</br>
    Gradle JVM을 새로 설치한 자바 11로 지정</p>
    </br>
    <hr>
    <p class="subtitle">라이브러리 살펴보기</p>
    </br>
    <li class="subtitle">Gradle은 의존관계가 있는 라이브러리를 함께 다운로드 함.</li>
    </br>
    <p class="subtitle">스프링 부트 라이브러리</p>
    <li>
    spring-boot-starter-web
    <li>spring-boot-starter-tomcat: 톰캣 (웹서버)</li>
    <li>spring-webmvc: 스프링 웹 MVC</li>
    <li>spring-boot-starter-thymeleaf: 타임리프 템플릿 엔진(View)</li>
    <li>spring-boot-starter(공통): 스프링 부트 + 스프링 코어 + 로깅
    <li>spring-boot
    <ul>* spring-core</ul>
    </li>
    <li>spring-boot-starter-logging
    <ul>* logback, slf4j</ul>
    </li></li></li>
    </br>
    <p class="subtitle">테스트 라이브러리</P>
    <li>spring-boot-starter-test
    <ul>* junit: 테스트 프레임워크</ul>
    <ul>* mockito: 목 라이브러리</ul>
    <ul>* assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리</ul>
    <ul>* spring-test-: 스프링 통합 테스트 지원</ul>
    </li>
</details>
<hr>
<details>
    <summary class="subtitle">View 환경설정</summary>
    <p>Welcome Page 만들기</p>
    <code>
    resoures/static/index.html
    </code>

    
    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <title>Hello</title>
    </head>
    <body>
    <p>Hello 인데요?</p>
    <a href="/hello">hello</a>
    </body>
    </html>
<li>스프링 부트가 제공하는 Welcome Page기능
<ul><code>static/index.html</code>을 올려두면 Welcome page 기능을 제공한다.</ul>
<ul><a href="https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page">2.3.1.RELEASE버전 문서</a></ul>
</li>
</br>
<p class="subtitle">Thymeleaf템플릿 엔진</p>
<li>thymeleaf 공식 사이트:<a href=" https://www.thymeleaf.org/">https://www.thymeleaf.org/</a></li>
<li>스프링 공식 튜토리얼: <a href="https://spring.io/guides/gs/serving-web-content/">링크</a></li>
<li>스프링부트 메뉴얼: <a href="https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/
html/spring-boot-features.html#boot-features-spring-mvc-template-engines">링크 지금 쓰는것은 2.7.5 버전인데 강의에서 (2.3.1.버전 사용중)</a></li>
<hr>
<code>src/main/java/helo.hellospring.controller/HelloController.java</code>
<pre>
<code>
@Controller
public class HelloController {
 @GetMapping("hello")
 public String hello(Model model) {
 model.addAttribute("data", "hello!!");
 return "hello";
 }
}
</code>
</pre>
</br>
<code>resources/templates/hello.html</code>

    <!DOCTYPE HTML>
    <html xmlns:th="http://www.thymeleaf.org">
    <head>
    <title>Hello</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
    <p th:text="'안녕하세요. ' + ${data}" >안녕하세요. 손님</p>
    </body>
    </html>
<p class="subtitle">thymeleaf 템플릿엔진 동작 확인</p>
<li>실행주소 : <a href="http://localhost:8080/hello">http://localhost:8080/hello</a></li>
</br>
<li>컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버( viewResolver )가 화면을 찾아서 처리한다.
    <ul>스프링 부트 템플릿엔진 기본 viewName 매핑</ul>
    <ul>resources:templates/ +{ViewName}+ .html</ul>
</li>
<p> 참고: spring-boot-devtools 라이브러리를 추가하면, html 파일을 컴파일만 해주면 서버 재시작 없이
View 파일 변경이 가능하다.
> 인텔리J 컴파일 방법: 메뉴 build => Recompile</br>구글링해서 devtools 라이브러리 추가 가능.</p>
</details>
</br>
<details>
    <summary>빌드하고 실행하기</summary>
    <p>콘솔로 이동</p>
    <ol>./gradlew build</ol>
    <ol>cd build/libs</ol>
    <ol>java -jar hello-spring-0.0.1-SNAPSHOT.jar</ol>
    <ol>실행 확인</ol>
    </br>
    <p class="subtitle">윈도우 사용자를 위한 팁</P>
    <li>콘솔로 이동 => cmd로 이동</li>
    <li>./gradlew => gradlew.bat 실행</li>
    <li>cmd에서 gradlew.bat를 실행하려면 gradlew하고 엔터.</li>
    <li>gradlew build</li>
    <li>폴더 목록 확인 dir (git bash에서는 ls)</li>
    <li>윈도우에서 Git bash 터미널 사용하기 <a href="https://www.inflearn.com/questions/53961">링크</a></li>
</details>
<hr>
<details>
    <summary>스프링 웹 개발 기초</summary>
    <li>정적 컨텐츠</li>
    <li>MVC와 템플릿 엔진</li>
    <details>
        <summary>API</summary>
        <p>쉽게 말하면, JSON이라는 데이터 포맷으로 클라이언트에게 데이터를 전달하는 방식.</p>
        <p>Vue, React등 API로 데이터만 내려주면 화면은 클라이언트가 알아서 그리고 정리하는 방식.</p>
        <p>혹은 서버끼리 통신할 때.</p>
    </details>
</details>
</br>
<details>
    <summary>정적 컨텐츠</summary>
    <p>스프링 부트 정적 컨텐츠 기능</p>
    <a href="https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-bootfeatures.html#boot-features-spring-mvc-static-content">https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-bootfeatures.html#boot-features-spring-mvc-static-content</a>
    </br>
<code>resources/static/hello-static.html</code> 

    <!DOCTYPE HTML>
    <html>
    <head>
    <title>static content</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    </head>
    <body>
    정적 컨텐츠 입니다.
    </body>
    </html>

<p class="subtitle"><a href="http://localhost:8080/hello-static.html">실행</a></p>
</details>
</br>
<details>
    <summary>MVC와 템플릿 엔진</summary>
    <p>MVC : Model, View, Controller</p>
    </br>
    <p class="subtitle">Controller</p>
    <pre><code>
    @Controller
public class HelloController {
 @GetMapping("hello-mvc")
 public String helloMvc(@RequestParam("name") String name, Model model) {
 model.addAttribute("name", name);
 return "hello-template";
 }
}
    </code></pre>
    </br>
    <p class="subtitle">View</p>
    <code>resources/templates/hello-template.html</code>

    <html xmlns:th="http://www.thymeleaf.org">
    <body>
    <p th:text="'hello ' + ${name}">hello! empty</p>
    </body>
    </html>

<p>실행 : <a href="http://localhost:8080/hello-mvc?name=spring">http://localhost:8080/hello-mvc?name=spring</a></p>
</details>
</br>
<details>
    <summary>API</summary>
    </br>
    <p class="subtitle">@ResponseBody 문자 반환</p>
    <pre><code>
    @Controller
public class HelloController {
 @GetMapping("hello-string")
 @ResponseBody
 public String helloString(@RequestParam("name") String name) {
 return "hello " + name;
 }
}
    </code></pre>

</details>
