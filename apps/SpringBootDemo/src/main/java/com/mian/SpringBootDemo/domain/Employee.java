package com.mian.SpringBootDemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
@SequenceGenerator(name = "EMPLOYEE_ID_SEQ", sequenceName = "EMPLOYEE_ID_SEQ", allocationSize = 1)
public class Employee implements Serializable {


    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EMPLOYEE_ID_SEQ")
    @Id
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @ManyToOne
    @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "EMPLOYEE_DEPARTMENT_FK"))
    @JsonIgnore
    private Department department;
    @ManyToMany(mappedBy = "employees", cascade = CascadeType.ALL)
    private List<Role> roles;

    public Employee() {
        roles = new ArrayList<>();
    }

    public Employee(String name) {
        this.name = name;
        roles = new ArrayList<>();
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }
}
