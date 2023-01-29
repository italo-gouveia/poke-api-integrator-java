package com.pokemon.api.integrator.infrasctructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public DefaultSecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                //TODO: Implement auth logic
//                .authorizeHttpRequests((authz) -> authz
//                        .anyRequest().authenticated()
//                )
                .httpBasic(withDefaults());
        return http.build();
    }

}
