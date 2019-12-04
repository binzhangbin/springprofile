import cn.bin.zhang.trans.BlogTransService;
import cn.bin.zhang.vo.Blog;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

public class Test_Trans {
    @Test
    public void test()throws Exception{
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring_trans.xml");
        Blog blog=new Blog();
        blog.setBid(2);
        blog.setBtitle("testTransTittle");
        blog.setBtxt("testTransTxt");
        blog.setUid(1);
        BlogTransService blogTransService = (BlogTransService) applicationContext.getBean("blogTransService");
        blogTransService.save(blog);
    }
}
