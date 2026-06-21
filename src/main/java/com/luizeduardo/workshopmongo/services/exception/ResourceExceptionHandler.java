package com.luizeduardo.workshopmongo.services.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luizeduardo.workshopmongo.resources.exception.StandardError;

import jakarta.servlet.http.HttpServletRequest;
@ControllerAdvice
public class ResourceExceptionHandler {

	//tratando exceção de nao encontrar id 
	@ExceptionHandler(ObjectNotFoundException.class)//o nome da exceção que será interceptada, esse metodo vai interceptar qualquer exceção do tipo que esta entre () 
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error,e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}

}
