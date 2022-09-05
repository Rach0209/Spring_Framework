package kr.co.greenart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

// RootConfig클래스에 dataSource를 Bean으로 설정해 놓았다.
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { kr.co.greenart.config.RootConfig.class } )
public class DataSourceTest {
	@Autowired
	private DataSource ds;
	
//	Junit 라이브러리 버전이 낮아서, 오류가 났었음. pom.xml으로 가서 4.7 => 4.13.2로 변경
	@Test
	public void testDS() {
		assertNotNull(ds);
	}
	
//	Spring에서 jdbc 드라이버를 위한 라이브러리를 제공한다. mvnrepository => spring jdbc;
//	RootConfig 클래스를 들여다 보기.
	
	@Test
	public void testConnection() throws SQLException {
		try (Connection conn = ds.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT 1")) {
			rs.next();
			int result = rs.getInt(1);
			
			assertEquals(1, result);
		}
	}
}
