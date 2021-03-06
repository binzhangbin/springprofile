package cn.bin.zhang.dao;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext_Test.xml"})
public class Test_ILockDAO {
    private static  String ip="";
    private static int count=0;

    @Autowired
    private ILockDAO iLockDAO;


    @BeforeClass
    public static void init(){
        ip="0:0:0:0:0:0:0:1";
        count=2;
    }

    @Test
    public void testInsertLock()throws Exception{
        int addCount = this.iLockDAO.insertLock(ip, count);
        Assert.assertEquals(1,addCount);
    }

    @Test
    public void testSelLock()throws Exception{
        Integer lock = this.iLockDAO.getLock(ip);
        Assert.assertEquals(count,lock.intValue());
    }


    @Test
    public void testUpdate()throws Exception{
        int updateCount = this.iLockDAO.updateLock(ip, count + 1);
        Assert.assertEquals(1,updateCount);
    }

}
