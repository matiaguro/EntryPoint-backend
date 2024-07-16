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
public class LoginRequest {

    @NotNull(message = "User Name cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;

}
