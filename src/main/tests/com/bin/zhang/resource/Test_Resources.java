package com.bin.zhang.resource;

import org.junit.BeforeClass;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 测试资源文件读取
 */
public class Test_Resources {
    static ResourceBundle rb1=null;
    static ResourceBundle rb2=null;
    @BeforeClass
    public static void init(){
        rb2=ResourceBundle.getBundle("language", Locale.CHINA);
        rb1=ResourceBundle.getBundle("language", Locale.US);
    }
    @Test
    public void testResource(){
        Object params[]={"John",new GregorianCalendar().getTime()};
        String str1=new MessageFormat(rb1.getString("common"),Locale.US).format(params);
        System.out.println(str1);
        String str2=new MessageFormat(rb1.getString("common"),Locale.CHINA).format(params);
        System.out.println(str2);
    }
}
