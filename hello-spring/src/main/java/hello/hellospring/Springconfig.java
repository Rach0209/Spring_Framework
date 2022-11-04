package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

// 코드로 직접 스프링 빈을 등록하기!!
@Configuration
public class Springconfig {

    // 스프링 데이터 JPA 사용할 때.
    private final MemberRepository memberRepository;

    @Autowired
    public Springconfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    // AOP
    // 정형화 되어 있다고 보기 힘듦
    // Component 를 사용했음.
//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }

// JPA 에서 Entity 매핑 쓸 때.
//    private EntityManager em;
//
//    @Autowired
//    public Springconfig(EntityManager em) {
//        this.em = em;
//    }

//    private final DataSource dataSource;
//
//    @Autowired
//    public Springconfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }


//    @Bean
//    public MemberService memberService() {
//        return new MemberService(memberRepository());
//    }

//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
