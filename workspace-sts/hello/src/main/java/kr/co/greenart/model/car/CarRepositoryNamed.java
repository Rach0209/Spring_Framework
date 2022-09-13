package kr.co.greenart.model.car;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

@Repository // Primary를 쓰거나, Bean이름을 주고, Service객체에서 Qualifier를 사용하여 사용할 이름을 적어주기
@Primary
public class CarRepositoryNamed implements CarRepository {
//	객체의존성을 주입하기위해(configure없이)
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
//	RowMapper자리에 BeanPropertyRowMapper객체를 집어넣는다.
//	클래스에 해당하는 필드 이름이 같다면, 그에 해당하는 getter/setter를 알아서 호출해준다.
	@Override
	public List<Car> getAll() {
		return jdbc.query("SELECT * FROM cars", new BeanPropertyRowMapper<Car>(Car.class));
	}

//	id=? 였던 것을 :id(콜론을사용)로 이름을 준다!
//	이름을 가진 Map을 두번째에 넣어주기.
	@Override
	public Car getById(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
//		map에서 id값을 찾아가서 id를 집어넣음.
		return jdbc.queryForObject("SELECT * FROM cars WHERE id=:id", map, new BeanPropertyRowMapper<Car>(Car.class));
	}

//	BeanPropertySqlParameterSource(car) 파라미터로 받는 객체에 맞는 값을 찾아서 id값을 설정한 곳에 알아서 넣어준다.
//	여기선 :model, :price에 id값을 주었음 ==> ':' 콜론 확인.
	@Override
	public int add(Car car) {
//		Map<String, Object> map = new HashMap<>();
//		map.put("model", car.getModel());
//		map.put("price", car.getPrice());
//		해서 value값을 가져오던것을 줄여줌.
		return jdbc.update("INSERT INTO cars (model, price) VALUES (:model, :price)"
				, new BeanPropertySqlParameterSource(car));
	}

//	SqlParameterSource를 도와주는 SqlParameterSourceUtils.
//	batch는 여러번 작업할 때씀. => 결국 BeanPropertySqlParameterSource가 여러개 있어야함.
//	배열의 형태로 여러개를 한번에 만들어주는 역할.>>>>SqlParameterSourceUtils.createBatch()
	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbc.batchUpdate("INSERT INTO cars (model, price) VALUES (:model, :price)"
				, SqlParameterSourceUtils.createBatch(list));
	}

	@Override
	public int update(Car car) {
		return jdbc.update("UPDATE cars SET model=:model, price=:price WHERE id=:id"
				, new BeanPropertySqlParameterSource(car));
	}

	@Override
	public int delete(int id) {
		MapSqlParameterSource map = new MapSqlParameterSource();
		map.addValue("id", id);
		return jdbc.update("DELETE FROM cars WHERE id=:id", map);
	}
	
}
