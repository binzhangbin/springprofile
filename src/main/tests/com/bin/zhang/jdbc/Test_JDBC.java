package com.bin.zhang.jdbc;

import com.bin.zhang.jdbc.crud;
import cn.bin.zhang.vo.Blog;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Test_JDBC {
    private ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_JdbcTemplate.xml");
    @Test
    public void testAdd(){
        crud c = (crud) applicationContext.getBean("c");
        Blog blog=new Blog();
        blog.setBtxt("testaddtxt");
        blog.setBtitle("testaddtitle");
        blog.setUid(1);
        Assert.assertEquals(c.addBlog(blog),true);
    }
    @Test
    public void testBatchUpdate(){
        crud c = (crud) applicationContext.getBean("c");
        Blog blog=new Blog();
        blog.setBtxt("update1");
        blog.setBtitle("update1");
        blog.setUid(1);
        blog.setBid(3);
        Blog blog1=new Blog();
        blog1.setBtxt("update2");
        blog1.setBtitle("update2");
        blog1.setUid(1);
        blog1.setBid(2);
        List<Blog> list=new ArrayList<>();
        list.add(blog);
        list.add(blog1);
        Assert.assertEquals(c.updateBatch(list),2);
    }
    @Test
    public void testSelOne(){
        crud c = (crud) applicationContext.getBean("c");
        Assert.assertEquals(c.selOne(3).getBtitle(),"testaddtitle");
    }
    @Test
    public void testSelMapper(){
        crud c = (crud) applicationContext.getBean("c");
        Assert.assertEquals(c.selBlogByMapper(3).size(),1);
    }
    @Test
    public void testSelCall(){
        crud c = (crud) applicationContext.getBean("c");
        Assert.assertEquals(c.selBlogByMapper(3).size(),1);
    }
}
