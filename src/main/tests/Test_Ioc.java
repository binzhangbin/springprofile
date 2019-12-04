import cn.bin.zhang.ioc.MoAttack;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Ioc {
//    Logger logger=Logger.getLogger(Test_Ioc.class);
    @Test
    public void iocTest() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
        ((MoAttack)ac.getBean("moAttack2")).cityGateAsk();
    }
}
