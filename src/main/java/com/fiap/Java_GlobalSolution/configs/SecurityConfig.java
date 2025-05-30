package com.fiap.Java_GlobalSolution.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers("/h2-console/**").permitAll() // libera o H2 console
                        .anyRequest().authenticated()
                )
                .formLogin(withDefaults -> {})
                .csrf(csrf -> csrf
                        .ignoringRequestMatchers("/h2-console/**") // desabilita CSRF para H2 console
                )
                .headers(headers -> headers
                        .frameOptions(frameOptions -> frameOptions.sameOrigin()) // permite frames do mesmo domínio
                );
        return http.build();
    }
}
