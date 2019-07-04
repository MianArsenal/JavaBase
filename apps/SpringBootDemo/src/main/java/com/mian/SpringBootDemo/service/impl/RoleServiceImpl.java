package com.mian.SpringBootDemo.service.impl;

import com.mian.SpringBootDemo.dao.RoleRepository;
import com.mian.SpringBootDemo.domain.Role;
import com.mian.SpringBootDemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public List<Role> findRoleByName(String name) {
        return this.roleRepository.findByName(name);
    }

    @Override
    public List<Role> findAllRoles() {
        return this.roleRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteRoleByName(String name) {
        this.roleRepository.deleteByName(name);
    }

    @Override
    public Role insertRole(Role role) {
        return this.roleRepository.save(role);
    }
}
