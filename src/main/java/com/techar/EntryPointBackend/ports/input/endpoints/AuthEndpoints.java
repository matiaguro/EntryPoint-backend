package com.techar.EntryPointBackend.ports.input.endpoints;

public interface AuthEndpoints {
    String AUTH_URL = "/auth";

    interface ENDPOINT {

        String LOGIN = "/login";
        String REGISTER_EMPELADO = "/registerEmpleado";
        String REGISTER_CLIENT = "/registerClient";
        String REFRESH_TOKEN = "/refreshToken";
        String FORGOTTEN_PASSWORD = "/forgottenPassword";

    }

}
