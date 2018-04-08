package com.ksit.mapper;

import com.ksit.entity.Movie;

import java.util.List;

public interface MovieMapper {

    Movie selectById(Integer id);

    void insertMovie(Movie movie);

    void updateMovie(Movie movie);

    List<Movie> selectAll();

    void insertBatch(List<Movie> movieList);

    void deleteById(Integer id);

}
