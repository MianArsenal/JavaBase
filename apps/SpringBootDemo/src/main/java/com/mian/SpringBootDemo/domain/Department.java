package com.mian.SpringBootDemo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "DEPARTMENT")
public class Department implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "DEPARTMENT_ID")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID", foreignKey = @ForeignKey(name = "DEPARTMENT_ADDRESS_FK"))
    private Address address;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEE",
            joinColumns = {@JoinColumn(name = "DEPARTMENT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")})
    private List<Employee> employees;

    public Department() {
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

    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
}
