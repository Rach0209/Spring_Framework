# IntelliJ IDEA를 사용해보자.

### Java 11, IntelliJ 및 Spring Boot 프로젝트 생성하기
##### Maven이 아닌 Gradle 체험!
#### Spring boot, Gradle Project, IntelliJ, Git Bash, Thymeleaf, ...
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
    <p>동작 확인</p>
    <li>기본 메인 클래스 실행</li>
    <li>스프링 부트 메인 실행 후 에러페이지로 간단하게 동작 확인( http://localhost:8080 )</li>
    <hr>
    <li >IntelliJ Gradle 대신에 자바 직접 실행 설정하기</li>
    <ul><p>상단 탭 메뉴 중 FIle => Settings => gradle 검색</p></ul>
    <ul><p>Build and run using 및 Run tests using 값 => 'IntelliJ IDEA'로 변경</p></ul>
    <ul><p>참고 : 윈도우에서 단축키 조회하기 : File => Settings => keymap</p></ul>
    <ul><p>Refactor This 단축키 : Ctrl + Alt + Shift + T</p></ul>
    </br>
    <li >IntelliJ JDK 설치 확인</li>
    <ul><li >프로젝트 JDK 설정</li></ul>
    <ul><li >gradle JDK 설정</li></ul>
    </br>
    <p>프로젝트 JDK 설정 확인</p>
    <p>* Windows: File => Project Structure(Ctrl+Alt+Shift+S) => Project SDK에서 java 버전 확인</br>
    * Mac: File => Project Structure (⌘;) => Project SDK에서 java 버전 확인</p>
    </br>
    <p>gradle JDK 설정 ( 위에서 설정 완료 )</p>
    <p>* Windows: File Settings(Ctrl+Alt+S)
    </br>
    * Mac: IntelliJ IDEA | Preferences(⌘,)</p>
    <p> Build and run using를 IntelliJ IDEA로 선택</br>
    Build tests using를 IntelliJ IDEA로 선택</br>
    Gradle JVM을 새로 설치한 자바 11로 지정</p>
    </br>
    <hr>
    <p>라이브러리 살펴보기</p>
    </br>
    <li >Gradle은 의존관계가 있는 라이브러리를 함께 다운로드 함.</li>
    </br>
    <p>스프링 부트 라이브러리</p>
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
    <p>테스트 라이브러리</P>
    <li>spring-boot-starter-test
    <ul>* junit: 테스트 프레임워크</ul>
    <ul>* mockito: 목 라이브러리</ul>
    <ul>* assertj: 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리</ul>
    <ul>* spring-test-: 스프링 통합 테스트 지원</ul>
    </li>
</details>
<hr>
<details>
    <summary >View 환경설정</summary>
    <li>Welcome Page 만들기</li>
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
<li>스프링 부트가 제공하는 Welcome Page기능</li>
<ul><li><code>static/index.html</code>을 올려두면 Welcome page 기능을 제공한다.</li></ul>
<ul><li><a href="https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-welcome-page">2.3.1.RELEASE버전 문서</a></li></ul>
</br>
<p>Thymeleaf템플릿 엔진</p>
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
<p>thymeleaf 템플릿엔진 동작 확인</p>
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
    </br>
    <li>콘솔로 이동</li>
    <ul><li>./gradlew build</li></ul>
    <ul><li>cd build/libs</li></ul>
    <ul><li>java -jar hello-spring-0.0.1-SNAPSHOT.jar</li></ul>
    <ul><li>실행 확인</li></ul>
    </br>
    <p>윈도우 사용자를 위한 팁</P>
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
    <a href="https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static-content">https://docs.spring.io/spring-boot/docs/2.3.1.RELEASE/reference/html/spring-boot-features.html#boot-features-spring-mvc-static-content</a>
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

<p><a href="http://localhost:8080/hello-static.html">실행</a></p>
</details>
</br>
<details>
    <summary>MVC와 템플릿 엔진</summary>
    <p>MVC : Model, View, Controller</p>
    </br>
    <p>Controller</p>
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
    <p>View</p>
    <code>resources/templates/hello-template.html</code>

    <html xmlns:th="http://www.thymeleaf.org">
    <body>
    <p th:text="'hello ' + ${name}">hello! empty</p>
    </body>
    </html>

<p>실행 : <a href="http://localhost:8080/hello-mvc?name=spring!!!">http://localhost:8080/hello-mvc?name=spring!!!</a></p>
</details>
</br>
<details>
    <summary>API</summary>
    </br>
    <p>@ResponseBody 문자 반환</p>
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
    <li>@ResponseBody를 사용하여 뷰 리졸버(viewResolver)를 사용하지 않게 되었음.</li>
    <li>대신, Http의 Body에 문자 내용을 직접 반환시켜 문자를 나타냄</li>
<p><a href="http://localhost:8080/hello-string?name=spring!!!">http://localhost:8080/hello-string?name=spring!!!</a></p>
<p>출력 화면 : hello spring!!!</p>
</br>
<p>@ResponseBody 객체 반환 (JSON)</p>
<pre><code>
@Controller
public class HelloController {
 @GetMapping("hello-api")
 @ResponseBody
 public Hello helloApi(@RequestParam("name") String name) {
 Hello hello = new Hello();
 hello.setName(name);
 return hello;
 }
 static class Hello {
 private String name;
 public String getName() {
 return name;
 }
 public void setName(String name) {
 this.name = name;
 }
 }
}
</code></pre>
<li>@ResponseBody를 사용하고, 객체를 반환하면 객체가 JSON으로 변환되어 나타난다.</li>
<ul><li>Spring의 Container에서 @ResponseBody가 있으면, HttpMessageConverter가 동작한다.</li></ul>
<ul><li>기본 문자처리: StringHttpMessageConverter</li></ul>
<ul><li>기본 객체처리: MappingJackson2HttpMessageConverter</li></ul>
<ul><li>byte 처리 등등 기타 여러 HttpMessageConverter가 기본으로 등록되어 있음</li></ul>
</br>
<p>참고: 클라이언트의 HTTP Accept 해더와 서버의 컨트롤러 반환 타입 정보 둘을 조합해서
HttpMessageConverter 가 선택된다.</p>
</details>
</br></br>
<hr>

### 회원 관리 예제 - 백엔드 개발 - spring의 생태계를 알아보기 위한 간단예제
<details>
    <summary>목차</summary>
    <li>비즈니스 요구사항 정리</li>
    <li>회원 도메인과 리포지토리 만들기</li>
    <li>회원 리포지토리 테스트 케이스 작성</li>
    <li>회원 서비스 개발</li>
    <li>회원 서비스 테스트</li>
</details>
</br>
<details>
    <summary>비즈니스 요구사항 정리</summary>
    <li>데이터: 회원ID, 이름</li>
    <li>기능: 회원 등록, 조회</li>
    <li>아직 데이터 저장소가 선정되지 않았음.(가상 시나리오)</li>
    </br>
    <p>일반적인 웹 어플리케이션 계층 구조</p>
    <img src="./일반적 웹어플리케이션 구조.png">
    <li>컨트롤러: 웹 MVC의 컨트롤러 역할</li>
    <li>서비스: 핵심 비즈니스 로직 구현</li>
    <li>리포지토리: 데이터베이스에 접근, 도메인 객체를DB에 저장하고 관리</li>
    <li>도메인: 비즈니스 도메인 객체, ex)회원, 주문, 쿠폰 등등 주로 데이터베이스에 저장하고 관리</li>
    </br>
    <p>클래스 의존관계</p>
    <img src="./클래스 의존관계.png">
    <li>아직 데이터 저장소가 선정되기 전, 우선 인터페이스로 구현 클래스를 변경할 수 있도록 설계</li>
    <li>데이터 저장소는 RDB, NoSQL 등등 다양한 저장소를 고민중인 상황으로 가정한다.</li>
    <li>개발을 진행하기 위해서 초기 개발 단계에서는 구현체로 가벼운 메모리 기반의 데이터 저장소 사용</li>
</details>
<hr>
</br>
<details>
    <summary>회원 도메인과 리포지토리 만들기</summary>
    </br>
    <p>회원 객체</p>

    package hello.hellospring.domain;
    public class Member {
    
    private Long id;
    private String name;
    public Long getId() {
    return id;
    }
    public void setId(Long id) {
    this.id = id;
    }
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
    }
</br>
    <p>회원 리포지토리 인터페이스</p>

    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import java.util.List;
    import java.util.Optional;
    public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
    }
</br>
    <p>회원 리포지토리 메모리 구현체</p>

    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import java.util.*;
    /**
    * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
    */
    public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
    member.setId(++sequence);
    store.put(member.getId(), member);
    return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
    return Optional.ofNullable(store.get(id));
    }
    @Override
    public List<Member> findAll() {
    return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
    return store.values().stream()
    .filter(member -> member.getName().equals(name))
    .findAny();
    }
    public void clearStore() {
    store.clear();
    }
    }
    
</br>
<h4>회원 리포지토리 테스트 케이스 작성</h4>
<p>개발한 기능을 실행해서 테스트 할 때 자바의 main 메서드를 통해서 실행하거나, 웹 애플리케이션의
컨트롤러를 통해서 해당 기능을 실행한다. 이러한 방법은 준비하고 실행하는데 오래 걸리고, 반복 실행하기
어렵고 여러 테스트를 한번에 실행하기 어렵다는 단점이 있다. 자바는 JUnit이라는 프레임워크로 테스트를
실행해서 이러한 문제를 해결한다.</p>
</br>
<p>src/test/java 하위 폴더에 생성하기 - test 폴더가 포인트</p>

    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import org.junit.jupiter.api.AfterEach;
    import org.junit.jupiter.api.Test;
    import java.util.List;
    import java.util.Optional;
    import static org.assertj.core.api.Assertions.*;
    class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach
    public void afterEach() {
    repository.clearStore();
    }
    @Test
    public void save() {
    //given
    Member member = new Member();
    member.setName("spring");
    //when
    repository.save(member);
    //then
    Member result = repository.findById(member.getId()).get();
    assertThat(result).isEqualTo(member);
    }
    @Test
    public void findByName() {
    //given
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);
    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);
    //when
    Member result = repository.findByName("spring1").get();
    //then
    assertThat(result).isEqualTo(member1);
    }
    @Test
    public void findAll() {
    //given
    Member member1 = new Member();
    member1.setName("spring1");
    repository.save(member1);
    Member member2 = new Member();
    member2.setName("spring2");
    repository.save(member2);
    //when
    List<Member> result = repository.findAll();
    //then
    assertThat(result.size()).isEqualTo(2);
    }
    }

<li>@AfterEach : 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 이렇게
되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다. @AfterEach 를 사용하면 각 테스트가
종료될 때 마다 이 기능을 실행한다. 여기서는 메모리 DB에 저장된 데이터를 삭제한다.</li>
<li>테스트는 각각 독립적으로 실행되어야 하며, 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.</li>
</details>
</br>
<details>
    <summary>회원 서비스 개발</summary>

    package hello.hellospring.service;
    import hello.hellospring.domain.Member;
    import hello.hellospring.repository.MemberRepository;
    import java.util.List;
    import java.util.Optional;
    public class MemberService {
    private final MemberRepository memberRepository = new
    MemoryMemberRepository();
    /**
    * 회원가입
    */
    public Long join(Member member) {
    validateDuplicateMember(member); //중복 회원 검증
    memberRepository.save(member);
    return member.getId();
    }
    private void validateDuplicateMember(Member member) {
    memberRepository.findByName(member.getName())
    .ifPresent(m -> {
    throw new IllegalStateException("이미 존재하는 회원입니다.");
    });
    }
    /**
    * 전체 회원 조회
    */
    public List<Member> findMembers() {
    return memberRepository.findAll();
    }
    public Optional<Member> findOne(Long memberId) {
    return memberRepository.findById(memberId);
    }
    }
</br>
    <h4>회원 서비스 테스트</h4>
    <p>기존에는 회원 서비스가 메모리 회원 리포지토리를 직접 생성하게 함.</p>

    public class MemberService {
    private final MemberRepository memberRepository = 
    new MemoryMemberRepository();
    }

</br>
    <p>회원 리포지토리의 코드가 회원 서비스 코드를 DI가능하게 변경</p>



</details>


