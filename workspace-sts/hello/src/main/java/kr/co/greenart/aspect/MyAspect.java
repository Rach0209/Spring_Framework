package kr.co.greenart.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyAspect {
	private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);
	// 포인트컷 작성 문법 : 접근제한자, 리턴타입, 패키지.클래스.메소드(파라미터) 형태
	// 밑에와 똑같은 기능.
	// 메소드 선언만 해줌.
	// 원하는 곳 : joinpoint, 그것을 찾아주는 것 : pointcut.
	// 메소드가 실행시에 행동하는 것.
	@Pointcut("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
	public void print() {
	}
	
	// Repository로 설정된 것들? 불러오는듯
	@Pointcut("within(@org.springframework.stereotype.Repository *)")
	public void repository() {
	}
	
	// 실행 전, 후로 하고 싶다.!
	@Around("repository()")
	public Object loggingTime(ProceedingJoinPoint jp) throws Throwable {
		// 실행 전 - @Before 와 같음
		long start = System.nanoTime();
		logger.info("시작 시간: " + start);
		
		Object proceed = jp.proceed(); // 실제 실행되는 메소드 // 이 메소드 위에 적으면 실행 전 밑에는 실행 후.
		
		// 실행 후 - @After 와 같음
		long end = System.nanoTime();
		logger.info("종료 시간: " + end);
		
		logger.info(jp.getSignature().getName() + " 메소드의 실행시간 : " + (end - start));
		return proceed;
	}
	
	// Pointcut 선언 전
	@Before("print()")
	public void printBefore() {
		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
	}
	
	// Pointcut 선언 후
	@After("print()")
	public void printAfter() {
		logger.info("-- 파일 목록을 불러온 후에 실행됩니다. --");
	}
	
	//	FileDBRepository.java에서 목록 불러오기 관련 전, 후로 작동하게 하기
	// 접근제한자, 리턴타입, 패키지.클래스.메소드(파라미터) 형태
	// 메소드 실행 시(execution(해당 메소드)) // (..)은 파라미터 전달을 받는 다는 뜻. 파라미터 값이 없을 때도 상관없다.
	// 패키지 앞에 접근 제한자와 리턴타입을 적어주거나, *를 해주면 됨.
//	@Before("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printBefore() {
//		logger.info("-- 파일 목록을 불러 오기 전에 실행됩니다. --");
//	}
//	// 실행 후 작동하는 After
//	@After("execution(* kr.co.greenart.model.file.FileDBRepository.getAllnames(..))")
//	public void printAfter() {
//		logger.info("-- 파일 목록을 불러온 후에 실행됩니다. --");
//	}
	
}
