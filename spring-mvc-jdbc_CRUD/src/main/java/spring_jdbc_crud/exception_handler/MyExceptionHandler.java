package spring_jdbc_crud.exception_handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import spring_jdbc_crud.controller.DataAlreadyExistInDatabaseException;

@ControllerAdvice
public class MyExceptionHandler {

	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(RuntimeException.class)
	public String handleConflict(HttpServletRequest req,Exception e, Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}
	
	@ResponseStatus(code = HttpStatus.CONFLICT)
	@ExceptionHandler(DataAlreadyExistInDatabaseException.class)
	public String handleConflict2(HttpServletRequest req,Exception e, Model model) {
		model.addAttribute("message",e.getMessage());
		return "error";
	}

}
