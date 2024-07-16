package com.techar.EntryPointBackend.ports.input.controller;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.mapper.UserMapper;
import com.techar.EntryPointBackend.core.models.request.UpdateUserRequest;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import com.techar.EntryPointBackend.core.usecase.UserService;
import com.techar.EntryPointBackend.ports.input.api.AdminControllerApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.techar.EntryPointBackend.ports.input.endpoints.AdminEndpoint.ADMIN_URL;
import static com.techar.EntryPointBackend.ports.input.endpoints.AdminEndpoint.ENDPOINT.GET_ALL_USER;
import static com.techar.EntryPointBackend.ports.input.endpoints.AdminEndpoint.ENDPOINT.UPDATE_USER;


@RestController
@RequestMapping(ADMIN_URL)
@RequiredArgsConstructor
public class AdminController implements AdminControllerApi {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping(GET_ALL_USER)
    public ResponseEntity<GenericResponse> getUser() {
        return  GenericResponse.getResponseOk(userMapper.userToUserResponse(userService.getAllUser()));
    }

    @PutMapping(UPDATE_USER+"/{userId}")
    public ResponseEntity<GenericResponse> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest updateUserRequest) throws ErrorExpected {
        return  GenericResponse.getResponseOk(userMapper.userToUserResponse(userService.updateAllUser(userId, updateUserRequest)));
    }


}
