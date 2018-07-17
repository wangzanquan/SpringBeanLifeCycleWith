package com.example.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean{
	private Long empId;
	private String jobPost;
	
	public Long getEmpId() {
		return empId;
	}
	
	
	
	public String getJobPost() {
		return jobPost;
	}



	public void setJobPost(String jobPost) {
		this.jobPost = jobPost;
	}



	public void setEmpId(Long empId) {
		this.empId = empId;
	}



	@Override
	public void destroy() throws Exception {
		System.out.println("I am in destroy method.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("I am in After PropertiesSet");
	}

}
