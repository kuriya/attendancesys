package com.aronext.attendancesys.controller;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 1:04 PM
 */

import com.aronext.attendancesys.config.JwtTokenUtil;
import com.aronext.attendancesys.model.JwtRequest;
import com.aronext.attendancesys.model.JwtResponse;
import com.aronext.attendancesys.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@RestController
@CrossOrigin
public class AuthenticationController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@Valid @RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @RequestMapping(value = "/loginAuthenticate", method = RequestMethod.POST)
    public ModelAndView authentication(@Valid @ModelAttribute JwtRequest authenticationRequest)  {
        ModelAndView modelAndView = new ModelAndView();
        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        }catch (Exception e){
            modelAndView.setViewName("login");
            return modelAndView;
        }
        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        if(token !=null){
            modelAndView.setViewName("dashboard/dashboard");
        }else{
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }




    private void authenticate(String username, String password) throws Exception {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            LOGGER.error(" User Disabled exception {}",e);
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            LOGGER.error(" Bad Creadiantials exception {}",e);
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
}
