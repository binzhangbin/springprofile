package cn.bin.zhang.service;

import cn.bin.zhang.vo.Blog;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext_Test.xml"})
public class Test_IBlogService {
    private static int uid;
    @Autowired
    private IBlogService iBlogService;

    @BeforeClass
    public static void init(){
        uid=1;
    }

    @Test
    public void  testFindByUid()throws Exception{
        Blog byUid = this.iBlogService.findByUid(uid);
        Assert.assertNotNull(byUid);
    }
}
