package com.atguigu.jdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;


import javax.sql.DataSource;

@Configuration
@ConditionalOnWebApplication
@EnableConfigurationProperties(MyJdbcProperties.class)
public class MyJdbcServiceAutoConfiguration {

    @Autowired
    private MyJdbcProperties myJDBCProperties;

    @Bean(name = "jdbcService")
    public MyJdbcService jdbcService(){
        MyJdbcService myJdbcService = new MyJdbcService();
        myJdbcService.setMyJDBCProperties(myJDBCProperties);
        return myJdbcService;
    }

    @Bean(name = "mySource")
    public DataSource dataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName(myJDBCProperties.getClassname());
        druidDataSource.setUsername(myJDBCProperties.getUsername());
        druidDataSource.setUrl(myJDBCProperties.getUrl());
        druidDataSource.setPassword(myJDBCProperties.getPassword());
        return druidDataSource;
    }

    @Bean(name = "myTransaction")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource());
    }

    @Bean(name = "mySqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        final SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource());
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().getResources(myJDBCProperties.getMapper_location()));
        return sqlSessionFactoryBean.getObject();
    }

}
