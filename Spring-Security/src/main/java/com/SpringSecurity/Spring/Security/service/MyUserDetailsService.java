package com.SpringSecurity.Spring.Security.service;

import com.SpringSecurity.Spring.Security.models.MyUserDetails;
import com.SpringSecurity.Spring.Security.models.UserEntity;
import com.SpringSecurity.Spring.Security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService  {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<UserEntity> user=userRepository.findByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("Not Found "+ userName));
        return user.map(MyUserDetails::new).get();
    }
}