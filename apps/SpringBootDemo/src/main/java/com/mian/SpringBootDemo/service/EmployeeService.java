package com.mian.SpringBootDemo.service;

import com.mian.SpringBootDemo.domain.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployeeByName(String name);

    List<Employee> findAllEmployees();

    void deleteEmployeeByName(String name);

    Employee insertEmployee(Employee employee);
}
