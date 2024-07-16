package com.techar.EntryPointBackend.core.models.request;


import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    @NotNull(message = "User Name cannot be null")
    private String username;

    @NotNull(message = "Password cannot be null")
    private String password;

    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Last Name cannot be null")
    private String lastname;

    @NotNull(message = "Last Name cannot be null")
    private String idRol;

    @NotNull(message = "Last Name cannot be null")
    private String idUserTitles;

    public void validarPassword() throws ErrorExpected {
        String patron = "^\\d{4}$";
        Pattern pattern = Pattern.compile(patron);
        Matcher matcher = pattern.matcher(this.password);
        if (!matcher.matches()) {
            throw new ErrorExpected("The password must contain exactly 4 digits and must not contain letters or other characters", HttpStatus.BAD_REQUEST);
        }
    }


}
