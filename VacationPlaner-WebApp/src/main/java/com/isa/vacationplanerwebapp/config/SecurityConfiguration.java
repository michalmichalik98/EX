package com.isa.vacationplanerwebapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    SecurityFilterChain web(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/", "/home", "/index", "/css/*", "/assets/*", "/js/*").permitAll()
                .requestMatchers("/VacationList").hasRole("USER")
                .requestMatchers("/employeeList").hasRole("USER")
                .requestMatchers("/teamList").hasRole("USER")
                .requestMatchers("/vacationModify").hasRole("SUPERUSER")
                .requestMatchers("/employeeAdd").hasRole("SUPERUSER")
                .requestMatchers("/employeeModify").hasRole("SUPERUSER")
                .requestMatchers("/teamModify").hasRole("SUPERUSER")
                .requestMatchers("/teamDelete").hasRole("SUPERUSER")
                .requestMatchers("/vacationDelete").hasRole("SUPERUSER")
                .requestMatchers("/employeeDelete").hasRole("SUPERUSER")
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().denyAll())
            .formLogin((form) -> form
                .loginPage("/login")
                .permitAll())
            .logout(LogoutConfigurer::permitAll);

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user")
            .password(bCryptPasswordEncoder().encode("userPass"))
            .roles("USER")
            .build());
        manager.createUser(User.withUsername("superuser")
            .password(bCryptPasswordEncoder().encode("superuserPass"))
            .roles("SUPERUSER")
            .build());
        manager.createUser(User.withUsername("admin")
            .password(bCryptPasswordEncoder().encode("adminPass"))
            .roles("ADMIN")
            .build());
        return manager;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
