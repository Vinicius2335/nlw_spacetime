package com.github.vinicius2335.server.common.security.config;

import com.github.vinicius2335.server.common.security.config.exception.handling.AccessDeniedHandlerConfig;
import com.github.vinicius2335.server.common.security.config.exception.handling.AuthEntryPointConfig;
import com.github.vinicius2335.server.common.security.filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class WebConfigSecurity {
    private final JwtAuthenticationFilter jwtAuthFilter;
    private final AuthenticationProvider authenticationProvider;
    private final LogoutHandler logoutHandler;
    private final AuthEntryPointConfig authEntryPointConfig;
    private final AccessDeniedHandlerConfig accessDeniedHandlerConfig;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable);

        http
                .cors(
                        cors -> cors.configurationSource(request -> {
                            CorsConfiguration corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(List.of("*"));
                            corsConfiguration.setAllowedHeaders(List.of("*"));
                            corsConfiguration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE"));
                            return corsConfiguration;
                        })
                );

        http
                .authorizeHttpRequests(
                        authorize -> authorize
                                .requestMatchers("/api/auth/**")
                                    .permitAll()
                                .requestMatchers("/api/memories/**")
                                    .hasRole("USER")
                                .anyRequest()
                                    .authenticated()
                );

        http
                .sessionManagement(
                        session -> session
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                );

        http
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        http
                .exceptionHandling(
                        exception -> exception
                                .authenticationEntryPoint(authEntryPointConfig)
                                .accessDeniedHandler(accessDeniedHandlerConfig)
                );

        http
                .logout(
                        logout -> logout
                                .logoutUrl("/api/auth/logout")
                                .addLogoutHandler(logoutHandler)
                                .logoutSuccessHandler(
                                        (request, response, authentication) -> SecurityContextHolder.clearContext()
                                )
                );

        return http.build();
    }
}
