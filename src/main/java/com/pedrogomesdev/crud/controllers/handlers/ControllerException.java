package com.pedrogomesdev.crud.controllers.handlers;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.pedrogomesdev.crud.dto.CustomError;
import com.pedrogomesdev.crud.dto.ValidationErrorDTO;
import com.pedrogomesdev.crud.services.expections.NotFoundException;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ControllerException {

	@ExceptionHandler(NotFoundException.class)
	public  ResponseEntity<CustomError> notFound(NotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError error = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public  ResponseEntity<CustomError> methodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		ValidationErrorDTO error = new ValidationErrorDTO(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI());
		for (FieldError f : e.getBindingResult().getFieldErrors()) {
			error.addError(f.getField(), f.getDefaultMessage());
        }
		return ResponseEntity.status(status).body(error);
	}
	
	@ExceptionHandler(EntityNotFoundException.class)
	public  ResponseEntity<CustomError> entityNotFoundException(EntityNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		CustomError error = new CustomError(Instant.now(), status.value(), "Cliente Inexistente", request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}
	
}
