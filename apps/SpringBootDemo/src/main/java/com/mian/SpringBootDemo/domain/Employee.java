package com.mian.SpringBootDemo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID")
    private Integer id;
    @Column(nullable = false)
    private String name;
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "EMPLOYEE_DEPARTMENT_FK"))
//    @JsonIgnore
//    private Department department;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "EMPLOYEE_ROLE_ASSOCIATION",
            joinColumns = {@JoinColumn(name = "EMPLOYEE_ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID")},
            foreignKey = @ForeignKey(name = "EMPLOYEE_ROLE_FK"),
            inverseForeignKey = @ForeignKey(name = "ROLE_EMPLOYEE_FK"))
    private List<Role> roles;

    public Employee() {
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

//    public Department getDepartment() {
//        return department;
//    }
//
//    public void setDepartment(Department department) {
//        this.department = department;
//    }

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
