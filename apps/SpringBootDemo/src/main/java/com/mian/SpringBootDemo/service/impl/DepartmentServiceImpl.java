package com.mian.SpringBootDemo.service.impl;

import com.mian.SpringBootDemo.dao.DepartmentRepository;
import com.mian.SpringBootDemo.domain.Department;
import com.mian.SpringBootDemo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findDepartmentByName(String name) {
        return this.departmentRepository.findByName(name);
    }

    @Override
    public List<Department> findAllDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteDepartmentByName(String name) {
        this.departmentRepository.deleteByName(name);
    }

    @Override
    public Department insertDepartment(Department department) {
        return this.departmentRepository.save(department);
    }
}
