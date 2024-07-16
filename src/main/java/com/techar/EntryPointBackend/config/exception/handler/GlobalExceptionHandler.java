package com.techar.EntryPointBackend.config.exception.handler;

import com.techar.EntryPointBackend.config.exception.ConflictException;
import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.config.exception.error.ErrorCode;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;



@ControllerAdvice
public class GlobalExceptionHandler {
    protected Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    private ResponseEntity<GenericResponse> handleCommunicationException(HttpMessageNotReadableException ex) {
        logger.error(ex.getMessage());
        GenericResponse response = new GenericResponse("Error en la request", "");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({ConflictException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    private ResponseEntity<GenericResponse> handleErrorConflictException(ConflictException ex) {
        logger.error(ex.getConflictMessage());
        GenericResponse response = new GenericResponse(ex.getConflictMessage(), "");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    private ResponseEntity<GenericResponse> handleErrorArgumentConstrain(MethodArgumentNotValidException ex) {
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            logger.error(fieldError.getDefaultMessage());
            GenericResponse response = new GenericResponse(fieldError.getDefaultMessage(), "");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
        return null;
    }

    @ExceptionHandler({ErrorExpected.class,})
    @ResponseBody
    private ResponseEntity<GenericResponse> handleErrorArgumentConstrain(ErrorExpected ex) {
        logger.error(ex.getMessage());
        GenericResponse response = new GenericResponse(ex.getErrorMessage(), "");
        return ResponseEntity.status(ex.getStatus()).body(response);
    }

    @ExceptionHandler({Exception.class, Error.class})
    @ResponseBody
    private ResponseEntity<GenericResponse> handleException(Exception ex) {
        ex.printStackTrace();
        return GenericResponse.getResponseError("Error en logica de negocio, contate con su proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({BadCredentialsException.class})
    @ResponseBody
    private ResponseEntity<GenericResponse> handleException(BadCredentialsException ex) {
        return GenericResponse.getResponseError(ErrorCode.BAD_CREDENTIALS.getDefaultMessage(), HttpStatus.UNAUTHORIZED);
    }


}




