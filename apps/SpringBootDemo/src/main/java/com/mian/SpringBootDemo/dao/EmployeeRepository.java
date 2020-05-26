package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByName(String name);

    void deleteByName(String name);

}
