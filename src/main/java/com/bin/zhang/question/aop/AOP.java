package com.bin.zhang.question.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
 
@Aspect
public class AOP {
	/**
	 * java动态代理是利用反射机制生成一个实现代理接口的匿名类，在调用具体方法前调用InvokeHandler来处理。
	 *
	 * 而cglib动态代理是利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。
	 *
	 * 1、如果目标对象实现了接口，默认情况下会采用JDK的动态代理实现AOP
	 * 2、如果目标对象实现了接口，可以强制使用CGLIB实现AOP
	 * 3、如果目标对象没有实现了接口，必须采用CGLIB库，spring会自动在JDK动态代理和CGLIB之间转换
	 *
	 * JDK动态代理和CGLIB字节码生成的区别？
	 *  （1）JDK动态代理只能对实现了接口的类生成代理，而不能针对类
	 *  （2）CGLIB是针对类实现代理，主要是对指定的类生成一个子类，覆盖其中的方法
	 *    因为是继承，所以该类或方法最好不要声明成final
	 */
	//测试参数this和target：https://blog.csdn.net/dhaiuda/article/details/82317005
//	@Pointcut("this(cn.bin.zhang.Roleinterface)")--target(匹配指定类及其子类)，this（）单纯的匹配指定类
//	@Pointcut("this(cn.bin.zhang.Roleimplement)")--target

	//问题——this和target
	@Pointcut("target(com.bin.zhang.question.aop.Roleimplement)")
	public void print() {};
	
	@Before("print()")
	public void beforeprint() {
		System.out.println("这是前置方法");
	}
	
	@After("print()")
	public void afterprint() {
		System.out.println("这是后置方法");
	}
	
	@AfterReturning("print()")
	public void afterreturning() {
		System.out.println("正常返回");
	}
	
	@AfterThrowing("print()")
	public void afterthrowing() {
		System.out.println("异常防护");
	}
}