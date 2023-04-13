package com.isa.vacationplanerwebapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.Properties;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}admin")
                .roles("ADMIN");
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}user")
                .roles("USER");
        auth.inMemoryAuthentication()
                .withUser("superuser")
                .password("{noop}superuser")
                .roles("SUPERUSER");

    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        final Properties users = new Properties();
        users.put("user", "{noop}user,ROLE_USER,enabled");
        users.put("superuser", "{noop}superuser,ROLE_SUPERUSER,enabled");
        users.put("admin", "{noop}admin,ROLE_ADMIN,enabled");
        return new InMemoryUserDetailsManager(users);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/index").permitAll()
                .antMatchers("/VacationList").hasAuthority("USER")
                .antMatchers("/employeeList").hasAuthority("USER")
                .antMatchers("/teamList").hasAuthority("USER")
                .antMatchers("/vacationModify").hasAuthority("SUPERUSER")
                .antMatchers("/employeeModify").hasAuthority("SUPERUSER")
                .antMatchers("/teamModify").hasAuthority("SUPERUSER")
                .antMatchers("/teamDelete").hasAuthority("SUPERUSER")
                .antMatchers("/vacationDelete").hasAuthority("SUPERUSER")
                .antMatchers("/employeeDelete").hasAuthority("SUPERUSER")
               // .antMatchers("/admin").hasAuthority("ROLE_ADMIN") - tszeba stworzyć panel admina
                .anyRequest().authenticated()
                .and()
                .formLogin();
    }


}

//    @Override
//    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService);
//    }

