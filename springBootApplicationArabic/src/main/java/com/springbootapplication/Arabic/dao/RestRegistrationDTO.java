package com.springbootapplication.Arabic.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class RestRegistrationDTO {
    private String userName;
    private String email;
    private String password;
}
