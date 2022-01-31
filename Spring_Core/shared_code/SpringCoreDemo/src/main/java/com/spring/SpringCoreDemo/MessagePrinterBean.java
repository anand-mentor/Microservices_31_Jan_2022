package com.spring.SpringCoreDemo;

import org.springframework.beans.factory.BeanNameAware;

public class MessagePrinterBean implements BeanNameAware {
	private String message;

	public MessagePrinterBean() {
		super();
		System.out.println("Inside constructor");
	}

	public void myInit() {
		System.out.println("myInit()");
	}
	public void myDestroy() {
		System.out.println("myDestroy()");
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
		System.out.println("setMessage(): " + this.message);
	}

	@Override
	public String toString() {
		return "MessagePrinterBean [message=" + message + "]";
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet");
		
	}

	public void setBeanName(String name) {
		System.out.println("Inside setBeanName(): " + name);
	}
	
}
