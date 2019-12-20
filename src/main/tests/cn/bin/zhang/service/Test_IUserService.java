package cn.bin.zhang.service;

import cn.bin.zhang.vo.User;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext_Test.xml"})
public class Test_IUserService {
    private static User user;
    @Autowired
    private IUserService iUserService;

    @BeforeClass
    public static void init(){
        user=new User();
        user.setUid(1);
        user.setUname("bin");
        user.setUinfo("update");
        user.setUbirthday(new Date());
        user.setUpasswd("E10ADC3949BA59ABBE56E057F20F883E");
        user.setUage(18);
    }

    @Test
    public void testFindByName()throws Exception{
        User byName = this.iUserService.findByName(user.getUname());
        Assert.assertNotNull(byName);
    }
    @Test
    public void testFindByNameAndPasswd()throws Exception{
        User byNameAndPasswd = this.iUserService.findByNameAndPasswd(user.getUname(), user.getUpasswd());
        Assert.assertNotNull(byNameAndPasswd);
    }
    @Test
    public void testUpdate()throws Exception{
        boolean updateFlag = this.iUserService.updateUser(user);
        Assert.assertEquals(true,updateFlag);
    }
    @Test
    public void testInsert()throws Exception{
        boolean insertUserFlag = this.iUserService.addUser(user);
        Assert.assertEquals(true,insertUserFlag);
    }
}
