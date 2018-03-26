package com.ksit.entity;

/**
 * 实体类 人
 * @author Lvhoufa
 */
public class Person {

    private Integer id;
    private String name;
    private String gender;
    private Integer classId;

    private Classs classs;

    public Person() { }

    public Person(String name, String gender, Integer classId, Classs classs) {
        this.name = name;
        this.gender = gender;
        this.classId = classId;
        this.classs = classs;
    }

    public Person(Integer id, String name, String gender, Integer classId, Classs classs) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.classId = classId;
        this.classs = classs;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", classId=" + classId +
                ", classs=" + classs +
                '}';
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Classs getClasss() {
        return classs;
    }

    public void setClasss(Classs classs) {
        this.classs = classs;
    }
}