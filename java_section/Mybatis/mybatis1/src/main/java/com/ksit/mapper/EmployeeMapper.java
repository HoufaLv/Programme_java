package com.ksit.mapper;

import com.ksit.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * @author Lvhoufa
 */
public interface EmployeeMapper {

    @Insert("insert into t_employee (emp_name,emp_gender,emp_age) values (#{empName},#{empGender},#{empAge})")
    public void insertEmployee(Employee employee);

    @Select("select * from t_employee where id = #{id}")
    public Employee queryById(int id);

    @Update("update t_employee set emp_name=#{empName},emp_gender=#{empGender},emp_age=#{empAge} where id=#{id}")
    public void updateEmployee(Employee employee);


}
