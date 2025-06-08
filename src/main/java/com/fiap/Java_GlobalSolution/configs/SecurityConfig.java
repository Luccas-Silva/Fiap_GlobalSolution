package com.fiap.Java_GlobalSolution.configs;

import com.fiap.Java_GlobalSolution.Service.UsuarioDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Autowired
    private UsuarioDetailsService usuarioDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authz -> authz
                        // 1. Libera acesso público para Home, Sensores (listar), Equipes (listar)
                        .requestMatchers("/", "/sensor/lista", "/equipe/lista").permitAll()
                        // 2. Libera arquivos para todos
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()
                        // 3. Libera acesso apenas para ADMIN ou DEV
                        .requestMatchers("/h2-console/**", "/actuator/**", "/ai/**", "/rabbit/**").hasAnyRole("ADMIN", "DEV")
                        // 4. Libera acesso autenticado para os recursos principais, independentemente do cargo/role
                        .requestMatchers("/usuario/**", "/equipe/**", "/sensor/**", "/arearisco/**", "/alerta/**").authenticated()
                        // 5. Qualquer outro endpoint requer ADMIN ou DEV
                        .anyRequest().hasAnyRole("ADMIN", "DEV")
                )
                // Habilita formulário de login padrão do Spring Security
                .formLogin(withDefaults -> {})
                // Desabilita CSRF para o H2 console (necessário para funcionar corretamente)
                .csrf(csrf -> csrf.ignoringRequestMatchers("/h2-console/**"))
                // Permite uso de frames do mesmo domínio (necessário para o H2 console)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.sameOrigin()))
                // Usa o provider customizado baseado no banco de dados
                .authenticationProvider(authenticationProvider());
        return http.build();
    }

    // Usa o serviço customizado que busca usuário do banco para autenticação
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(usuarioDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    // Configura o encoder de senha para texto plano
    @Bean
    public PasswordEncoder passwordEncoder() {
        return org.springframework.security.crypto.password.NoOpPasswordEncoder.getInstance();
    }
}