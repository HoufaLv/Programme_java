package com.kaishengit.mapper;

import com.github.pagehelper.PageHelper;
import com.kaishengit.entity.Movie;
import com.kaishengit.entity.MovieExample;
import com.ksit.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

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


    /**
     * 根据导演名称和评分 同时查询
     *
     */
    @Test
    public void selectLsitByDirector(){
        MovieExample movieExample = new MovieExample();
        movieExample.createCriteria().andDirectorLike("%卡梅隆%").andRateGreaterThanOrEqualTo(9.0F);

        List<Movie> movies = movieMapper.selectByExample(movieExample);
        System.out.println(movies);
    }

    @Test
    public void selectByOrRelationship(){
        MovieExample movieExample = new MovieExample();
        //example.or(); 方法不支持链式编程,必须写两次方法
        movieExample.or().andRateGreaterThanOrEqualTo(9.0F);
        movieExample.or().andReleaseYearGreaterThanOrEqualTo("2002");
        List<Movie> movies = movieMapper.selectByExample(movieExample);
        System.out.println(movies);
    }

    @Test
    public void testMybatisPaging(){
        //从几开始,取几个
        //也可以从第几页开始,取多少个
        PageHelper.offsetPage(0,5);
        MovieExample movieExample = new MovieExample();
        List<Movie> movies = movieMapper.selectByExample(movieExample);
        for (Movie m :
                movies) {
            System.out.println(m);
        }

    }

}