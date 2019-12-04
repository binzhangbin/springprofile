import cn.bin.zhang.cache.SpringCache;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext_Cache.xml"})
public class Test_SpringCache {
    @Autowired
    @Qualifier(value = "springCache")
    private SpringCache springCache;
    @Test
    public void cache() {

//        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_Cache.xml");
//        SpringCache springCache = (SpringCache) applicationContext.getBean("springCache");

//        @Qualifier("springCache")

        System.out.println(springCache.getData("1"));
        System.out.println(springCache.getData("1"));
        springCache.setData("1");
        System.out.println(springCache.getData("1"));
        System.out.println(springCache.getData("2"));
    }
}
