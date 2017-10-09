package com.sf.login;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)//表示整合JUnit4进行测试
@ContextConfiguration(locations={"classpath:config/spring/applicationContext.xml"})//加载spring配置文件
public class TuTest {

    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Resource(name = "dataSource")
    private ComboPooledDataSource dataSource;

    @Test
    public void test1(){
        System.out.println(dataSource.getClass().toString());
    }
}
