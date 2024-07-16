package com.techar.EntryPointBackend.config.security;

import com.techar.EntryPointBackend.config.exception.handler.AuthenticationEntryPointHandler;
import com.techar.EntryPointBackend.config.exception.handler.CustomAccessDeniedHandler;
import com.techar.EntryPointBackend.config.security.components.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthFilter;

    private final AuthenticationProvider authenticationProvider;

    private final LogoutHandler logoutHandler;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {

        http.authorizeHttpRequests(request -> {
            request
            .anyRequest().permitAll();
            //.requestMatchers(AUTH_URL + LOGIN).permitAll()
            //.requestMatchers(AUTH_URL + REFRESH_TOKEN).permitAll()
            //.requestMatchers(AUTH_URL + FORGOTTEN_PASSWORD).permitAll()
            //.requestMatchers(AUTH_URL + REGISTER_CLIENT).permitAll()
            //.requestMatchers(AUTH_URL + REGISTER_EMPELADO).hasRole("ADMIN");

        });

        http
                .exceptionHandling(exceptionHandling->
                        exceptionHandling
                            .authenticationEntryPoint(new AuthenticationEntryPointHandler())
                            .accessDeniedHandler(new CustomAccessDeniedHandler()))

                .sessionManagement(sessionManager ->
                        sessionManager
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)

                .logout(httpSecurityLogoutConfigurer ->
                        httpSecurityLogoutConfigurer.logoutUrl("/user/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK)).permitAll())
                .securityContext(httpSecuritySecurityContextConfigurer -> httpSecuritySecurityContextConfigurer.requireExplicitSave(false))

                .csrf(AbstractHttpConfigurer::disable)
                .cors(corsConfigurer -> corsConfigurer.configurationSource(
                        request -> {
                            CorsConfiguration configuration = new CorsConfiguration();
                            configuration.setAllowedOrigins(List.of("*"));
                            configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                            configuration.setAllowedHeaders(List.of("Authorization", "Content-Type"));
                            return configuration;
                        }
                ));

        return http.build();
    }


}
