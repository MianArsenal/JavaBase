package com.mian.SpringBootDemo.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ADDRESS")
@SequenceGenerator(name = "ADDRESS_ID_SEQ", sequenceName = "ADDRESS_ID_SEQ", allocationSize = 1)
public class Address implements Serializable {

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ADDRESS_ID_SEQ")
    @Id
    @Column(name = "ADDRESS_ID")
    private Integer id;
    @Column(nullable = false)
    private String name;
    @OneToOne
    @JoinColumn(name = "DEPARTMENT_ID", foreignKey = @ForeignKey(name = "ADDRESS_DEPARTMENT_FK"))
    private Department department;

    public Address(String name) {
        this.name = name;
    }

    public Address() {
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
}
