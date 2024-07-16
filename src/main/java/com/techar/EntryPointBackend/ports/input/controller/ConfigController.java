package com.techar.EntryPointBackend.ports.input.controller;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import com.techar.EntryPointBackend.core.usecase.ConfigService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.techar.EntryPointBackend.ports.input.endpoints.ConfigEndpoint.CONFIG_URL;
import static com.techar.EntryPointBackend.ports.input.endpoints.ConfigEndpoint.ENDPOINT.GET_ALL_CONFIG;
import static com.techar.EntryPointBackend.ports.input.endpoints.ConfigEndpoint.ENDPOINT.UPDATE_CONFIG;


@RestController
@RequestMapping(CONFIG_URL)
@RequiredArgsConstructor
public class ConfigController{

    private final ConfigService configService;


    @GetMapping(GET_ALL_CONFIG)
    public ResponseEntity<GenericResponse> getAllConfig() {
        return  GenericResponse.getResponseOk(configService.getAllConfig());
    }

    @PostMapping(UPDATE_CONFIG)
    public ResponseEntity<GenericResponse> upDateConfig() {
        return  GenericResponse.getResponseOk(configService.upDateConfig());
    }



}
