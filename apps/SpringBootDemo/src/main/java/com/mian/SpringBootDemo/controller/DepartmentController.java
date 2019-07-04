package com.mian.SpringBootDemo.controller;

import com.mian.SpringBootDemo.domain.Department;
import com.mian.SpringBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private static final String SUCCESS = "SUCCESS";
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping("/insert")
    public Department insert(@RequestBody Department department) {
        return this.departmentService.insertDepartment(department);
    }

    @RequestMapping("/delete/{name}")
    public String deleteByName(@PathVariable String name) {
        this.departmentService.deleteDepartmentByName(name);
        return SUCCESS;
    }

    @RequestMapping("/name/{name}")
    public List<Department> findByName(@PathVariable String name) {
        return this.departmentService.findDepartmentByName(name);
    }
}
