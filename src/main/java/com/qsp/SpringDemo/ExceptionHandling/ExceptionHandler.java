package com.qsp.SpringDemo.ExceptionHandling;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.SpringDemo.dto.Author;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> entity(IdNotFoundException i) {

		return new ResponseEntity<Object>(i.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> entity(MethodArgumentNotValidException m) {
		Map<String, String> map = new HashMap<>();
		m.getBindingResult().getFieldErrors().forEach((errors) -> {
			map.put(errors.getField(), errors.getDefaultMessage());
		});
		return map;
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(IdAlreadyPresentException.class)
	public ResponseEntity<?>entity(IdAlreadyPresentException i)
	{
		return new ResponseEntity<>(i.getMessage(),HttpStatus.BAD_REQUEST);
	}
}
