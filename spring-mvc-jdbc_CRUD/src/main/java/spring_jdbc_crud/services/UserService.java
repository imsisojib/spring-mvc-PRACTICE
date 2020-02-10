package spring_jdbc_crud.services;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import spring_jdbc_crud.controller.DataAlreadyExistInDatabaseException;
import spring_jdbc_crud.exception_handler.MyExceptionHandler;
import spring_jdbc_crud.model.User;

@Service
public class UserService {
	private final String TABLE_NAME = "jdbc_crud";
	private final JdbcTemplate jdbcTemplate;
	
	public UserService(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		String createTable = "create table if not exists "+TABLE_NAME+"("+
		"user_mobile varchar(11) not_null primary_key,user_name varchar(100),"
		+ "user_address varchar(100)"+");";
		this.jdbcTemplate.execute(createTable);
	}
	
	
	public void addUser(User user) {
		checkUserByMobileNumber(user.getUserMobileNumber());
		var insertQuery = "insert into "+TABLE_NAME+" values(?,?,?);";
		int resultSet = jdbcTemplate.update(insertQuery,user.getUserMobileNumber(),
				user.getUserName(),user.getUserAddress());
		if(resultSet<1) {
			throw new RuntimeException("Insert into "+TABLE_NAME+" failed");
		}
	}


	private void checkUserByMobileNumber(String userMobileNumber) {
		var checkUserByMobileNumberQuery = "select count(*) as count from "+
				TABLE_NAME+" user where user.user_mobile=?;";
		var map = jdbcTemplate.queryForMap(checkUserByMobileNumberQuery,userMobileNumber);
		if(Integer.parseInt(map.get("count").toString())>0) {
			throw new DataAlreadyExistInDatabaseException("User already Exist in the list");
		}
		
	}
}
