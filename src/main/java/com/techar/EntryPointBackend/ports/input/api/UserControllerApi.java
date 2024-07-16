package com.techar.EntryPointBackend.ports.input.api;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface UserControllerApi {

    public ResponseEntity<GenericResponse> getUser(@PathVariable String userName) throws ErrorExpected;

}
