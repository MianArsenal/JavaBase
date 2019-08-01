package com.mian.SpringBootDemo.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ROLE")
@SequenceGenerator(name = "ROLE_ID_SEQ", sequenceName = "ROLE_ID_SEQ", allocationSize = 1)
public class Role implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ROLE_ID_SEQ")
    @Id
    @Column(name = "ROLE_ID")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "EMPLOYEE_ROLE_ASSOCIATION",
            joinColumns = {@JoinColumn(name = "ROLE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
            foreignKey = @ForeignKey(name = "ROLE_EMPLOYEE_FK"),
            inverseForeignKey = @ForeignKey(name = "EMPLOYEE_ROLE_FK"))
    private List<Employee> employees;

    public Role() {
        employees = new ArrayList<>();
    }

    public Role(String name) {
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
}
