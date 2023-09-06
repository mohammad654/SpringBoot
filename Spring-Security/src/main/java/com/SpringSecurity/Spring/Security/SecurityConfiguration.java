package com.SpringSecurity.Spring.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
//  1111  ************************************************************
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("a")
//                .password("1")
//                .roles("ADMIN")
//                .and()
//                .withUser("u")
//                .password("2")
//                .roles("USER");
//    }

//  22222222  ************************************************************
    @Autowired
    DataSource dataSource;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        auth.jdbcAuthentication()
////                .dataSource(dataSource)
////                .withDefaultSchema()
////                .withUser(
////                        User.withUsername("mo")
////                                .password("user")
////                                .roles("USER")
////                ) .withUser(
////                        User.withUsername("ali")
////                                .password("2")
////                                .roles("USER","ADMIN")
////                );
////   same but use data from database
//    auth.jdbcAuthentication().dataSource(dataSource);
////    change table and username
////     .usersByUsernameQuery("select username,password,enabled from users where username =?")
////                .authoritiesByUsernameQuery(" select u.username, r.name from users u join user_role ur on u.id = ur.user_id " +
////                        " join role r on ur.role_id = r.id where u.username =?");
//    }

    //  3333  ************************************************************//
    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService);
        auth.jdbcAuthentication().dataSource(dataSource);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER","ADMIN")
                .antMatchers("/").permitAll()
                .and()
                .formLogin();
    }
        @Bean
    public PasswordEncoder getPassword() {
        return NoOpPasswordEncoder.getInstance();
    }


}
