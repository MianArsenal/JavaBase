package com.mian.SpringBootDemo.service.impl;

import com.mian.SpringBootDemo.dao.EmployeeRepository;
import com.mian.SpringBootDemo.domain.Employee;
import com.mian.SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return this.employeeRepository.findByName(name);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteEmployeeByName(String name) {
        this.employeeRepository.deleteByName(name);
    }

    @Override
    public Employee insertEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }
}
