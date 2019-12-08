package com.bin.zhang.mybatis;

import cn.bin.zhang.dao.IUserDAO;
import cn.bin.zhang.vo.User;
import com.bin.zhang.util.MyBatisSessionFactory;
import org.junit.Test;

import java.util.Date;


public class Test_IUserDAO {

    @Test
    public void findTest() throws Exception {
        IUserDAO mapper = MyBatisSessionFactory.getSession().getMapper(IUserDAO.class);
        String uname="bin";
        String upasswd="E10ADC3949BA59ABBE56E057F20F883E";
        User byNameAndPasswd = mapper.findByNameAndPasswd(uname, upasswd);
        System.out.println(byNameAndPasswd);
        MyBatisSessionFactory.getSession().commit();
        MyBatisSessionFactory.getSession().close();
    }

    @Test
    public void updateTest() throws Exception {
        IUserDAO mapper = MyBatisSessionFactory.getSession().getMapper(IUserDAO.class);
        User user=new User();
        user.setUid(1);
        user.setUname("bin");
        user.setUpasswd("E10ADC3949BA59ABBE56E057F20F883E");
        user.setUbirthday(new Date());
        user.setUage(21);
        user.setUinfo("handsome");
        user.setUphoto("null");
        boolean b = mapper.doUpdate(user)==1;
        System.out.println(b);
        MyBatisSessionFactory.getSession().commit();
        MyBatisSessionFactory.getSession().close();
    }
}