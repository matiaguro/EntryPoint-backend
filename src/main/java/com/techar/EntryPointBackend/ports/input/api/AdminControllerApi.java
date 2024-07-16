package com.techar.EntryPointBackend.ports.input.api;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.models.request.UpdateUserRequest;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AdminControllerApi {

    ResponseEntity<GenericResponse> getUser();

    ResponseEntity<GenericResponse> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest updateUserRequest) throws ErrorExpected;

}
