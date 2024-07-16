package com.techar.EntryPointBackend.core.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.util.List;

public class JsonUtils {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setPropertyNamingStrategy(PropertyNamingStrategies.LOWER_CAMEL_CASE)
            .registerModule(new JavaTimeModule());

    public static String objectToJson(Object arg) throws ErrorExpected {
        try {
            return OBJECT_MAPPER.writeValueAsString(arg);
        }catch (JsonProcessingException e){
            e.printStackTrace();
            throw new ErrorExpected("Error al parsear objeto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static <T> T jsonToObject(String json, Class<T> arg) throws ErrorExpected {
        try {
            return OBJECT_MAPPER.readValue(json, arg);
        }catch (IOException e){
            e.printStackTrace();
            throw new ErrorExpected("Error al parsear objeto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public static <T> List<T> jsonToList(String json, TypeReference arg) throws ErrorExpected {
        try {
            return (List<T>) OBJECT_MAPPER.readValue(json, arg);
        }catch (IOException e){
            e.printStackTrace();
            throw new ErrorExpected("Error al parsear objeto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
