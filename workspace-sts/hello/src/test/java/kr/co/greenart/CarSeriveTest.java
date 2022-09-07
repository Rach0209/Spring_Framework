package kr.co.greenart;

import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.config.RootConfig;
import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class CarSeriveTest {
//	transaction 테스트.
	@Autowired
	private CarService service;
	
//	expected => 기대하는 예외에 대한 값 적어주기
	@Test(expected = DataAccessException.class)
	public void bulkInsert() {
		List<Car> list = Arrays.asList(new Car(0, "AAA", 100)
				, new Car(0, "BBB", 100)
				, new Car(0, "CCC", 100)
				, new Car(0, "CCC", 100)); // 'model' 유니크 조약위반. 에러발생~
		
		int[] result = service.bulkInsert(list);
		assertNull(result);
	}
}
