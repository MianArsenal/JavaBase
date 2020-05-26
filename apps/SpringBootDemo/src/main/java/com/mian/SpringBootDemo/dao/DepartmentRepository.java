package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    List<Department> findByName(String name);

    void deleteByName(String name);

}
