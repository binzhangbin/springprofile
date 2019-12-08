package com.bin.zhang.question.aop;
 
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(configurations.class);
    	Roleinterface temp=(Roleinterface)ctx.getBean(Roleinterface.class);
    	temp.print();
    }
}