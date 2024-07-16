package com.techar.EntryPointBackend.core.models.request;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {

    @NotNull(message = "UserId cannot be null")
    private String userId;
    @NotNull(message = "Name cannot be null")
    private String name;
    @NotNull(message = "LastName cannot be null")
    private String lastName;

    private String idTitles;
    private String idRol;


}








