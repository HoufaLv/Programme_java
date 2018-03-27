package com.ksit.mapper;

import com.ksit.entity.Classs;
import com.ksit.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface PersonMapper {

    //Person queryClassNameByPersonId(Integer id);


    /**
     * 一对一查询使用注解查询出所有t_person 表的内容
     *
     * @param id
     * @return
     *//*
    @Select("select * from t_person where id=#{id} ")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "classId", column = "class_id")
    })
    Person queryPersonIdAnnotation(Integer id);*/


    /**
     * 一对多查询,封装一个Classs 到Person 类中去
     *
     * 测试的时候一定要将方法名写对
     * @param id
     * @return
     */
    @Select("select * from t_person where id=#{id} ")
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "gender", column = "gender"),
            @Result(property = "classId", column = "class_id"),
            @Result(property = "classs", column = "class_id", one = @One(select = "com.ksit.mapper.ClasssMapper.queryById"))
    })
    Person queryClassByPersonIdAnnotation(Integer id);

}
