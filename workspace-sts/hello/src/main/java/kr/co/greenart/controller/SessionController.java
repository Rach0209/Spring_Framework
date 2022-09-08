package kr.co.greenart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

// testModelSession.java를 참고하자.
// SessionController에서 설정한 값은 SessionController안에서만 유효하고,
// 다른 Controller에서 사용하고자하면 찾을 수 없다. Scope가 특이하다.
// 값이 요청마다 없어지는 것도 아니고, 범위는 req < [] < Session 요정도가 되겠다. 

// 순서;
// localhost:8080/greenart/session/add > /sesion/check 에서 설정한 세션 값 확인
// session/model > sesion/modelcheck 에서 설정한 모델 값 확인


@Controller
@RequestMapping(value = "/session", produces = "text/plain; charset=utf-8")
@SessionAttributes("modelname")
@ResponseBody
public class SessionController {
	@GetMapping("/add")
	public String addSessionValue(HttpSession session) {
		session.setAttribute("myname", "myvalue");
		return "세션에 값 설정하기";
	}
	
	@GetMapping("/check")
	public String getSessionValue(HttpSession session) {
		return (String) session.getAttribute("myname");
	}
	
//	model에 attribute를 담으면 사실 상 request에 attribute에 담았다 뺐다 하는것임.
//	session으로 관리를 원한다면, @SessionAttributes("이름")에 이름을 정해주면, 알아서 session으로 관리해준다.
	@GetMapping("/model")
	public String addModelValue(Model model) {
		model.addAttribute("modelname", "modelvalue");
		return "모델에 값 설정";
	}
	
	@GetMapping("/modelcheck")
	public String getModelValue(Model model) {
		return (String) model.getAttribute("modelname");
	}
	
//	@SessionAttributes("modelname")에서 설정한 값을 지울 때.
	@GetMapping("/status")
	public String complete(SessionStatus status) {
		status.setComplete();
		return "세션 어트리뷰트 삭제되었음";
	}
}
