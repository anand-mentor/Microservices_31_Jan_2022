package com.spring.SpringCoreDemo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\tpostProcessAfterInitialization: " + beanName);
		return bean;
	}

	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("\tpostProcessBeforeInitialization: " + beanName);
		if(bean instanceof MessagePrinterBean) {
			MessagePrinterBean mpb = (MessagePrinterBean)bean;
			mpb.setMessage("Hello in Java World!!");
		}
		return bean;
	}
}
