package com.ksit.service;

import com.ksit.entity.Movie;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.TestExecutionListeners;

import java.util.Arrays;

public class MovieServiceTest extends BaseTest {

    @Autowired
    private MovieService movieService;

    @Test
    public void testSelectById() {
        Movie movie = movieService.selectById(104);
        System.out.println(movie);
    }

    @Test
    public void testInsertMovie(){
        Movie movie = new Movie();
        movie.setTitle("测试电影");
        movie.setRate(1.0F);
        movie.setReleaseYear("2008");
        movie.setSendTime("2008");
        movie.setDirector("测试电影");
        movie.setDescription("测试电影");

        movieService.insertMovie(movie);
    }

    @Test
    public void tsetUpdateMovie(){
        Movie movie = new Movie();
        movie.setId(780);
        movie.setTitle("测试电影1");
        movie.setRate(1.0F);
        movie.setReleaseYear("2008");
        movie.setSendTime("2008");
        movie.setDirector("测试电影1");
        movie.setDescription("测试电影1");

        movieService.updateMovie(movie);
    }

    @Test
    public void testSelectAll(){
        for (Movie movie : movieService.selectAll()) {
            System.out.println(movie);
        }
    }

    @Test
    public void testInsertBatch(){

        movieService.insertBatch(Arrays.asList(
                new Movie("测试电影2",1F,"2008","2008","测试电影2","测试电影2"),
                new Movie("测试电影3",1F,"2008","2008","测试电影3","测试电影3"),
                new Movie("测试电影4",1F,"2008","2008","测试电影4","测试电影4")
        ));
        
    }

    @Test
    public void testDeleteByid(){
        movieService.deleteById(783);
    }
}