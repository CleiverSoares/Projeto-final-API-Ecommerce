package org.serratec.backend.projetoFinal.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ErroResposta responseError = new ErroResposta();
		responseError.setDataHora(LocalDateTime.now());
		responseError.setErros(new ArrayList<>());
		responseError.setStatus(status.value());
		responseError.setMensagem("Existem campos inválidos. Confira o preenchimento.");

		for (FieldError fieldError : ex.getFieldErrors()) {
			responseError.getErros().add(new CamposComErros(fieldError.getField(), fieldError.getDefaultMessage()));
		}
		return super.handleExceptionInternal(ex, responseError, headers, status, request);
	}
}
