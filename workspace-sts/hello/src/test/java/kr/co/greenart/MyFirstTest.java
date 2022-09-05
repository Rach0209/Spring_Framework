package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

import kr.co.greenart.model.User;

public class MyFirstTest {
// 배포할 때 포함되지 않는, 테스트만을 위한 클래스.
// 프로그램의 테스트를 JUnit을 통해 한다.
	@Test
	public void test() {
//		무조건 실패를 하는 메소드 fail
//		fail("Not yet implemented");
		int a = 10;
		int b = 20;
		
		int sum = a + b;
//		기대값과 실제값이 나옴.
//		같으면 통과, 같지 않으면 실패
		assertEquals(30, sum);
	}
	
	@Test
	public void test2() {
		String abc = "abc";
		String abc2 = abc;
		
//		객체 끼리, 참조가 같으면 통과.
		assertSame(abc2, abc);
	}

	@Test
	public void test3() {
		User u = new User();
		
		assertNotNull(u);
	}
}
