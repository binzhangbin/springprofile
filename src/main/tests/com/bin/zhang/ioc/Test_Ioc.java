package com.bin.zhang.ioc;

import com.bin.zhang.ioc.MoAttack;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test_Ioc {
    @Test
    public void iocTest() throws Exception {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext_Beans.xml");
        ((MoAttack)ac.getBean("moAttack1")).cityGateAsk();
    }
}
