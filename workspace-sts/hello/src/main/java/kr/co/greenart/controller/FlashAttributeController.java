package kr.co.greenart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}