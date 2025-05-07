package com.lab.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.lab.config.DatabaseTypeEnum;
import com.lab.config.DynamicRoutingDataSource;

@Aspect
@Component
public class DataSourceAspect {

    @Before("@annotation(com.lab.aop.ReadOnly)")
    public void useSlaveDataSource() {
    	DynamicRoutingDataSource.setDataSource(DatabaseTypeEnum.MASTER.getDatabaseType());
    }

    @Before("@annotation(com.lab.aop.WriteOnly)")
    public void useMasterDataSource() {
    	DynamicRoutingDataSource.setDataSource(DatabaseTypeEnum.MASTER.getDatabaseType());
    }

    //需要每次清空ThreadLocal的内容，防止内存泄漏
    @After("@annotation(com.lab.aop.ReadOnly) || @annotation(com.lab.aop.WriteOnly)")
    public void clearDataSource() {
    	DynamicRoutingDataSource.clearDataSource();
    }
}