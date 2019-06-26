package com.mian.SpringBootDemo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "DEPARTMENT_EMPLOYEE_ASSOCIATION", joinColumns = {@JoinColumn(name = "DEPARTMENT_ID")}, inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")})
    private List<Employee> employees;

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
