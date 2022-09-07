package kr.co.greenart.model.car;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class CarRepositoryMySQL implements CarRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private CarRowMapper mapper = new CarRowMapper();
	
	private class CarRowMapper implements RowMapper<Car> {
		@Override
		public Car mapRow(ResultSet rs, int rowNum) throws SQLException {
			int id = rs.getInt("id");
			String model = rs.getString("model");
			int price = rs.getInt("price");
			
			return new Car(id, model, price);
		}
		
	}
	
	@Override
	public List<Car> getAll() {
		return jdbcTemplate.query("SELECT * FROM cars", mapper);
	}

	@Override
	public Car getById(int id) {
//		queryForObject 순서를 mapper먼저 받게해야 디프리케이트되지않음.
		return jdbcTemplate.queryForObject("SELECT * FROM cars WHERE id=?", mapper, id);
	}

	@Override
	public int add(Car car) {
		return jdbcTemplate.update("INSERT INTO cars (model, price) VALUES (?, ?)"
				, car.getModel(), car.getPrice());
	}

	@Override
	public int update(Car car) {
		return jdbcTemplate.update("UPDATE cars SET model=?, price=? WHERE id=? "
				, car.getModel(), car.getPrice(), car.getId());
	}

	@Override
	public int delete(int id) {
		return jdbcTemplate.update("DELETE FROM cars WHERE id=?", id);
	}
	
	

}
