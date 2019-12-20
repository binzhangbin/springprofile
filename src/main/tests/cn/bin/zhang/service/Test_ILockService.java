package cn.bin.zhang.service;

import cn.bin.zhang.service.ILockService;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//测试该代码片段的时候请注释掉cn.bin.zhang.aop.LoginLog
//@Component
//@Aspect
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext_Test.xml"})
public class Test_ILockService {
    private static  String ip="";
    private static int count=0;

    @Autowired
    private ILockService ilockService;


    @BeforeClass
    public static void init(){
        ip="0:0:0:0:0:0:0:1";
        count=2;
    }

    @Test
    public void testAddLock()throws Exception{
        boolean addFlag = this.ilockService.addLock(ip, count);
        Assert.assertEquals(true,addFlag);
    }

    @Test
    public void testgGetLock()throws Exception{
        Integer lock = this.ilockService.getLock(ip);
        Assert.assertEquals(count,lock.intValue());
    }


    @Test
    public void testdoUpdate()throws Exception{
        boolean updateFlag = this.ilockService.updateLock(ip, count + 1);
        Assert.assertEquals(true,updateFlag);
    }

}
