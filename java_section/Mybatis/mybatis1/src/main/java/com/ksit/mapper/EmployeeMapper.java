package com.ksit.mapper;

import com.ksit.entity.Employee;
import org.apache.ibatis.annotations.Insert;

/**
 * @author Lvhoufa
 */
public interface EmployeeMapper {

    @Insert("insert into t_employee (emp_name,emp_gender,emp_age) values (#{empName},#{empGender},#{empAge})")
    public void insertEmployee(Employee employee);

}
