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
    <P>참고 : MemberService클래스에서 Test를 위해 단축키 : Ctrl + Shift + T 를 사용하여 테스트 클래스 바로 만들기</p>

    public class MemberService {
    private final MemberRepository memberRepository = 
    new MemoryMemberRepository();
    }

</br>
    <p>회원 리포지토리의 코드가 회원 서비스 코드를 DI가능하게 변경</p>
    
    public class MemberService {
        // Test 할 때 다른 리포지터리를 참조 하는 것을 방지하기 위해
        // 직접 생성한 리포지토리를 DI가능하게 변경
        private final MemberRepository memberRepository;
        public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
        }
        ...
    }

<p>회원 서비스 테스트</p>
<pre><code>
package hello.hellospring.service;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
// Test자동완성 단축키 : Ctrl + Shift + T
class MemberServiceTest {
    // new 로 생성하면 다른 인스턴스로 사용하여 디비가 달라 질 수 있다.
    // MemberService에서 코드 수정했음. 생성자만듬.
    MemberService memberService;
    MemoryMemberRepository memberRepository;

    // MemberRepository 를 생성하기 전에 MemberService에서 미리 넣어준다.
    // MemberService 입장에서 DI된 상태.
    @BeforeEach
    public void beforeEach() {
    memberRepository = new MemoryMemberRepository();
    memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
    memberRepository.clearStore();
    }

    // 테스트는 메소드를 한글로 해도 상관없다.
    // 확인하기가 아주 편리해짐. 기본은 영어지만 상관없음.
    // 빌드될 때 테스트 코드는 포함되지 않기 때문.
    @Test
    public void 회원가입() throws Exception {
    //Given
    Member member = new Member();
    member.setName("hello");
    //When
    Long saveId = memberService.join(member);
    //Then
    Member findMember = memberRepository.findById(saveId).get();
    assertEquals(member.getName(), findMember.getName());
    }
    @Test
    public void 중복_회원_예외() throws Exception {
    //Given
    Member member1 = new Member();
    member1.setName("spring");
    Member member2 = new Member();
    member2.setName("spring");
    //When
    memberService.join(member1);
    IllegalStateException e = assertThrows(IllegalStateException.class,
    () -> memberService.join(member2));//예외가 발생해야 한다.
    assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

    // try-catch 문으로 잡을 수 있지만, 로직이 복잡해지고 try-catch 를 잡기가 애매하다
        /*
        try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }
        */
    }
}
</code></pre>
</br>
<p>@BeforeEach : 각 테스트 실행 전에 호출된다. 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 
의존관계도 새로 맺어준다.</p>
</details>
<hr>
<h4>스프링 빈과 의존관계</h4>
<li>컴포넌트 스캔과 자동 의존관계 설정</li>
<li>자바 코드로 직접 스프링 빈 등록하기</li>
</br>
<details>
    <summary>컴포넌트 스캔과 자동 의존관계 설정</summary>
    <p>회원 컨트롤러가 회원서비스와 회원 리포지토리를 사용할 수 있게 의존관계를 준비.</p>
    </br>
    <h6>회원 컨트롤러에 의존관계 추가<h6>
<pre><code>
package hello.hellospring.controller;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
    this.memberService = memberService;
    }
}

</code></pre>

<li>생성자에 @Autowired 가 있으면 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어준다. 이렇게
객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.</li>
<li>이전 테스트에서는 개발자가 직접 주입했고, 여기서는 @Autowired에 의해 스프링이 주입해준다</li>
</br>
<h6>오류 발생</h6>
<pre><code>
Consider defining a bean of type 'hello.hellospring.service.MemberService' in 
your configuration.
</code></pre>
</br>
<h6>memberService가 스프링 빈으로 등록되어 있지 않다.</h6>
<img src="./스프링 빈X.png">
<p>참고: helloController는 스프링이 제공하는 컨트롤러여서 스프링 빈으로 자동 등록된다.
> @Controller 가 있으면 자동 등록됨</p>
</br>
<h6>스프링 빈을 등록하는 2가지 방법</h6>
<li>컴포넌트 스캔과 자동 의존관계 설정</li>
<li>자바 코드로 직접 스프링 빈 등록하기</li>
</br>
<li>@Component 애노테이션이 있으면 스프링 빈으로 자동 등록된다.</li>
<li>@Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문이다.</li>
<li>@Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록된다.</li>
<ul><li>@Controller</li></ul>
<ul><li>@Service</li></ul>
<ul><li>@Repository</li></ul>
</br>
<h6>회원 서비스 스프링 빈 등록</h6>
<pre><code>
@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
    this.memberRepository = memberRepository;
    }
}
</code></pre>

<p>참고: 생성자에 @Autowired 를 사용하면 객체 생성 시점에 스프링 컨테이너에서 해당 스프링 빈을 찾아서
주입한다. 생성자가 1개만 있으면 @Autowired 는 생략할 수 있다.</p>
</br>
<h6>회원 리포지토리 스프링 빈 등록</h6>
<pre><code>
@Repository
public class MemoryMemberRepository implements MemberRepository {}
</code></pre>
</br>
<p>스프링 빈 등록 이미지</p>
<img src="./스프링 빈 등록 이미지.png">
<li>memberService 와 memberRepository 가 스프링 컨테이너에 스프링 빈으로 등록되었다.</li>
</hr>
<p>기본적으로 컴포넌트 스캔은 실행되는 main method가 속한 Package를 포함한 하위 package에서만 찾아준다.</p>
</br>
<p> 참고: 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다(유일하게 하나만
등록해서 공유한다) 따라서 같은 스프링 빈이면 모두 같은 인스턴스다. 설정으로 싱글톤이 아니게 설정할 수
있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용한다.</p>
</details>
</br>
<details>
    <summary>자바 코드로 직접 스프링 빈 등록하기</summary>
    <li>회원 서비스와 회원 리포지토리의 @Service, @Repository, @Autowired 애노테이션을 제거하고 진행.</li>
    <pre><code>
package hello.hellospring;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Configuration
public class SpringConfig {
    @Bean
    public MemberService memberService() {
    return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
    return new MemoryMemberRepository();
    }
}
    </code></pre>
    </br>
    <h5>여기서는 향후 메모리 리포지토리를 다른 리포지토리로 변경할 예정이므로, 컴포넌트 스캔 방식 대신에
    자바 코드로 스프링 빈을 설정함. 다른 코드에 손대지 않고, 구현체를 바꿔치기 할 수 있다!</h5>
    <p>참고: XML로 설정하는 방식도 있지만 최근에는 잘 사용하지 않음. Framework 폴더에 xml로 설정한 방식도 연습되어있음.</p>
    <p>참고: DI에는 필드 주입, setter 주입, 생성자 주입 이렇게 3가지 방법이 있다. 의존관계가 실행중에
    동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다</p>
    <p>참고: 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다. 
    그리고 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로
    등록한다</p>
    <h6>주의: @Autowired 를 통한 DI는 helloController , memberService 등과 같이 스프링이 관리하는
    객체에서만 동작한다. 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다</h6>
</br>
<p>MemberController.java에서 변경 내용 필기.</p>
    <pre><code>
package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    // 인스턴스로 생성하여 사용도 가능하지만, 다른 곳에서 사용하는 MemberService 와 다른 객체가된다.
    // 똑같은 객체를 사용할 때, 여러개를 사용할 필요없이 스프링 컨테이너가 관리하게 하나만 사용하는게 편리.
//    private final MemberService memberService = new MemberService();
    private final MemberService memberService;
//    @Autowired private final MemberService memberService; 필드 주입도 가능하지만, 좋지 않은 방식.
//    setter 주입방식. => 멤버 컨트롤을 호출했을 때, public 으로 열려 있어야 함.
//    누구에게나 노출되어있어 좋지 않다. 조립 시점에 생성하고, 변경하지 못하도록 막아야 한다.
//    결론 : 생성자 주입을 권장.
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // 처음에 오류발생 : MemberService 가 처음에는 순수한 자바 코드였기 때문에.
    // 애노테이션을 등록 해주기 전이었다.
    // @Repository 와 @Service 를 적용 시켜줌으로 해결.
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
    </code></pre>
    </br>
</details>
<hr>
<h4>회원 관리 예제 - 웹 MVC 개발</h4>
<li>회원 웹 기능 - 홈 화면 추가</li>
<li>회원 웹 기능 - 등록</li>
<li>회원 웹 기능 - 조회</li>
</br>
<details>
    <summary>회원 웹 기능 - 홈 화면 추가</summary>
    </br>
    <h6>홈 컨트롤러 추가</h6>
    <pre><code>
package hello.hellospring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
 @GetMapping("/")
 public String home() {
 return "home";
 }
}
    </code></pre>
    </br>
    <h6>회원 관리용 홈</h6>

    <!DOCTYPE HTML>
    <html xmlns:th="http://www.thymeleaf.org">
    <body>
    <div class="container">
        <div>
            <h1>Hello Spring</h1>
            <p>회원 기능</p>
            <p>
            <a href="/members/new">회원 가입</a>
            <a href="/members">회원 목록</a>
            </p>
        </div>
    </div> <!-- /container -->
    </body>
    </html>

<p>참고: 컨트롤러가 정적 파일보다 우선순위가 높다.</p>
<h6>요청이 오면, 스프링 컨테이너안의 컨트롤러를 찾고, 없다면 static한 정적파일을 찾기때문.</h6>
</details>
</br>
<details>
    <summary>회원 웹 기능 - 등록</summary>
    <p>회원 등록 폼 개발</p>
    <h6>회원 등록 폼 컨트롤러</h6>
    <pre><code>
@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
    this.memberService = memberService;
    }
    @GetMapping(value = "/members/new")
    public String createForm() {
    return "members/createMemberForm";
    }
}
    </code></pre>
    </br>
    <h6>회원 등록 폼HTML (resources/templates/members/createMemberForm)</h6>
    
    <!DOCTYPE HTML>
    <html xmlns:th="http://www.thymeleaf.org">
    <body>
    <div class="container">
        <form action="/members/new" method="post">
            <div class="form-group">
            <label for="name">이름</label>
            <input type="text" id="name" name="name" placeholder="이름을
            입력하세요">
            </div>
            <button type="submit">등록</button>
        </form>
    </div> <!-- /container -->
    </body>
    </html>

</br>
<p>회원 등록 컨트롤러</p>
</br>
<h6>웹 등록 화면에서 데이터를 전달 받을 폼 객체</h6>

package hello.hellospring.controller;
public class MemberForm {
    private String name;
    public String getName() {
    return name;
    }
    public void setName(String name) {
    this.name = name;
    }
}

</br>
<h6>회원 컨트롤러에서 회원을 실제 등록하는 기능</6h>

@PostMapping(value = "/members/new")
public String create(MemberForm form) {
    Member member = new Member();
    member.setName(form.getName());
    memberService.join(member);
    return "redirect:/";
}
</br>
</details>
</br>
<details>
    <summary>회원 웹 기능 - 조회</summary>
    </br>
    <h6>회원 컨트롤러에서 조회 기능</h6>
    
    @GetMapping(value = "/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }    

</br>
<h6>회원 리스트 HTML</h6>

    <!DOCTYPE HTML>
    <html xmlns:th="http://www.thymeleaf.org">
    <body>
        <div class="container">
            <div>
                <table>
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>이름</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr th:each="member : ${members}">
                        <td th:text="${member.id}"></td>
                        <td th:text="${member.name}"></td>
                    </tr>
                    </tbody>
                </table>
           </div>
    </div> <!-- /container -->
    </body>
    </html>

</br>
</details>
<hr>
<h4>스프링 DB 접근 기술</h4>
<p>스프링 데이터 엑세스</p>
<li>H2 데이터베이스 설치</li>
<li>순수 Jdbc</li>
<li>스프링 통합 테스트</li>
<li>스프링 JdbcTemplate</li>
<li>JPA</li>
<li>스프링 데이터 JPA</li>
</br>
<details>
    <summary>H2 데이터베이스 설치</summary>
    <p>개발이나 테스트 용도로 가볍고 편리한 DB, 웹 화면을 제공한다.</p>
    <h6> 주의!</br>
> h2 데이터베이스는 꼭 다음 링크에 들어가서 1.4.200 버전을 설치해주세요.</br>
> 최근에 나온 2.0.206 버전을 설치하면 일부 기능이 정상 동작하지 않습니다.</br>
> <a href="https://www.h2database.com/html/download-archive.html">https://www.h2database.com/html/download-archive.html</a></br>
> 만약 이미 설치하고 실행까지 했다면 다시 설치한 이후에 ~/test.mv.db 파일을 꼭 삭제해주세요.</br>
> 그렇지 않으면 다음 오류가 발생하면서 접속되지 않습니다.</br>
> General error: "The write format 1 is smaller than the supported format 2 
[2.0.206/5]" [50000-202] HY000/50000</h6>
<hr>
<li><a href="https://www.h2databae.com">https://www.h2databae.com</a></li>
<li>다운로드 및 설치</li>
<li>h2 데이터베이스 버전은 스프링 부트 버전에 맞춘다.</li>
<li>권한 추가: chmod 755 h2.sh (윈도우 x)</li>
<li>실행: ./h2.sh (윈도우 x)</li>
<li>데이터베이스 파일 생성 방법</li>
<ul><li>jdbc:h2:~/test (최초 한번만)</li></ul>
<ul><li>~/test.mv.db 파일 생성 확인</li></ul>
<ul><li>이후부터 jdbc:h2:tcp://localhost/~/test 로 접속</li></ul>
    </br>
</details>
</br>
<details>
    <summary>테이블 생성하기</summary>
    <h6>테이블 관리를 위해 프로젝트 루트에 sql/ddl.sql 파일 생성</h6>
    <pre><code>
    drop table if exists member CASCADE;
    create table member
    (
        id bigint generated by default as identity,
        name varchar(255),
        primary key (id)
    );
</code></pre>
</br>
<p>H2 데이터베이스에 접근해서 member 테이블 생성</p>
</details>
</br>
<details>
    <summary>순수 Jdbc</summary>
    </br>
    <p>환경 설정</p>
    </br>
    <h6>build.gradle 파일에 jdbc, h2 데이터베이스 관련 라이브러리 추가</h6>
    <pre><code>
    implementation 'org.springframework.boot:spring-boot-starter-jdbc'
    runtimeOnly 'com.h2database:h2'
    </code></pre>
    </br>
    <h6>스프링 부트 데이터베이스 연결 설정 추가</h6>
    <code>
    resources/application.properties
    </code>
    <pre><code>
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
    </code></pre>
    </br>
    <li>주의 : 스프링부트 2.4부터는 spring.datasource.username=sa 를 꼭 추가해주어야 한다. 그렇지
않으면 Wrong user name or password 오류가 발생한다. 참고로 다음과 같이 마지막에 공백이
들어가면 같은 오류가 발생한다. spring.datasource.username=sa 공백 주의, 공백은 모두
제거해야 한다.</li>
</details>
</br>
<details>
    <summary>Jdbc 리포지토리 구현</summary>
    </br>
    <h6>주의! 이렇게 JDBC API로 직접 코딩하는 것은 20년 전 이야기이다. 따라서 고대 개발자들이 이렇게 고생하고 살았구나 생각하고, 정신건강을 위해 참고만 하기!</h6>
    </br>
    <h6>Jdbc 회원 리포지토리</h6>


    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import org.springframework.jdbc.datasource.DataSourceUtils;
    import javax.sql.DataSource;
    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.Optional;
    public class JdbcMemberRepository implements MemberRepository {
        private final DataSource dataSource;
        public JdbcMemberRepository(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        @Override
        public Member save(Member member) {
            String sql = "insert into member(name) values(?)";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql,
                Statement.RETURN_GENERATED_KEYS);
                pstmt.setString(1, member.getName());
                pstmt.executeUpdate();
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    member.setId(rs.getLong(1));
                } else {
                    throw new SQLException("id 조회 실패");
                }
                return member;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            } finally {
                close(conn, pstmt, rs);
            }
        }

        @Override
        public Optional<Member> findById(Long id) {
            String sql = "select * from member where id = ?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setLong(1, id);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getLong("id"));
                    member.setName(rs.getString("name"));
                    return Optional.of(member);
                } else {
                    return Optional.empty();
                }
            } catch (Exception e) {
                throw new IllegalStateException(e);
            } finally {
            close(conn, pstmt, rs);
            }
        }

        @Override
        public List<Member> findAll() {
            String sql = "select * from member";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                rs = pstmt.executeQuery();
                List<Member> members = new ArrayList<>();
                while(rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getLong("id"));
                    member.setName(rs.getString("name"));
                    members.add(member);
                }
                return members;
            } catch (Exception e) {
                throw new IllegalStateException(e);
            } finally {
                close(conn, pstmt, rs);
            }
        }

        @Override
        public Optional<Member> findByName(String name) {
            String sql = "select * from member where name = ?";
            Connection conn = null;
            PreparedStatement pstmt = null;
            ResultSet rs = null;
            try {
                conn = getConnection();
                pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, name);
                rs = pstmt.executeQuery();
                if(rs.next()) {
                    Member member = new Member();
                    member.setId(rs.getLong("id"));
                    member.setName(rs.getString("name"));
                    return Optional.of(member);
                }
                return Optional.empty();
            } catch (Exception e) {
                throw new IllegalStateException(e);
            } finally {
                close(conn, pstmt, rs);
            }
        }

        private Connection getConnection() {
            return DataSourceUtils.getConnection(dataSource);
        }
        private void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (conn != null) {
                    close(conn);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        private void close(Connection conn) throws SQLException {
            DataSourceUtils.releaseConnection(conn, dataSource);
        }
    }

</br>
    <h6>스프링 설정 변경</h6>

<pre><code>
package hello.hellospring;
import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
@Configuration
public class SpringConfig {
    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
        // return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}
</code></pre>

</br>
<p>DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다. 스프링 부트는 데이터베이스 커넥션
정보를 바탕으로 DataSource를 생성하고 스프링 빈으로 만들어둔다. 그래서 DI를 받을 수 있다.</p>
<hr>
<h6>구현 클래스 추가 이미지</h6>
<img src="./클래스 의존관계 추가.png">
</br>
<h6>스프링 설정 이미지</h6>
<img src="./스프링 빈 등록 이미지2.png">
</br>
<li>개방-폐쇄 원칙(OCP, Open-Closed Principle)</il>
<ul><li>확장에는 열려있고, 수정, 변경에는 닫혀있다.</li></ul>
<li>스프리의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고, 설정만으로 구현 클래스를 변경할 수 있다.</il>
<li>회원을 등록하고 DB에 결과가 잘 입력되는지 확인.</il>
<li>데이터를 DB에 저장하므로 스프링 서버를 다시 실행해도 데이터가 안전하게 저장되어있음.</il>
</details>
</br>
<details>
    <summary>스프링 통합 테스트</summary>
    <p>스프링 컨테이너와 DB까지 연결한 통합 테스트 진행하기.</p>
    </br>
    <h6>회원 서비스 스프링 통합 테스트</h6>

<pre><code>
package hello.hellospring.service;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;
    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hello");

        //When
        Long saveId = memberService.join(member);

        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertEquals(member.getName(), findMember.getName());
    }
    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");

        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                    () -> memberService.join(member2)); // 예외가 발생해야 한다.

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
}
</code></pre>

</br>
<li>@SpringBootTest : 스프링 컨테이너와 테스트를 함께 실행한다.</li>
<li>@Transactional : 테스트 케이스에 이 애노테이션이 있으면, 테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백한다. 이렇게 하면 DB에 데이터가 남지 않으므로 다음 테스트에 영향을 주지않는다.</li>
</details>
</br>
<details>
    <summary>스프링 JdbcTemplate</summary>
    <li>순수 Jdbc와 동일한 환경설정을 하면 된다.</li>
    <li>스프링 JdbcTemplate과 MyBatis 같은 라이브러리는 JDBC API에서 본 반복 코드를 대부분 제거해준다. 하지만 SQL은 직접 작성해야 한다.</li>
    </br>
    <h6>스프링 JdbcTemplate 회원 리포지토리</h6>


    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import org.springframework.jdbc.core.JdbcTemplate;
    import org.springframework.jdbc.core.RowMapper;
    import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
    import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
    import javax.sql.DataSource;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
    import java.util.Optional;
    public class JdbcTemplateMemberRepository implements MemberRepository {
        private final JdbcTemplate jdbcTemplate;
        public JdbcTemplateMemberRepository(DataSource dataSource) {
            jdbcTemplate = new JdbcTemplate(dataSource);
        }
        @Override
        public Member save(Member member) {
            SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
            jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("name", member.getName());
            Number key = jdbcInsert.executeAndReturnKey(new
            MapSqlParameterSource(parameters));
            member.setId(key.longValue());
            return member;
        }
        @Override
        public Optional<Member> findById(Long id) {
            List<Member> result = jdbcTemplate.query("select * from member where id = ?", memberRowMapper(), id);
            return result.stream().findAny();
        }
        @Override
        public List<Member> findAll() {
            return jdbcTemplate.query("select * from member", memberRowMapper());
        }
        @Override
        public Optional<Member> findByName(String name) {
            List<Member> result = jdbcTemplate.query("select * from member where name = ?", memberRowMapper(), name);
            return result.stream().findAny();
        }
        private RowMapper<Member> memberRowMapper() {
            return (rs, rowNum) -> {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setName(rs.getString("name"));
                return member;
            };
        }
    }

</br>
    <h6>JdbcTemplate을 사용하도록 스프링 설정 변경</h6>
    
    package hello.hellospring;
    import hello.hellospring.repository.JdbcMemberRepository;
    import hello.hellospring.repository.JdbcTemplateMemberRepository;
    import hello.hellospring.repository.MemberRepository;
    import hello.hellospring.repository.MemoryMemberRepository;
    import hello.hellospring.service.MemberService;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import javax.sql.DataSource;
    @Configuration
    public class SpringConfig {
        private final DataSource dataSource;
            public SpringConfig(DataSource dataSource) {
            this.dataSource = dataSource;
        }
        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }
        @Bean
        public MemberRepository memberRepository() {
            // return new MemoryMemberRepository();
            // return new JdbcMemberRepository(dataSource);
            return new JdbcTemplateMemberRepository(dataSource);
        }
    }

</details>
</br>
<details>
    <summary>JPA</summary>
    <li>JPA는 기존의 반복 코드는 물론이고, 기본적인 SQL도 JPA가 직접 만들어서 실행해준다.</li>
    <li>JPA를 사용하면, SQL과 데이터 중심의 설계에서 객체 중심의 설계로 패러다임을 전환을 할 수 있다.</li>
    <li>JPA를 사용하면 개발 생산성을 크게 높일 수 있다.</li>
    </br>
    <h6>build.gradle 파일에 JPA h2 데이터베이스 관련 라이브러리 추가</h6>
    
    dependencies {
        implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
        implementation 'org.springframework.boot:spring-boot-starter-web'
        // implementation 'org.springframework.boot:spring-boot-starter-jdbc'
        implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
        runtimeOnly 'com.h2database:h2'
        testImplementation('org.springframework.boot:spring-boot-starter-test') {
            exclude group: 'org.junit.vintage', module: 'junit-vintage-engine'
        }
    }

</br>
<p>spring-boot-starter-data-jpa 는 내부에 jdbc 관련 라이브러리를 포함한다. 따라서 jdbc는 제거해도 된다.</p>
</br>
<h6>스프링 부트에 JPA 설정 추가</h6>
<code>resources/application.properties</code>
<pre><code>
spring.datasource.url=jdbc:h2:tcp://localhost/~/test
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=none
</code></pre>
</br>
<p> 주의!: 스프링부트 2.4부터는 spring.datasource.username=sa 를 꼭 추가해주어야 한다. 그렇지 않으면 오류가 발생한다.</p>
<li>show-sql : JPA가 생성하는 SQL을 출력한다.</li>
<li>ddl-auto : JPA는 테이블을 자동으로 생성하는 기능을 제공하는데 none 를 사용하면 해당 기능을 끈다.</li>
<ul><li>create 를 사용하면 엔티티 정보를 바탕으로 테이블도 직접 생성해준다.</li></ul>
</br>
<h6>JPA 엔티티 매핑</h6>


    package hello.hellospring.domain;
    import javax.persistence.Entity;
    import javax.persistence.GeneratedValue;
    import javax.persistence.GenerationType;
    import javax.persistence.Id;
    @Entity
    public class Member {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    <h6>JPA 회원 리포지토리</h6>


    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import javax.persistence.EntityManager;
    import java.util.List;
    import java.util.Optional;
    public class JpaMemberRepository implements MemberRepository {
        private final EntityManager em;
            public JpaMemberRepository(EntityManager em) {
            this.em = em;
        }
        public Member save(Member member) {
            em.persist(member);
            return member;
        }
        public Optional<Member> findById(Long id) {
            Member member = em.find(Member.class, id);
            return Optional.ofNullable(member);
        }
        public List<Member> findAll() {
            return em.createQuery("select m from Member m", Member.class).getResultList();
        }
        public Optional<Member> findByName(String name) {
            List<Member> result = em.createQuery("select m from Member m where 
            m.name = :name", Member.class).setParameter("name", name).getResultList();
            return result.stream().findAny();
        }
    }

</br>
<h6>서비스 계층에 트랜잭션 추가</h6>
<pre><code>
import org.springframework.transaction.annotation.Transactional
@Transactional
public class MemberService {}
</code></pre>
</br>
<li>org.springframework.transaction.annotation.Transactional 를 사용하자.</li>
<li>스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고, 메서드가 정상 종료되면 트랜잭션을 커밋한다. 만약 런타임 예외가 발생하면 롤백한다.</li>
<li>JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.</li>
</br>
<h6>JPA를 사용하도록 스프링 설정 변경</h6>


    package hello.hellospring;
    import hello.hellospring.repository.*;
    import hello.hellospring.service.MemberService;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import javax.persistence.EntityManager;
    import javax.sql.DataSource;
    @Configuration
    public class SpringConfig {
        private final DataSource dataSource;
        private final EntityManager em;
        public SpringConfig(DataSource dataSource, EntityManager em) {
            this.dataSource = dataSource;
            this.em = em;
        }
        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository());
        }
        @Bean
        public MemberRepository memberRepository() {
            // return new MemoryMemberRepository();
            // return new JdbcMemberRepository(dataSource);
            // return new JdbcTemplateMemberRepository(dataSource);
            return new JpaMemberRepository(em);
        }
    }

</br>
<p>JPA는 추가적인 학습을 하는게 좋을 것 같음.</p>
<a href="https://www.inflearn.com/course/ORM-JPA-Basic">- 인강 링크</a>
</details>
</br>
<details>
    <summary>스프링 데이터 JPA</summary>
    <p>스프링 부트와 JPA만 사용해도 개발 생산성이 정말 많이 증가하고, 개발해야할 코드도 확연히 줄어듭니다.
    </br>여기에 스프링 데이터 JPA를 사용하면, 기존의 한계를 넘어 마치 마법처럼, 리포지토리에 구현 클래스 없이 인터페이스 만으로 개발을 완료할 수 있습니다.
    </br>그리고 반복 개발해온 기본 CRUD 기능도 스프링 데이터 JPA가 모두 제공합니다.
    </br>스프링 부트와 JPA라는 기반 위에, 스프링 데이터 JPA라는 환상적인 프레임워크를 더하면 개발이 정말 즐거워집니다.
    </br>지금까지 조금이라도 단순하고 반복이라 생각했던 개발 코드들이 확연하게 줄어듭니다. 
    </br>따라서 개발자는 핵심 비즈니스 로직을 개발하는데, 집중할 수 있습니다.
    </br>실무에서 관계형 데이터베이스를 사용한다면 스프링 데이터 JPA는 이제 선택이 아니라 필수 입니다.</p>
    <p>주의: 스프링 데이터 JPA는 JPA를 편리하게 사용하도록 도와주는 기술입니다. 따라서 JPA를 먼저 학습한 후에 스프링 데이터 JPA를 학습하는 것을 권장.</p>
    <li>앞의 JPA 설정을 그대로 사용.</li>
    </br>
    <h6>스프링 데이터 JPA 회원 리포지토리</h6>


    package hello.hellospring.repository;
    import hello.hellospring.domain.Member;
    import org.springframework.data.jpa.repository.JpaRepository;
    import java.util.Optional;
    public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
        Optional<Member> findByName(String name);
    }

</br>
    <h6>스프링 데이터 JPA 회원 리포지토리를 사용하도록 스프링 설정 변경</h6>
    

    package hello.hellospring;
    import hello.hellospring.repository.*;
    import hello.hellospring.service.MemberService;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    @Configuration
    public class SpringConfig {
        private final MemberRepository memberRepository;

        public SpringConfig(MemberRepository memberRepository) {
            this.memberRepository = memberRepository;
        }

        @Bean
        public MemberService memberService() {
            return new MemberService(memberRepository);
        }
    }

</br>
    <li>스프링 데이터 JPA가 SpringDataJpaMemberRepository를 스프링 빈으로 자동 등록해준다.</li>
    </br>
    <h6>스프링 데이터 JPA 제공 클래스</h6>
    <img src="스프링 데이터 JPA 제공 클래스.png">
    </br>
    <h6>스프링 데이터 JPA 제공 기능</h6>
    <li>인터페이스를 통한 기본적인 CRUD</li>
    <li>findByName(), findByEmail() 처럼 메소드 이름 만으로 조회 기능 제공</li>
    <li>페이징 기능 자동 제공</li>
    </br>
    <p>참고: 실무에서는 JPA와 스프링 데이터 JPA를 기본으로 사용하고, 복잡한 동적 쿼리는 Querydsl이라는 라이브러리를 사용하면 된다.
    </br>Querydsl을 사용하면 쿼리도 자바 코드로 안전하게 작성할 수 있고, 동적 쿼리도 편리하게 작성할 수 있다.
    </br>이 조합으로 해결하기 어려운 쿼리는 JPA가 제공하는 네이티브 쿼리를 사용하거나, 앞서 학습한 스프링 JdbcTemplate를 사용하면 된다.</p>
</details>
<hr>
    <h4>AOP</h4>
<details>
    <summary>AOP가 필요한 상황 예시</summary>
    <li>모든 메소드의 호출 시간을 축정하고 싶을 때.</li>
    <li>공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)</li>
    <li>회원 가입 시간, 회원 조회 시간을 측정하고 싶을 때.</li>
    <img src="./AOP가 필요한 상황.png">
    </br>
    <h6>MemberService 회원 조회 시간 측정 추가</h6>


    package hello.hellospring.service;
    @Transactional
    public class MemberService {
        /**
        * 회원가입
        */
        public Long join(Member member) {
            long start = System.currentTimeMillis();
            try {
                validateDuplicateMember(member); //중복 회원 검증
                memberRepository.save(member);
                return member.getId();
            } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join " + timeMs + "ms");
            }
        }
        /**
        * 전체 회원 조회
        */
        public List<Member> findMembers() {
            long start = System.currentTimeMillis();
            try {
                return memberRepository.findAll();
            } finally {
                long finish = System.currentTimeMillis();
                long timeMs = finish - start;
                System.out.println("findMembers " + timeMs + "ms");
            }
        }
    }

</br>
<p>문제</p>
<li>회원가입, 회원 조회에 시간을 측정하는 기능은 핵심 관심 사항이 아님.</li>
<li>시간을 측정하는 로직은 공통 관심 사항이다.</li>
<li>시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어렵다.</li>
<li>시간을 측정하는 로직을 별도의 공통 로직으로 만들기 매우 어렵다.</li>
<li>시간을 측정하는 로직을 변경할 때 모든 로직을 찾아가면서 변경해야 한다.</li>
</details>
</br>
<details>
    <summary>AOP 적용</summary>
    <li>AOP : Aspect Oriented Programming</li>
    <li>공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)분리</li>
    <img src="./AOP적용.png">
    </br>
    <h6>시간 측정 AOP 등록</h6>


    package hello.hellospring.aop;
    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.springframework.stereotype.Component;
    @Component
    @Aspect
    public class TimeTraceAop {
        @Around("execution(* hello.hellospring..*(..))")
        public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
            long start = System.currentTimeMillis();
            System.out.println("START: " + joinPoint.toString());
            try {
                return joinPoint.proceed();
            } finally {
                long finish = System.currentTimeMillis();
                long timeMs = finish - start;
                System.out.println("END: " + joinPoint.toString()+ " " + timeMs + "ms");
            }
        }
    }

</br>
<h6>해결</h6>
<li>회원가입, 회원 조회 등 핵심 관심사항과 시간을 측정하는 공통 관심 사항을 분리한다.</li>
<li>시간을 측정하는 로직을 별도의 공통 로직으로 만들었다.</li>
<li>핵심 관심 사항을 깔끔하게 유지할 수 있다.</li>
<li>변경이 필요하면 이 로직만 변경하면 된다.</li>
<li>원하는 적용 대상을 선택할 수 있다.</li>
</details>
</br>
<details>
    <summary>스프링의 AOP 동작 방식 설명</summary>
    </br>
    <h6>AOP 적용 전 의존관계</h6>
    <img src="./AOP적용전.png">
    </br>
    <h6>AOP 적용 후 의존관계</h6>
    <img src="./AOP적용후.png">
    <h5>참고 : proxy라는 기술로 발생하는 가짜 스프링 빈을 세우고, 프록시에서 작업이 끝나면 실제 스프링 빈으로 넘겨준다.</h5>
    </br>
    <h6>AOP 적용 전 전체 그림</h6>
    <img src="./AOP적용전전체.png">
    <h6>AOP 적용 후 전체 그림</h6>
    <img src="./AOP적용후전체.png">
    </br>
    <li>실제 Proxy가 주입되는지 콘솔에 출력해서 확인하기</li>
    <li>MemberController에서 MemberService가 Injection 되는 부분에 콘솔 출력 추가함.</li>
    <ul><li>memberService= class hello.hellospring.service.MemberService$$EnhancerBySpringCGLIB$$c08aa438</li></ul>
    <ul><li>EnhancerBySpringCGLIB 라는 것이 확인.</li></ul>
    <ul><li>-> MemberService를 복제해서 코드를 조작하는 기술.</li></ul>
</details>
</br>
<details>
    <summary>참고 인강 로드맵</summary>
    <a href="https://www.inflearn.com/roadmaps/149">스프링 부트와 JPA 실무 완전 정복 로드맵</a>
</details>




