package cn.bin.zhang.dao;

import cn.bin.zhang.service.ILockService;
import org.junit.Assert;
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
public class Test_ILockDAO {
    @Autowired
    private ILockService lockService;
    @Test
    public void testgetLock()throws Exception{
        Integer lock = this.lockService.getLock("0:0:0:0:0:0:0:1");
        Assert.assertEquals(2,lock.intValue());
    }
}
