package com.ksit.mapper;

import com.ksit.entity.Movie;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MovieMapper {

    List<Movie> queryListByTitle(@Param("title") String title);

}
