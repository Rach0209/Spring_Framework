package kr.co.greenart.controller;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestModelSession {
//	모델값을 설정하고, 달라고 했는데 값이 나오지 않는다.
//	하지만 modelcheck에서 확인하면 값이 나옴.!
//	결국 SessionController에서 설정한 값은 SessionController안에서만 유효하고,
//	다른 Controller에서 사용하고자하면 찾을 수 없다. Scope가 특이하다.
//	값이 요청마다 없어지는 것도 아니고, 범위는 req < [] < Session 요정도가 되겠다.
	
//	순서;
//	session/model 에서 모델 값 설정 > /testModel 로 확인하지만 표시되지 않음.
	@GetMapping("/testModel")
	public @ResponseBody String testModel(Model model) {
		return new HashMap<>(model.asMap()).toString();
	}
}
