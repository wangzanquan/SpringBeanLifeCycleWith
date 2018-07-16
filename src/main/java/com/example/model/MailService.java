package com.example.model;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class MailService {
	private Map<String, String> map = null;

	/*
	 * This class is the example of Spring bean life cycle using Java Annotations 
	 */
	public MailService(Map<String, String> map) {
		this.map = map;
	}
	
	public void send(String mailTo) {
		//Code for sending mail
		System.out.println("Inside send method - " + mailTo);
	}
	
	@PostConstruct
	public void init() {
		map.put("host", "mail.example.com");
		map.put("port", "25");
		map.put("from", "example@someEmail.com");
		System.out.println("Inside init method - " + map);
	}
	
	@PreDestroy
	public void destroy() {
		map.clear();
		System.out.println("Inside destroy method - " + map);
	}
	
}
