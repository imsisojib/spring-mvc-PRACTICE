package spring_jdbc_crud.initialization;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import spring_jdbc_crud.exception_handler.MyExceptionHandler;
import spring_jdbc_crud.services.UserService;


@Configuration
public class MyRootConfig {
	//creating DataSource
	public DataSource dataSource() {
		var database = new DriverManagerDataSource();
		database.setDriverClassName("com.mysql.cj.jdbc.Driver");
		database.setUrl("jdbc:mysql://localhost:3306/SPRING_PRACTICE?createDatabaseIfNotExist=true");
		database.setUsername("root");
		database.setPassword("");
		
		return database;
	}
	
	@Bean
	public JdbcTemplate jdbcTemplate() {
		return new JdbcTemplate(dataSource());
	}
	
	@Bean
	public UserService userService() {
		return new UserService(jdbcTemplate());
	}
	
	@Bean
	public MyExceptionHandler myExceptionHandler() {
		return new MyExceptionHandler();
	}
	
}
