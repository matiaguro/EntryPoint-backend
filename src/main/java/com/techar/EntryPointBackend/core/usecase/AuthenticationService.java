package com.techar.EntryPointBackend.core.usecase;

import com.techar.EntryPointBackend.config.exception.ErrorExpected;
import com.techar.EntryPointBackend.config.security.components.JwtService;
import com.techar.EntryPointBackend.core.models.User;
import com.techar.EntryPointBackend.core.models.request.LoginRequest;
import com.techar.EntryPointBackend.core.models.request.RegisterRequest;
import com.techar.EntryPointBackend.core.models.response.AuthenticationResponse;
import com.techar.EntryPointBackend.core.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final PasswordEncoder passwordEncoder;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserRepository usuarioRepository;


    @Transactional
    public AuthenticationResponse login(LoginRequest loginRequest) throws ErrorExpected {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        var user = usuarioRepository.findByUserId(loginRequest.getUsername()).orElseThrow(() -> new ErrorExpected("Usuario no registrado", HttpStatus.BAD_REQUEST));

        var jwtToken = jwtService.generateToken(buildClaims(user), user);
        var refreshToken = jwtService.refreshToken(buildClaims(user), user);

        return AuthenticationResponse.builder()
                .token(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    @Transactional
    public void registerEmpleado(RegisterRequest registerRequest) {
    }

    private HashMap<String, Object> buildClaims(User user) {
        return new HashMap<>();
    }

}
