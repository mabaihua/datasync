package com.ntu.datasync.aop;

import com.ntu.datasync.config.DataSourceType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @Author: baihua
 * @Date: Created in 11/12/2019 3:55 PM
 */
@Aspect
@Component
public class DataSourceAop {
    //在primary方法前执行
    @Before("execution(* com.ntu.datasync.sync.CenterSync.start(..))")
    public void setDataSource2test01() {
        System.out.println("Center业务");
        //DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Primary);
    }

    //在secondary方法前执行
    @Before("execution(* com.ntu.datasync.sync.NodeSync.start(..))")
    public void setDataSource2test02() {
        System.out.println("Node业务");
       // DataSourceType.setDataBaseType(DataSourceType.DataBaseType.Secondary);
    }
}