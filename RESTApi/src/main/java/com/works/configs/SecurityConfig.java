package com.works.configs;

import com.works.services.EmployeService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    final EmployeService employeService;
    final PasswordEncoder passwordEncoder;

    // user -> sql
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(employeService).passwordEncoder(passwordEncoder);
    }


    // role -> mapping
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .httpBasic()
        .and()
        .authorizeHttpRequests()
        .antMatchers("/product/**").hasRole("product")
        .antMatchers("/note/**").hasRole("note")
        .and()
        .csrf().disable().formLogin().disable();
    }

}

/*
ali@mail.com -> product
veli@mail.com -> note
elif@mail.com -> product, note
 */
