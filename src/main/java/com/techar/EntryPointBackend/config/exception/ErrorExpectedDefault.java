package com.techar.EntryPointBackend.config.exception;


import org.springframework.http.HttpStatus;

public class ErrorExpectedDefault extends ErrorExpected {
    public ErrorExpectedDefault() {
        super("Error en logica de negocio, contacte a su proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
