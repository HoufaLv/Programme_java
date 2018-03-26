package com.ksit.entity;

public class Classs {

    private Integer id;
    private String name;

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

    @Override
    public String toString() {
        return "Classs{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
