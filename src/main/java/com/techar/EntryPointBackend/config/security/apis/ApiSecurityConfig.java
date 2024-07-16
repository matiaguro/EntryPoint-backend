package com.techar.EntryPointBackend.config.security.apis;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;

public interface ApiSecurityConfig {
    void configure(HttpSecurity http) throws Exception;

}
