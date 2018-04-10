package edu.biz.ioc;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class OrderManagerApp {

	public static void main(String[] args) {
		@SuppressWarnings("deprecation")
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("src/main/resources/ioc.xml"));
		
		OrderManager manager = (OrderManager)factory.getBean("orderManager");
		manager.order();
	}

}
