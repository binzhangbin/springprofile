import cn.bin.zhang.dao.mybatis.dao.BlogDAOImpl;
import cn.bin.zhang.dao.mybatis.dao.IMBlogDAO;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_SqlSessionTemplate {
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext_sqlSessionTemplate.xml");
        IMBlogDAO imBlogDAO=(BlogDAOImpl)applicationContext.getBean("u");
        System.out.println(imBlogDAO.selectById(13));
    }
}
