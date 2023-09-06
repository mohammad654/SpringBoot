package com.Full.Full.Stack.App.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("super_admin").password(passwordEncoder().encode("1234")).roles(UserRole.SUPER_ADMIN.name())
                .and()
                .withUser("admin").password(passwordEncoder().encode("123")).roles(UserRole.ADMIN.name())
                .and()
                .withUser("user").password(passwordEncoder().encode("12")).roles(UserRole.USER.name());
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){return  new BCryptPasswordEncoder();}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/delete/**").hasRole(UserRole.SUPER_ADMIN.name())
                .antMatchers("/edit/**").hasAnyRole(UserRole.ADMIN.name(), UserRole.SUPER_ADMIN.name())
                .antMatchers("/edit").authenticated()
                .antMatchers("/").permitAll() // Permit access to the root URL ("/") without authentication
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
}
