package com.techar.EntryPointBackend.ports.input.controller;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.models.request.LoginRequest;
import com.techar.EntryPointBackend.core.models.request.RegisterRequest;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import com.techar.EntryPointBackend.core.usecase.AuthenticationService;
import com.techar.EntryPointBackend.ports.input.api.AuthControllerApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.techar.EntryPointBackend.ports.input.endpoints.AuthEndpoints.AUTH_URL;
import static com.techar.EntryPointBackend.ports.input.endpoints.AuthEndpoints.ENDPOINT.*;


@RestController
@RequestMapping(AUTH_URL)
@RequiredArgsConstructor
public class AuthController implements AuthControllerApi {

    private final AuthenticationService authenticationService;

    @Override
    @PostMapping(LOGIN)
    public ResponseEntity<GenericResponse> login(LoginRequest loginRequest) throws ErrorExpected {
        return  GenericResponse.getResponseOk(authenticationService.login(loginRequest));
    }

    @Override
    @PostMapping(REGISTER_EMPELADO)
    public ResponseEntity<GenericResponse> registerEmpleado(RegisterRequest registerRequest) throws ErrorExpected {
        authenticationService.registerEmpleado(registerRequest);
        return  GenericResponse.getResponseOk("");
    }

    @Override
    @PostMapping(FORGOTTEN_PASSWORD)
    public ResponseEntity<GenericResponse> forgottenPassword() {
        return GenericResponse.getResponseError("Sin implementar", HttpStatus.BAD_REQUEST);
    }

}