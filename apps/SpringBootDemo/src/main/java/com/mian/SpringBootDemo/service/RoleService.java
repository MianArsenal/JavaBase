package com.mian.SpringBootDemo.service;

import com.mian.SpringBootDemo.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findRoleByName(String name);

    List<Role> findAllRoles();

    void deleteRoleByName(String name);

    Role insertRole(Role role);
}
