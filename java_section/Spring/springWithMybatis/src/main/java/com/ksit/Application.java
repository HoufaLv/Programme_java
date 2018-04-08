package com.ksit;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * 使用配置类来做,则可以不使用配置文件
 */
@Configuration//标记为配置类
@ComponentScan//自动扫描
@PropertySource("classpath:config.properties")//扫描配置文件
@EnableTransactionManagement//开启基于注解的事务管理器
@MapperScan(basePackages = "com.ksit.mapper")//mapper 接口位于哪个文件夹下
public class Application {

    @Autowired
    Environment environment;

    /**
     * 配置类的配置根据applicationContext.xml 文件来
     * 先配置数据源
     * @return
     */

    @Bean
    public DataSource dataSource(){
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(environment.getProperty("jdbc.driver"));
        basicDataSource.setUrl(environment.getProperty("jdbc.url"));
        basicDataSource.setUsername(environment.getProperty("jdbc.username"));
        basicDataSource.setPassword(environment.getProperty("jdbc.password"));
        return basicDataSource;
    }

    /**
     * 再配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) throws IOException {
        //设置数据库连接池
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        //设置别名所在包,别名默认为列名
        sqlSessionFactoryBean.setTypeAliasesPackage("com.ksit.bean");

        //配置Mapper.xml 文件所在位置
        PathMatchingResourcePatternResolver pathMatchingResourcePatternResolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = pathMatchingResourcePatternResolver.getResources("classpath:mapper/*.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        //设置数据库下划线到实体类Camale 命名法
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration();
        configuration.setMapUnderscoreToCamelCase(true);

        sqlSessionFactoryBean.setConfiguration(configuration);

        return sqlSessionFactoryBean;
    }

}
