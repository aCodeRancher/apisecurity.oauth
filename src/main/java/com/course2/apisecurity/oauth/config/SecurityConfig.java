package com.course2.apisecurity.oauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig   {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
       // http.antMatcher("/**").authorizeRequests().antMatchers("/").permitAll().anyRequest().authenticated().and()
       //        .oauth2Login();

		http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/api/math/random").permitAll()
                .anyRequest()
                .authenticated().and().oauth2Login();
        return http.build();
    }
}
