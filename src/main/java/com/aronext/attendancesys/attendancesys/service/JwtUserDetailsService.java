package com.aronext.attendancesys.attendancesys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 1:13 PM
 */

@Component
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

// Validate with the database
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        //TODO  this validation should be taken from the database
        if ("sysadmin".equals(username)) {
            String password=bCryptPasswordEncoder.encode("12345");
            return new User("sysadmin", password,
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
