package com.techar.EntryPointBackend.config.exception.handler;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.config.exception.error.ErrorCode;
import com.techar.EntryPointBackend.core.models.response.GenericResponse;
import com.techar.EntryPointBackend.core.util.JsonUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        try {
            response.getWriter().write(getBody());
        } catch (ErrorExpected ex) {
            throw new RuntimeException(ex);
        }
    }

    private static String getBody() throws ErrorExpected {
        GenericResponse error = new GenericResponse(ErrorCode.ROLE_INVALID.getDefaultMessage(), "");
        return JsonUtils.objectToJson(error);
    }
}
