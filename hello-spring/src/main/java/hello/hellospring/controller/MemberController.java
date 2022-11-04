package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
        System.out.println("memberService= " + memberService.getClass());
    }
    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
