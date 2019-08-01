package com.mian.SpringBootDemo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
@SequenceGenerator(name = "DEPARTMENT_ID_SEQ", sequenceName = "DEPARTMENT_ID_SEQ", allocationSize = 1)
public class Department implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "DEPARTMENT_ID_SEQ")
    @Id
    @Column(name = "DEPARTMENT_ID")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
    @OneToOne(mappedBy = "department", cascade = CascadeType.ALL)
    private Address address;

    public Department() {
        employees = new ArrayList<>();
    }

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
