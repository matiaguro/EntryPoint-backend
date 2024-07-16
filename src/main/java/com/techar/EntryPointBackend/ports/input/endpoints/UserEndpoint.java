package com.techar.EntryPointBackend.ports.input.endpoints;

public interface UserEndpoint {

    String USER_URL = "/user";

    interface ENDPOINT {

        String GET_USER = "/getUser";
        String LOG_IN_TIME = "/logInTime";
        String UPDATE_USER = "/updateUser";

    }

}
