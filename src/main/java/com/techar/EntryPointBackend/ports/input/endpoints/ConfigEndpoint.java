package com.techar.EntryPointBackend.ports.input.endpoints;

public interface ConfigEndpoint {

    String CONFIG_URL = "/config";

    interface ENDPOINT {

        String GET_ALL_CONFIG = "/getAllConfig";

        String UPDATE_CONFIG = "/updateConfig";

    }

}
