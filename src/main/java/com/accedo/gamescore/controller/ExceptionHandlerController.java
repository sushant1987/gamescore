/**
 * This controller will handle all the exceptions
 */
package com.accedo.gamescore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.accedo.gamescore.exception.UnprocessableEntityException;

/**
 * @author Sushant Kumar Singh
 *
 */
@ControllerAdvice
public class ExceptionHandlerController {

	/**
	 * This method will handle {@link UnprocessableEntityException}
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = UnprocessableEntityException.class)
	@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
	public ResponseEntity<String> unprocessableEntity(UnprocessableEntityException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	/**
	 * This method will handle {@link MethodArgumentNotValidException}
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<String> badRequest(MethodArgumentNotValidException ex) {
		return ResponseEntity.badRequest().body(buildErrorMessage(ex));
	}

	private String buildErrorMessage(MethodArgumentNotValidException ex) {
		StringBuilder sb = new StringBuilder();
		for (FieldError fe : ex.getFieldErrors()) {
			sb.append(fe.getField());
			sb.append(" ");
			sb.append(fe.getDefaultMessage());
		}
		return sb.toString();
	}
}
