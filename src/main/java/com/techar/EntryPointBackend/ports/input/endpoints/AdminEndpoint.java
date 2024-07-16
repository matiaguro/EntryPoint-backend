package com.techar.EntryPointBackend.ports.input.endpoints;

public interface AdminEndpoint {

    String ADMIN_URL = "/admin";

    interface ENDPOINT {

        String GET_ALL_USER = "/getAllUsers";
        String UPDATE_USER = "/updateUser";
        String UPDATE_PASSWORD = "/updatePassword";

    }

}
