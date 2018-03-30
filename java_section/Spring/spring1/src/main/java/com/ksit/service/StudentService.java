package com.ksit.service;

import com.ksit.dao.StudentDao;

public class StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void studentDaoSave(){
        studentDao.save();
    }
}
