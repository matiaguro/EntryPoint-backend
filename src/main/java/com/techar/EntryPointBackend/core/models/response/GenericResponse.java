package com.techar.EntryPointBackend.core.models.response;

import com.fasterxml.jackson.core.type.TypeReference;
import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.core.util.JsonUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.http.HttpResponse;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse {

    private String message;
    private Object data;

    public GenericResponse(Object data) {
        this.data = data;
    }


    public static ResponseEntity<GenericResponse> getResponseOk (Object data){
        return  ResponseEntity.ok(new GenericResponse("", data));
    }

    public static ResponseEntity<GenericResponse> getResponseMensagge (String message){
        return  ResponseEntity.ok(new GenericResponse(message, ""));
    }

    public static ResponseEntity<GenericResponse> getResponseError (String mensaje, HttpStatus status){
        return ResponseEntity.status(status).body(new GenericResponse(mensaje, ""));
    }


    public static ResponseEntity<GenericResponse> getResponse (HttpStatus status, Object data){
        return ResponseEntity.status(status).body(new GenericResponse("", data));
    }

    public static GenericResponse getOK (HttpResponse<String> res) throws ErrorExpected {
        GenericResponse response = JsonUtils.jsonToObject(res.body(), GenericResponse.class);
        if (!HttpStatus.OK.equals(HttpStatus.resolve(res.statusCode()))){
            throw new ErrorExpected(response.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    public <T> T getObject(Class<T> arg) throws ErrorExpected {
        return  JsonUtils.jsonToObject(JsonUtils.objectToJson(this.data), arg);
    }

    public  <T> List<T> getList(TypeReference arg) throws ErrorExpected {
        return  JsonUtils.jsonToList(JsonUtils.objectToJson(this.data), arg);
    }

}
