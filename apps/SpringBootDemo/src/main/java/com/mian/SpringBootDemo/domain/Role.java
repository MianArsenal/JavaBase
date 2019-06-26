package com.mian.SpringBootDemo.domain;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @GeneratedValue
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "EMPLOYEE_ROLE_ASSOCIATION", joinColumns = {@JoinColumn(name = "ROLE_ID")}, inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")})
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
