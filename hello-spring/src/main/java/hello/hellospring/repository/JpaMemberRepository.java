package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {
    // JPA 는 EntityManager 라는 것을 주입해주어야하고, 이것으로 작업을 수행한다.
    private final EntityManager em;

    public JpaMemberRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        // Ctrl + Alt + V 사용 하면 "List<Member> result = " 생성됨
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name).getResultList();
        return result.stream().findAny();

    }

//    in-line 단축키 : Ctrl + Atl + n
    @Override
    public List<Member> findAll() {
        // JPQL 이라는 쿼리 언어. 객체 지향 쿼리 - Entity 를 대상으로 쿼리를 날려줌.;
        // Member 객체 자체를 조회한다.
        return em.createQuery("select m from Member m", Member.class).getResultList();
//        List<Member> result = em.createQuery("select m from Member m", Member.class).getResultList();
//        return result;
    }
}
