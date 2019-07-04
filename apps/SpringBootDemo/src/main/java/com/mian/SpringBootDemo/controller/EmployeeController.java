package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.Employee;
import com.mian.SpringBootDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private static final String SUCCESS = "SUCCESS";
    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/insert")
    public Employee insert(@RequestBody Employee employee) {
        return this.employeeService.insertEmployee(employee);
    }

    @RequestMapping("/delete/{name}")
    public String deleteByName(@PathVariable String name) {
        this.employeeService.deleteEmployeeByName(name);
        return SUCCESS;
    }

    @RequestMapping("/name/{name}")
    public List<Employee> findByName(@PathVariable String name) {
        return this.employeeService.findEmployeeByName(name);
    }
}
