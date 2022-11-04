package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
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
    void 회원가입() {
        // given
        Member member = new Member();
        member.setName("spring");

        // when
        Long saveId = memberService.join(member);

        // then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // try-catch 문으로 잡을 수 있지만, 로직이 복잡해지고 try-catch 를 잡기가 애매하다
        /*try {
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        // then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}