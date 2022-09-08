package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CarService {
	@Autowired
	private CarRepository repo;
//	목록 받아오는 서비스들 => CarController에서 사용
	public List<Car> list() {
		return repo.getAll();
	}
	
	public Car getById(int id) {
		return repo.getById(id);
	}
	
//	추가
	public int add(Car car) {
		return repo.add(car);
	}
	
//	수정
	public int update(Car car) {
		return repo.update(car);
	}
	
	// 자동차 목록을 전달받아 추가.. (여러개를 한번에)
	@Transactional // 트랜잭션이 필요하다. 트랜잭션은 런타임에러(RuntimeException)와 에러(Error)만 롤백해준다.
//	기본적인 Exception은 checked, 상속받는 RuntimeException은 unchecked
	public int[] bulkInsert(List<Car> list) {
//		int[] results = new int[list.size()];
//		for (int i = 0; i < list.size(); i++) {
//			results[i] = repo.add(list.get(i));
//		}
		int[] results = repo.batchInsert(list);
		return results; 
	}
	
	@Transactional
	public int delete(int id) {
		return repo.delete(id);
	}
}
