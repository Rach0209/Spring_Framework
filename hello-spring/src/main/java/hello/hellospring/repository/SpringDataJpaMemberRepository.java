package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
    // 스프링 데이터 JPA 가 알아서 빈 등록해준다.
    // JPQL : select m from Member m where m.name = ?
    // 이런식으로 쿼리문을 짜준다.
    @Override
    public Optional<Member> findByName(String name);
}
