package com.lab.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.aopalliance.intercept.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@MapperScan(basePackages = "com.lab.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {
	/**
	 * 主库数据源
	 * @return
	 */
    @Bean(name = "masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.master")
    public DataSource masterDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
    
    /**
     * 动态切换数据源
     * @param masterDataSource
     * @param slaveDataSource
     * @return
     * 
     * 预先定义多数据源备用，当前实际是单一PostgreSQL数据源
     */
    @Primary
    @Bean(name = "dynamicDataSource")
    public DataSource dynamicDataSource(@Qualifier("masterDataSource") DataSource masterDataSource) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put(DatabaseTypeEnum.MASTER.getDatabaseType(), masterDataSource);
       
        DynamicRoutingDataSource dataSource = new DynamicRoutingDataSource();
        //设置默认的数据源，当没有指定数据源时，将使用主库为默认数据源
        dataSource.setDefaultTargetDataSource(masterDataSource);
        //将配置好的多数据源设置到DynamicRoutingDataSource中
        dataSource.setTargetDataSources(targetDataSources);
        return dataSource;
    }
    
	/**
	 * 配置sqlSession
	 * @param dataSource
	 * @return
	 * @throws Exception
	 */
    @Bean
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dynamicDataSource") DataSource dataSource) throws Exception {
    	 // 导入mybatissqlsession配置
        MybatisSqlSessionFactoryBean sessionFactory = new MybatisSqlSessionFactoryBean();
        
        // 指明数据源
        sessionFactory.setDataSource(dataSource);
        
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:mapper/*Mapper.xml"));
        
        sessionFactory.setPlugins(mybatisPlusInterceptor());
        // 返回SqlSessionFactory实例，用于创建SqlSession，使用SqlSession调用sql时不需要指定数据源，因为就在此处指定了
        return sessionFactory.getObject();
    }
    
    /**
     * 配置事务管理器
     * @param dataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager transactionManager(@Qualifier("dynamicDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
    
    /**
	 * mybatis-Plus 分页配置
	 * 注意：如果是单数据源，此时分页插件能正常使用，而如果是多数据源，那么还需在配置SqlSessionFactory的地方再添加配置，否则分页时查询总数total还是0
	 * @return
	 */
	@Bean
	public MybatisPlusInterceptor mybatisPlusInterceptor() {
		MybatisPlusInterceptor mybatisPlusInterceptor=new MybatisPlusInterceptor();
		PaginationInnerInterceptor paginationInnerInterceptor=new PaginationInnerInterceptor();
		paginationInnerInterceptor.setDbType(DbType.POSTGRE_SQL);
		paginationInnerInterceptor.setOverflow(true);
		mybatisPlusInterceptor.addInnerInterceptor(paginationInnerInterceptor);
		return mybatisPlusInterceptor;
	}
}