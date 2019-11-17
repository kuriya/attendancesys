package com.aronext.attendancesys.attendancesys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 12:51 PM
 */
@RestController
public class AttendanceController {

    @RequestMapping({ "/hello" })
    public String firstPage() {
        return "Hello World";
    }

}


