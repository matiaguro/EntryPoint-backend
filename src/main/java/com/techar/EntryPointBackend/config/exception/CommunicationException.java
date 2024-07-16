package com.techar.EntryPointBackend.config.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommunicationException extends Exception{

    private  String errorMessage;

    private HttpStatus statusCode;



}
