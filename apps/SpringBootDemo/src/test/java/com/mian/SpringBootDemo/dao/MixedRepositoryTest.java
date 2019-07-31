package com.mian.SpringBootDemo.dao;

import com.mian.SpringBootDemo.domain.Address;
import com.mian.SpringBootDemo.domain.Department;
import com.mian.SpringBootDemo.domain.Employee;
import com.mian.SpringBootDemo.domain.Role;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MixedRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Test
    public void testAddressAndDepartment() {
        Address address = new Address();
        address.setName("南软");
        Department support = new Department();
        support.setName("Operation");
        support.setAddress(address);
        departmentRepository.save(support);
    }

    @Test
    public void testEmployeeAndRole () {
        Address address = new Address();
        address.setName("南软");

        Department support = new Department();
        support.setName("Operation");
        support.setAddress(address);
        Department developer = new Department();
        developer.setName("DEV");
        developer.setAddress(address);

        Employee mian01 = new Employee();
        mian01.setName("MiAn01");
        Employee mian02 = new Employee();
        mian02.setName("MiAn02");
        Employee mian03 = new Employee();
        mian03.setName("MiAn03");

        developer.addEmployee(mian01);
        developer.addEmployee(mian02);
        support.addEmployee(mian03);

        Role manager = new Role();
        manager.setName("Manager");
        Role engineer = new Role();
        engineer.setName("Engineer");
        Role teamLeader = new Role();
        teamLeader.setName("Team Leader");

        mian01.addRole(manager);
        mian01.addRole(engineer);
        mian02.addRole(teamLeader);
        mian02.addRole(engineer);
        mian03.addRole(manager);

//        manager.addEmployee(mian01);
//        engineer.addEmployee(mian01);
//        teamLeader.addEmployee(mian02);
//        engineer.addEmployee(mian02);
//        manager.addEmployee(mian03);

//        employeeRepository.save(mian01);
//        employeeRepository.save(mian02);
//        employeeRepository.save(mian03);

        this.departmentRepository.save(developer);
        this.departmentRepository.save(support);
    }

}
