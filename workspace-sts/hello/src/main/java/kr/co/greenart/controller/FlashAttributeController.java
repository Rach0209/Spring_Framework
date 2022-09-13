package kr.co.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/flash")
public class FlashAttributeController {
	
	@GetMapping("/1")
	public String forward(Model model) {
		model.addAttribute("forwardtest", "포워드 테스트");
		return "flashview"; // 리던 타입이 String이다 > view로 forward된다!
	}
	
	@GetMapping("/2")
	public String view() {
		return "flashview";
	}
	
//	view에 심어놨던 어트리뷰트값이 나오지 않고, 대신 URL에 표기가 된다.
//	쓰려고 만든 값으로 판단하여 알아서 파라미터 값으로 만들어준다.
//	사용하려면 parameter객체에서 꺼내쓰면 된다.
	@GetMapping("/3")
	public String redirect(Model model) {
		model.addAttribute("redirecttest", "리다이렉트 테스트");
		return "redirect:2";
	}
	
	@GetMapping("/4")
	public String flash(RedirectAttributes ra) {
//		리다이렉트를 딱 한번만 쓸 때, 플래시 어트리뷰트로 사용( 4를 요청할때마다 어트리뷰트가 심어지고, 그때 한 번만 사용하고 사라진다.)
//		세션처럼 유지할 수 있는 어트리뷰트를 넣어주었다가, 한 번 사용후에 spring이 알아서 삭제시켜준다.
		ra.addFlashAttribute("redirecttest", "플래시어트리뷰트의 모델값");
		return "redirect:2";
	}
}