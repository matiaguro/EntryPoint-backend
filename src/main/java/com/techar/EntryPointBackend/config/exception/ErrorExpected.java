package com.techar.EntryPointBackend.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public class ErrorExpected extends Exception{

    protected String errorMessage;

    protected HttpStatus status;

}
