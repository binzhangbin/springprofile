package com.bin.zhang.question.aop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class configurations {
 
	
	@Bean
	public Roleimplement getRoleinplement() {
		return new Roleimplement();
	}
	
	@Bean
	public AOP getAOP() {
		return new AOP();
	}
}