package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

// postman으로 테스트하면 간편하다!

@Controller
@RequestMapping("/car")
@ResponseBody
public class CarController {
	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService service;
	
//	@ResponseBody return값의 해당 문자열이 응답으로 바디로 날아간다!
//	ResponseEntity<String> view()
//	return ResponseEntity 어쩌구하면 응답이 바디로 날아간다!
	
//	Spring에 com.fasterxml.jackson.core(json)의존성 추가해주면 알아서 Json 형태로 만들어 준다.
//	list만 호출하면 됨.toString() xx
	@GetMapping
	public @ResponseBody List<Car> view() {
		return service.list();
	}
	
//	/car + /세부경로 형태로 들어간다.
//	{id} 경로를 변수처럼 사용하는 방법. 중괄호! @PathVariable
	@GetMapping("/{id}")
	public @ResponseBody Car carById(@PathVariable int id) {
		return service.getById(id);
	}

//	주소와 웹 바디로 api를 만들 수 있다.
//	소통 방법을 json으로 한 것.
	
//	요청 바디에 자동차 정보가 들어오기 때문에 @RequestBody를 적어줘야 받아옴
	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car) {
		logger.info(car.toString());
		service.add(car);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }"); 
	}
	
//	http 요청에는 get, post 말고도 다양한 방법들이 있는데 그중 put을 사용해보기.
	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car) {
		service.update(car);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
	
//	delete 방식.
	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
}
