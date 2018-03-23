package com.ksit.mapper;

import com.ksit.entity.Student;

import java.util.List;

public interface StudentMapper {

    /**
     * 通过id查询学生信息和对应的标签
     * @param id
     * @return
     */
    Student findByIdWithTag(int id);

    /**
     * 通过id 查询学生信息和对应的学校信息
     * @param id
     * @return
     */
    Student findStudentSchoolById(int id);

    List<Student> queryAll();
}
