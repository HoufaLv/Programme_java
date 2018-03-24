package com.ksit.entity;

/**
 * 雇员实体类
 * @author Lvhoufa
 */
public class Employee {

    private Integer id;
    private String empName;
    private String empGender;
    private Integer empAge;

    public Employee() { }

    public Employee(String empName, String empGender, Integer empAge) {
        this.empName = empName;
        this.empGender = empGender;
        this.empAge = empAge;
    }

    public Employee(Integer id, String empName, String empGender, Integer empAge) {
        this.id = id;
        this.empName = empName;
        this.empGender = empGender;
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", empGender='" + empGender + '\'' +
                ", empAge=" + empAge +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpGender() {
        return empGender;
    }

    public void setEmpGender(String empGender) {
        this.empGender = empGender;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }
}
