package com.packtpub.liverestaurant.runner;
import java.io.IOException;


import org.springframework.context.support.ClassPathXmlApplicationContext;  


public class OrderServiceSetUp {
	
	public static void main(String[] args) throws IOException {
		   new ClassPathXmlApplicationContext("/applicationContext.xml");
        System.out.println("OrderService started");
        System.in.read();
    }

}
