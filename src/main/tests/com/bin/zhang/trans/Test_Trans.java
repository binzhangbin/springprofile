package com.bin.zhang.trans;

import cn.bin.zhang.vo.Blog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Trans {
    @Test
    public void test()throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_Trans.xml");
        Blog blog=new Blog();
        blog.setBid(2);
        blog.setBtitle("testTransTittle");
        blog.setBtxt("testTransTxt");
        blog.setUid(1);
        BlogTransService blogTransService = (BlogTransService) applicationContext.getBean("blogTransService");
        blogTransService.save(blog);
    }
}
