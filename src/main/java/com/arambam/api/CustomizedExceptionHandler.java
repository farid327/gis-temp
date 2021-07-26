package com.arambam.api;

import com.arambam.dto.GeneralResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomizedExceptionHandler {

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<GeneralResponse> handleException(Exception exception) {
		return ResponseEntity.unprocessableEntity()
				.body(new GeneralResponse(false, exception.getMessage()));
	}
}
