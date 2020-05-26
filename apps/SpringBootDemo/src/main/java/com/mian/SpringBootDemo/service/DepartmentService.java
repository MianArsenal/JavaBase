package com.mian.SpringBootDemo.service;

import com.mian.SpringBootDemo.domain.Department;

import java.util.List;

public interface DepartmentService {

    List<Department> findDepartmentByName(String name);

    List<Department> findAllDepartments();

    void deleteDepartmentByName(String name);

    Department insertDepartment(Department department);
}
