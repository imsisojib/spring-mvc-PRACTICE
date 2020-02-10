package spring_jdbc_crud.controller;

public class DataAlreadyExistInDatabaseException extends RuntimeException {
	public DataAlreadyExistInDatabaseException() {
		super();

	};
	
	public DataAlreadyExistInDatabaseException(String message, Throwable cause) {
		super(message,cause);
	};
	
	public DataAlreadyExistInDatabaseException(String message) {
		super(message);
	};
	
}
