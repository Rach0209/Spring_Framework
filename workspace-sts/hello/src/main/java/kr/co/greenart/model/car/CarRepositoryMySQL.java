package kr.co.greenart.model.car;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
//@Primary primary가 두개가 되어서, CarRepositoryNamed에서도 @Primary사용했는데 에러낫엇음.
public class CarRepositoryMySQL implements CarRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	private CarRowMapper mapper = new CarRowMapper();
	
//	RowMapper를 간단히 하기 위해, RootConfig에서 NamedParameterJdbcTemplate를 Bean 추가해줌.<<<< 확인하세요
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

	@Override
	public int[] batchInsert(List<Car> list) {
		return jdbcTemplate.batchUpdate("INSERT INTO cars (model, price) VALUES (?, ?)"
				, new BatchPreparedStatementSetter() {
					@Override
					public void setValues(PreparedStatement ps, int i) throws SQLException {
						Car car = list.get(i);
						ps.setString(1, car.getModel());
						ps.setInt(2, car.getPrice());
					}
					
					@Override
					public int getBatchSize() {
						// BatchSize -> 몇번 할 것인지 정해주기.
						// 여기선 list의 사이즈만큼만 행동할 거임.
						return list.size();
					}
				});
	}
	
	

}
