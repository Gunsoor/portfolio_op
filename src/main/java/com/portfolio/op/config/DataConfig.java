package com.portfolio.op.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.portfolio.op.mapper")
public class DataConfig {

    @Bean public SqlSessionFactory sqlSessionFactory(DataSource datasource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();

        sqlSessionFactory.setDataSource(datasource);

        sqlSessionFactory.setTypeAliasesPackage("com.portfolio.op.dto");

        sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/*.xml"));

        return sqlSessionFactory.getObject();

    }

    @Bean public SqlSessionTemplate sqlSession(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }


    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);

    }

}
