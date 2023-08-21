package com.masai.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> exceptionHandler(Exception se, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(se.getMessage());
		ed.setDesc(req.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TaskException.class)
	public ResponseEntity<ErrorDetails> taskNotFoundHandler(TaskException ts, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(ts.getMessage());
		ed.setDesc(req.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ErrorDetails> noHandlerFoundExceptionHandler(NoHandlerFoundException se, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(se.getMessage());
		ed.setDesc(req.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetails> methodHandler(MethodArgumentNotValidException se, WebRequest req){
		ErrorDetails ed = new ErrorDetails();
		ed.setMessage(se.getMessage());
		ed.setDesc(req.getDescription(false));
		return new ResponseEntity<>(ed, HttpStatus.BAD_REQUEST);
	}
}
