package com.peka.bookstore.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice //ta adnotacja pozwala na wykorzystanie tej obsługi błędu wszystkim innym klasom 
@RestController
public class CustomizedResponseEntityExeptionHandler 
extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions
	(Exception ex, WebRequest request){
		ExceptionResponse exeptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exeptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(BookNotFoundExceptions.class)
	public final ResponseEntity<Object> handleUserNotFoundExceptions
	(Exception ex, WebRequest request){
		ExceptionResponse exeptionResponse = 
				new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		
		return new ResponseEntity<>(exeptionResponse, HttpStatus.NOT_FOUND);
	}
	
	@Override //step 15 metoda która zwraca błąd błędnie podanej zmiennej do requesta
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		ExceptionResponse exeptionResponse = 
				new ExceptionResponse(new Date(), "Validation Failed"//ex.getMessage() zmiana na stałą wartość bo te same wartości pojawiają się w details
						, ex.getBindingResult().toString());
		
		return new ResponseEntity<>(exeptionResponse, HttpStatus.BAD_REQUEST);
	}
}
