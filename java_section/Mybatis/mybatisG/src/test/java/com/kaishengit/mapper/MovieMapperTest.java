package com.kaishengit.mapper;

import com.kaishengit.entity.Movie;
import com.kaishengit.entity.MovieExample;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MovieMapperTest {

    SqlSession sqlSession;
    MovieMapper movieMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    @After
    public void realease(){
        sqlSession.close();
    }

    @Test
    public void countByExample() {
    }

    @Test
    public void deleteByExample() {
    }

    @Test
    public void deleteByPrimaryKey() {
    }

    /**
     * 测试 插入数据
     */
    @Test
    public void insert() {
        Movie movie = new Movie();
        movie.setTitle("西游记2");
        movie.setRate(8.9F);
        movie.setReleaseYear("1995");
        int insert = movieMapper.insertSelective(movie);
        System.out.println(insert);
    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByExampleWithBLOBs() {
    }

    /**
     * 测试 查询所有
     * 底层在mapper.xml文件中会查询所有,可以去重和排序
     */
    @Test
    public void selectByExample() {

        MovieExample movieExample = new MovieExample();
        for (Movie movie : movieMapper.selectByExample(movieExample)) {
            System.out.println(movie);
        }

    }

    /**
     * 根据主键查询
     */
    @Test
    public void selectByPrimaryKey() {
        Movie movie = movieMapper.selectByPrimaryKey(201);
        System.out.println(movie);
    }

    @Test
    public void updateByExampleSelective() {
    }

    @Test
    public void updateByExampleWithBLOBs() {
    }

    @Test
    public void updateByExample() {
    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKeyWithBLOBs() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}