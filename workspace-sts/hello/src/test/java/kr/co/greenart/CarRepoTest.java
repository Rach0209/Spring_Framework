package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { kr.co.greenart.config.RootConfig.class })
public class CarRepoTest {
	@Autowired
	private CarRepository repository;
	
	@Test
	public void initTest() {
		assertNotNull(repository);
	}
	
//	JUnit 어노테이션 중. BeforeClass => 실행 환경 만들기!
//	JUnit의 메소드 들이 실행되기 전에 제일 먼저 실행되는 것. 
	@BeforeClass
	public static void addTestData() {
//		테스트 클래스 수행전에 실행됩니다~ 스태틱하게 선언 필수.
		
//		Random r = new Random();
////		id값은 repository의 add메소드에서 사용하지 않아서 Car(id, model, price) 중복해도됨; db에서만 id값이 pk값.
//		repository.add(new Car(0, "테스트 자료" + r.nextInt(10000), r.nextInt(10000)));
//		repository.add(new Car(0, "테스트 자료" + r.nextInt(10000), r.nextInt(10000)));
//		repository.add(new Car(0, "테스트 자료" + r.nextInt(10000), r.nextInt(10000)));
	}
	
	
	@Test
	public void create() {
		Random r = new Random();
		Car car = new Car();
		car.setModel("새 모델" + r.nextInt(10000));
		car.setPrice(1000);
		
		int result = repository.add(car);
		assertEquals(1, result);
	}
	
	@Test
	public void read() {
		List<Car> list = repository.getAll();
		
		assertNotNull(list);
	}
	
	@Test
	public void update() {
		int result = repository.update(new Car(1, "변경", 300));
		
		assertEquals(1, result);
	}
}
