package com.ksit.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * @author Lvhoufa
 */
public class SqlSessionFactoryUtil {

    private static SqlSessionFactory sqlSessionFactory;

    //加载配置文件
    static {
        try {
            Reader resourceAsReader = Resources.getResourceAsReader("mybatisConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsReader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 返回SqlsessionFactory 对象
     * @return
     */
    public static SqlSessionFactory returnSqlSessionFactory(){
       return  sqlSessionFactory;
    }

    /**
     * 返回SqlSession 对象
     * @param autoCommit        是否开启自动提交
     * @return
     */
    public static SqlSession returnSqlSession(boolean autoCommit){
        return sqlSessionFactory.openSession(autoCommit);
    }

}
