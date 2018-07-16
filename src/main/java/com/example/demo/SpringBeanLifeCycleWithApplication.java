package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.config.AppConfig;
import com.example.model.Employee;
import com.example.model.MailService;

@SpringBootApplication
public class SpringBeanLifeCycleWithApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contextWithJava = new AnnotationConfigApplicationContext(AppConfig.class);
		//Send mail 1
		MailService mailService1 = contextWithJava.getBean(MailService.class);
		mailService1.send("SpringBean@example.com");
		
		//Send mail 2
		MailService mailService2 = contextWithJava.getBean(MailService.class);
		mailService2.send("javaSession@example.com");
		
		contextWithJava.close();
		
		ConfigurableApplicationContext contextwithSpring = new ClassPathXmlApplicationContext("Bean.xml");
		System.out.println("Spring Bean started");
		Employee e1 = (Employee)contextwithSpring.getBean("employeeBean");
		System.out.println(e1.toString());
		contextwithSpring.close();
		
		
		
		//SpringApplication.run(SpringBeanLifeCycleWithApplication.class, args);
	}
}
