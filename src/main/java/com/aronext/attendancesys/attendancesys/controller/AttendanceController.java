package com.aronext.attendancesys.attendancesys.controller;

import com.aronext.attendancesys.attendancesys.model.UserDTO;
import com.aronext.attendancesys.attendancesys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 12:51 PM
 */
@RestController
public class AttendanceController {

    @Autowired
    private UserService userDetailsService;

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@RequestBody UserDTO user) throws Exception {
        return ResponseEntity.ok(userDetailsService.save(user));
    }

}


