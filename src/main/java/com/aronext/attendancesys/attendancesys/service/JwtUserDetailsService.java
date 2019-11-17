package com.aronext.attendancesys.attendancesys.service;

import com.aronext.attendancesys.attendancesys.repository.UserRepository;
import com.aronext.attendancesys.attendancesys.model.UserDTO;
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

    @Autowired
    private UserRepository userRepository;

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

    public com.aronext.attendancesys.attendancesys.model.User save(UserDTO user) {
        com.aronext.attendancesys.attendancesys.model.User newUser = new com.aronext.attendancesys.attendancesys.model.User();
        newUser.setUsername(user.getUsername());
        newUser.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(newUser);
    }
}
