package com.techar.EntryPointBackend.config.exception.handler;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.config.exception.error.ErrorCode;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import com.techar.EntryPointBackend.core.util.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        try {
            response.getWriter().write(getBody());
        } catch (ErrorExpected e) {
            throw new RuntimeException(e);
        }
    }

    private static String getBody() throws ErrorExpected {
        GenericResponse error = new GenericResponse(ErrorCode.BAD_CREDENTIALS.getDefaultMessage(), "");
        return JsonUtils.objectToJson(error);
    }
}
