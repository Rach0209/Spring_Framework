package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Test를 위해 Ctrl + Shift + T 를 사용하여 테스트 클래스 바로 만들기
//@Service

// JPA 사용할 때 주의할 것.
// Service 계층에 데이터를 저장하는 Transaction 을 걸어준다.
@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    
    // Test 할 때 다른 리포지터리를 참조 하는 것을 방지
    // 빈 등록
//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
    * 회원 가입
    * */
    public Long join(Member member) {
    // 주석 처리된 시간 관련 메소드는 AOP로 처리하였다.
//        long start = System.currentTimeMillis();

        // 같은 이름이 있는 중복 회원 X
//        Optional<Member> result = memberRepository.findByName(member.getName());
//        result.ifPresent(m -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        }); Optional 값이 아니라 바로 반환 시켜 버리기.
        // Ctrl + Alt + M 단축키 메소트로 추출하기;
//        try {
            validateDuplicateMember(member); // 중복 회원 검증
            memberRepository.save(member);
            return member.getId();
//        } finally {
//             long finish = System.currentTimeMillis();
//             long timeMs = finish - start;
//            System.out.println("join = " + timeMs + "ms");
//        }
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * 서비스는 비즈니스처리를 위해 설계를 좀 더 구체화 하기.*/
    public List<Member> findMembers() {
        // 주석 처리된 시간 관련 메소드는 AOP로 처리하였다.
//        long start = System.currentTimeMillis();
//        try {
            return memberRepository.findAll();
//        } finally {
//            long finish = System.currentTimeMillis();
//            long timeMs = finish - start;
//            System.out.println("findMembers " + timeMs + "ms");
//        }
    }

    /*
    * 아이디로 회원 조회*/
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
