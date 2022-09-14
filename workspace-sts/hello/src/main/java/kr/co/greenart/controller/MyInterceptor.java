package kr.co.greenart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

// HandlerInterceptorAdapter 클래스를 상속하거나, HandlerInterceptor 인터페이스를 구현하면 된다.
@Component
public class MyInterceptor extends HandlerInterceptorAdapter {
	// WebConfig에 추가 입력 필요.
	
	private static final Logger logger = LoggerFactory.getLogger(MyInterceptor.class);
	// Controller가 사용자 요청을 처리하기 전.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("--- 1. 핸들러가 처리 전 ---");
		HttpSession session = request.getSession(false);
		if (session != null) {
			session.removeAttribute("burn");
		}
		request.setAttribute("burn", "새로운 어트리뷰트 생성");
		//return 값을 false로 주면, 흐름이 끊김.
		
		return true;
	}
	
	// 사용자 요청을 처리한 후이지만, view가 만들어지기 전.
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.info("--- 3. 핸들러 처리 후, 뷰 생성 전 ---");
		// 로거가 찍힌 후, view가 만들어진다.
		
		String value = (String) request.getAttribute("burn");
		value += ". 핸들러 처리 후 어트리뷰트 변경";
		request.setAttribute("burn", value);
	}
	
	// view가 만들어진 후
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.info("--- 5. 뷰 생성 후 ---");
		
		HttpSession session = request.getSession(false);
		session.removeAttribute("burn");
	}
	
}
