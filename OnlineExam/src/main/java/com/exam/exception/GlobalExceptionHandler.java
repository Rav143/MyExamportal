package com.exam.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=UserNotFoundException.class)
	public ResponseEntity<String> userNotFoundExceptionHandler(UserNotFoundException ex){
		
		return new ResponseEntity<String>("User Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserExistsException.class)
	public ResponseEntity<String> userExistsExceptionHandler(UserExistsException ex){
		
		return new ResponseEntity<>("User Already Exists",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=EmailIdExistsException.class)
	public ResponseEntity<String> emailIdExistsExceptionHandler(EmailIdExistsException ex){
		
		return new ResponseEntity<>("EmailId Already Exists",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=PasswordNotSameException.class)
	public ResponseEntity<String> passwordNotSameExceptionHandler(PasswordNotSameException ex){
		
		return new ResponseEntity<>("Password and Confirm Password should be same",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=AdminNotFoundException.class)
	public ResponseEntity<String> adminNotFoundExceptionHandler(AdminNotFoundException ex){
		
		return new ResponseEntity<String>("Admin Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=AdminExistsException.class)
	public ResponseEntity<String> adminExistsExceptionHandler(AdminExistsException ex){
		
		return new ResponseEntity<>("Admin Already Exists",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=ResultNotFoundException.class)
	public ResponseEntity<String> resultNotFoundExceptionHandler(ResultNotFoundException ex){
		
		return new ResponseEntity<String>("Result Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=QuestionNotFoundException.class)
	public ResponseEntity<String> questionNotFoundExceptionHandler(QuestionNotFoundException ex){
		
		return new ResponseEntity<String>("Question Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=TestNotFoundException.class)
	public ResponseEntity<String> testNotFoundExceptionHandler(TestNotFoundException ex){
		
		return new ResponseEntity<String>("Test Not Found",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value=UserHistoryNotFoundException.class)
	public ResponseEntity<String> userHistoryNotFoundExceptionHandler(UserHistoryNotFoundException ex) {
		return new ResponseEntity<String>("User History Not Found",HttpStatus.NOT_FOUND);
	}
	

}