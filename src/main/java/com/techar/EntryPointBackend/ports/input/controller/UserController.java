package com.techar.EntryPointBackend.ports.input.controller;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.mapper.UserMapper;
import com.techar.EntryPointBackend.core.models.request.UpdateUserRequest;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import com.techar.EntryPointBackend.core.models.validuser.ValidUser;
import com.techar.EntryPointBackend.core.usecase.UserService;
import com.techar.EntryPointBackend.ports.input.api.UserControllerApi;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.techar.EntryPointBackend.ports.input.endpoints.UserEndpoint.ENDPOINT.*;
import static com.techar.EntryPointBackend.ports.input.endpoints.UserEndpoint.USER_URL;


@RestController
@RequestMapping(USER_URL)
@RequiredArgsConstructor
public class UserController implements UserControllerApi {

    private final UserService userService;

    private final UserMapper userMapper;

    @GetMapping(GET_USER+"/{userId}")
    public ResponseEntity<GenericResponse> getUser(@PathVariable  String userId) throws ErrorExpected {
        return  GenericResponse.getResponseOk(userMapper.userToUserResponse(userService.getUser(userId)));
    }

    @PostMapping(LOG_IN_TIME+"/{userId}")
    public ResponseEntity<GenericResponse> logInTime(@PathVariable  String userId) throws ErrorExpected {
        userService.logInTime(userId);
        return  GenericResponse.getResponseOk("");
    }

    @PutMapping(UPDATE_USER+"/{userId}")
    public ResponseEntity<GenericResponse> updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequest updateUserRequest) throws ErrorExpected {
        return  GenericResponse.getResponseOk(userMapper.userToUserResponse(userService.updateUser(userId, updateUserRequest)));
    }


}
