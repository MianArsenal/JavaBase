package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.Role;
import com.mian.SpringBootDemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {

    private static final String SUCCESS = "SUCCESS";
    @Autowired
    private RoleService roleService;

    @RequestMapping("/insert")
    public Role insert(@RequestBody Role role) {
        return this.roleService.insertRole(role);
    }

    @RequestMapping("/delete/{name}")
    public String deleteByName(@PathVariable String name) {
        this.roleService.deleteRoleByName(name);
        return SUCCESS;
    }

    @RequestMapping("/name/{name}")
    public List<Role> findByName(@PathVariable String name) {
        return this.roleService.findRoleByName(name);
    }
}
