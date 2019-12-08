package com.bin.zhang.mybatis;

import com.bin.zhang.dao.BlogDAOImpl;
import com.bin.zhang.dao.IMBlogDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_SqlSessionTemplate {
    //测试Mybatis使用sqlSessionTemplate
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_sqlSessionTemplate.xml");
        IMBlogDAO imBlogDAO=(BlogDAOImpl)applicationContext.getBean("u");
        System.out.println(imBlogDAO.selectById(3));
    }
}
