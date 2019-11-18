package com.aronext.attendancesys.attendancesys.dto;

import com.aronext.attendancesys.attendancesys.constant.Role;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author Dilshan Niroda
 * @Date 2019-11-17
 * @Time 9:22 PM
 */
public class UserDTO {

    @NotEmpty(message = "Please provide an username")
    private String username;

    @NotEmpty(message = "Please provide a password")
    private String password;

    @NotNull(message = "Please provide a role")
    private Role role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
