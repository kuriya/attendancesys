package com.aronext.attendancesys.controller;

import com.aronext.attendancesys.constant.Role;
import com.aronext.attendancesys.dto.UserDTO;
import com.aronext.attendancesys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 12:51 PM
 */
@RestController
public class AttendanceController {

    @Autowired
    private UserService userDetailsService;

    @RequestMapping({ "/login" })
    public ModelAndView firstPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping({ "/register" })
    public ModelAndView registerPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("users/userSignUp");
        return modelAndView;
    }

    @RequestMapping({ "/dashboard" })
    public ModelAndView dashboardPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard/dashboard");
        return modelAndView;
    }

    @RequestMapping({ "/users" })
    public ModelAndView userListPage() {
        ModelMap modelMap = new ModelMap();
        UserDTO u1 = new UserDTO();
        u1.setUsername("dishandale");
        u1.setPassword("dishan1234");
        u1.setRole(Role.ADMIN);
        UserDTO u2 = new UserDTO();
        u2.setUsername("dilshannirodha");
        u2.setPassword("dilshan1234");
        u2.setRole(Role.EXECUTIVE);
        List<UserDTO> userList = new ArrayList<>();
        userList.add(u1);
        userList.add(u2);
        modelMap.addAttribute("employeeList", userList);
        return new ModelAndView("users/userlist", modelMap);
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDTO user){
        return ResponseEntity.ok(userDetailsService.save(user));
    }

}


