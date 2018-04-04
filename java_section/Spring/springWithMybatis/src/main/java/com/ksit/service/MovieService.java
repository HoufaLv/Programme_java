package com.ksit.service;

import com.ksit.entity.Movie;
import com.ksit.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieMapper movieMapper;

    public Movie selectById(Integer id){
        return movieMapper.selectById(id);
    }

    public void insertMovie(Movie movie){
        movieMapper.insertMovie(movie);
    }

    public void updateMovie(Movie movie){
        movieMapper.updateMovie(movie);
    }

    public List<Movie> selectAll(){
        return movieMapper.selectAll();
    }

    public void insertBatch(List<Movie> movieList){
        movieMapper.insertBatch(movieList);
    }
}
