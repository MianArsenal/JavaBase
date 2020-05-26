package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    List<Role> findByName(String name);

    void deleteByName(String name);
}
