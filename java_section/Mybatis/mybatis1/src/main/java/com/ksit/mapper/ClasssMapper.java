package com.ksit.mapper;

import com.ksit.entity.Classs;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface ClasssMapper {

    @Select("select * from t_classs where id = #{id} ")
    @Results(value = {
            @Result(column = "id", property = "id"),
            @Result(column = "name", property = "name")
    })
    Classs queryById(int id);
}
