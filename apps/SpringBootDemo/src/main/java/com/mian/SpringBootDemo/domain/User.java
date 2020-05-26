package com.mian.SpringBootDemo.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/*
CREATE TABLE user
        (
        ID          int(11)     NOT NULL AUTO_INCREMENT,
        NAME        varchar(20) NOT NULL,
        AGE         int(11)     NOT NULL,
        SALARY      int(11)              DEFAULT NULL,
        CREATE_DATE timestamp   NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
        PRIMARY KEY (ID)
        ) ENGINE = InnoDB
        DEFAULT CHARSET = utf8;
 */

@Entity
@Table(name = "USER")
@SequenceGenerator(name = "USER_ID_SEQ", sequenceName = "USER_ID_SEQ", allocationSize = 1)
public class User implements Serializable {
    private static final long serialVersionUID = 4572582924467190065L;

    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_SEQ")
    @Id
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int age;
    @Column
    private int salary;
    @Column(nullable = false)
    private Date createDate;

    public User(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User(String name, int age, int salary, Date createDate) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.createDate = createDate;
    }

    public User() {

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
