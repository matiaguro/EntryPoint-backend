package com.techar.EntryPointBackend.ports.input.api;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.models.request.LoginRequest;
import com.techar.EntryPointBackend.core.models.request.RegisterRequest;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthControllerApi {

    ResponseEntity<GenericResponse> login(@RequestBody @Valid LoginRequest loginRequest) throws ErrorExpected;

    ResponseEntity<GenericResponse> registerEmpleado(@RequestBody @Valid RegisterRequest registerRequest) throws ErrorExpected;

    public ResponseEntity<GenericResponse> forgottenPassword();

}
