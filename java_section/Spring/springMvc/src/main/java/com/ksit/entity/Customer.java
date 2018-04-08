package com.ksit.entity;

/**
 * @author Lvhoufa
 */
public class Customer {

    private Integer id;
    private String name;
    private Integer gender;

    public Customer() { }

    public Integer getId() {
        return id;
    }

    public Customer(String name, Integer gender) {
        this.name = name;
        this.gender = gender;
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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }
}
