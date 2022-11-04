package hello.hellospring.domain;

import javax.persistence.*;

// JPA - Java 진영의 표준 인터페이스; 구현은 여러 업체들이 함.
// JPA = 객체와 ORM 의 기술
@Entity
public class Member {
    // DB가 자동으로 값을 설정 해주는 것 : IDENTITY
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
