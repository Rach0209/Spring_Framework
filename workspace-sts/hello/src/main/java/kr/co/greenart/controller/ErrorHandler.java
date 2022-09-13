package kr.co.greenart.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 똑같은 컴포넌트 이다.
// 주로 컨트롤러 영역에서 예외를 핸들링하거나, InitBinder(객체나 유효성 검사 등 미리 설정하는 작업), modelAttribute설정등
// 컨트롤러 전역에서 일어날 수 있는 일에 대해 미리 작성해 놓을 수 있는 것.
// 특정 핸들러에서만 적용되게 할 때 >>> annotations값 사용
// @ControllerAdvice(assignableTypes = MyController.class) >> 클래스 타입에 대해서만 동작
// basePackages 는 패키지 주소를 적어주면, 패키지 안에서 동작하는 컨트롤러
@ControllerAdvice
public class ErrorHandler {
	// 예외를 다룰 수 있는 핸들러를 작성가능.
	@ExceptionHandler(value = NullPointerException.class)
	public String nullExcep(Model model, NullPointerException ex) {
		model.addAttribute("error", "서버에서 오류가 발생했습니다. ㅋㅋ..ㅎㅎ...ㅈㅅ!!" + ex.getMessage());
		return "errorpage";
	}
}
