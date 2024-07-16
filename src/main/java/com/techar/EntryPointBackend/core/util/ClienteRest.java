package com.techar.EntryPointBackend.core.util;


import com.techar.EntryPointBackend.config.exception.CommunicationException;
import org.springframework.http.HttpStatus;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteRest {
    private static final HttpClient httpClient = HttpClient.newHttpClient();

    public static HttpResponse<String> GET(String url) throws CommunicationException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new CommunicationException("Error en la comunicacion, solicitar ayuda a soporte.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static HttpResponse<String> POST(String url, Object bodyBean) throws CommunicationException {
        try {
            String body = JsonUtils.objectToJson(bodyBean);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new CommunicationException("Error en la comunicacion, solicitar ayuda a soporte." , HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    public static HttpResponse<String> PUT(String url, Object bodyBean) throws CommunicationException {
        try {
            String body = JsonUtils.objectToJson(bodyBean);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .PUT(HttpRequest.BodyPublishers.ofString(body))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new CommunicationException("Error en la comunicacion, solicitar ayuda a soporte." , HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    public static HttpResponse<String> DELETE(String url) throws CommunicationException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .DELETE()
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new CommunicationException("Error en la comunicacion, solicitar ayuda a soporte." , HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    public static  HttpResponse<String> PATCH(String url, Object bodyBean) throws CommunicationException {
        try {
            String body = JsonUtils.objectToJson(bodyBean);
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .header("Content-Type", "application/json")
                    .method("PATCH", HttpRequest.BodyPublishers.ofString(body))
                    .build();

            return httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        } catch (Exception e) {
            throw new CommunicationException("Error en la comunicacion, solicitar ayuda a soporte." , HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

}

