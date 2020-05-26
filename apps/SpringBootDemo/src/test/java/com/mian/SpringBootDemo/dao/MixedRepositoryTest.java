package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.Address;
import com.mian.SpringBootDemo.domain.Department;
import com.mian.SpringBootDemo.domain.Employee;
import com.mian.SpringBootDemo.domain.Role;
import com.mian.SpringBootDemo.service.AddressService;
import com.mian.SpringBootDemo.service.DepartmentService;
import com.mian.SpringBootDemo.service.EmployeeService;
import com.mian.SpringBootDemo.service.RoleService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MixedRepositoryTest {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private RoleService roleService;

    @Test
    public void test() {
        Role manager = new Role("Manager");
        Role teamLeader = new Role("Team Leader");
        Role developer = new Role("Developer");
        Role specialist  = new Role("Specialist");

        Address address = new Address("南软01号");
        Department operations = new Department("运维");
        address.setDepartment(operations);
        operations.setAddress(address);

        Employee henry = new Employee("Henry");
        manager.addEmployee(henry);
        specialist.addEmployee(henry);
        henry.addRole(manager);
        henry.addRole(specialist);
        henry.setDepartment(operations);
        operations.addEmployee(henry);

        Employee damian = new Employee("Damian");
        teamLeader.addEmployee(damian);
        developer.addEmployee(damian);
        damian.addRole(teamLeader);
        damian.addRole(developer);
        damian.setDepartment(operations);
        operations.addEmployee(damian);

        this.departmentService.insertDepartment(operations);

        Assert.assertEquals(this.addressService.findAddressByName("南软01号").size(), 1);
        Assert.assertEquals(this.employeeService.findEmployeeByName("Henry").size(), 1);
        Assert.assertEquals(this.employeeService.findEmployeeByName("Damian").size(), 1);
        Assert.assertEquals(this.departmentService.findDepartmentByName("运维").size(), 1);
        Assert.assertEquals(this.roleService.findRoleByName("Manager").size(), 1);

        this.departmentService.deleteDepartmentByName("运维");
    }

}
