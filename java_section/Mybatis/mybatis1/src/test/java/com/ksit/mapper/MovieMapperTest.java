package com.ksit.mapper;

import com.ksit.entity.Movie;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.management.MXBean;

import java.util.Arrays;

import static org.junit.Assert.*;

public class MovieMapperTest {

    SqlSession sqlSession;
    MovieMapper movieMapper;

    @Before
    public void init(){
        sqlSession = SqlSessionFactoryUtil.returnSqlSession(true);
        movieMapper = sqlSession.getMapper(MovieMapper.class);
    }

    @Test
    public void queryListByTitle() {
        for (Movie movie : movieMapper.queryListByTitle("%罗马%")) {
            System.out.println(movie);
        }
    }

    @Test
    public void testQueryByTitleOrDirector(){
        for (Movie movie : movieMapper.queryByTitleOrDirector(null, null)) {
            System.out.println(movie);
        }
    }

    @Test
    public void testQueryByIdList(){
        for (Movie movie : movieMapper.queryByIdList(Arrays.asList(200, 201, 202))) {
            System.out.println(movie);
        }
    }

    @After
    public void release(){
        sqlSession.close();
    }
}