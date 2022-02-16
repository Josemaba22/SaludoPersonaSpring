package com.neoris.saludo.exception;


import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class GlobalExceptionHandler {

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<ErrorDetails> handleTypeAlredyExistException
	(SQLIntegrityConstraintViolationException ex, WebRequest webRequest){
		ErrorDetails errorDetails = new ErrorDetails("900", "Tipo de saludo existente");
		webRequest.getDescription(false);
		return new ResponseEntity<ErrorDetails>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
