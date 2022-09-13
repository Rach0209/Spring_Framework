package kr.co.greenart.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Spring에서 @PropertySource는 properties 값을 꺼내서 사용할 수 있게 해줌
// PropertySource의 value 값은 classpath경로 or 파일의 경로를 적어준다.
@Configuration
@PropertySource("classpath:kr/co/greenart/config/mysql.properties")
//@ComponentScan("kr.co.greenart.model.car")
@EnableTransactionManagement // transaction 관리 설정 등록. + 트랜잭션을 관리할 수 있는 관리자를 Bean으로 등록하기.
public class RootConfig {
//	@PropertySource의 값을 꺼내와서 쓰기위한 @Value value의값은 properties의 이름과 같아야 한다.
	@Value("${jdbc.drivername}")
	private String drivername;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
//	@Autowired
//	private DataSource ds;
	
//	Bean을 만드려면, xml파일이나 @Configuration이 있는 클래스에 Bean을 만들어준다.
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(drivername);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		
		return ds;
	}
	
//	spring jdbc 라이브러리 사용
//	@Autowired 필드 생성후 사용 or 파라미터 부분에 필요한 것을 적고 @Autowired달아주기
	@Bean
	@Autowired
	public JdbcTemplate jdbcTemplate(DataSource ds) {
		return new JdbcTemplate(ds);
//		
	}
	
//	트랜잭션을 관리해주는 클래스를 Bean으로 등록하기
	@Bean
	@Autowired
	public PlatformTransactionManager txManager(DataSource ds) {
		return new DataSourceTransactionManager(ds);
	}
	
	@Bean
	@Autowired
	public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource ds) {
		return new NamedParameterJdbcTemplate(ds);
	}
}
