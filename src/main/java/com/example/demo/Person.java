package com.example.demo;

import javax.persistence.Id;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class Person {


    private Long id;

    @Column(name = "name", nullable = true, length = 20)
    private String name;

    @Id
    @GeneratedValue
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Column(name = "age", nullable = true, length = 4)
    private int age;
    public void setAge(int age){
        this.age=age;
    }
    public void setName(String name){
        this.name=name;
    }
}