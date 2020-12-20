package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.remoting.httpinvoker.HttpInvokerProxyFactoryBean;


import com.packtpub.liverestaurant.service.endpoint.IOrderServiceEndPoint;



public class OrderServiceClient {
	static Logger logger = Logger.getLogger(OrderServiceClient.class);
	private static HttpInvokerProxyFactoryBean clientEndPointProxyFactory = null;
	
	

	public static void main (String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		
		clientEndPointProxyFactory = (HttpInvokerProxyFactoryBean) appContext.getBean("&clientEndPointProxyFactory");
		testCallServer();
	}

	
	

	private static void testCallServer() throws Exception {
		InputStream is = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		IOrderServiceEndPoint endPontProxy = (IOrderServiceEndPoint) clientEndPointProxyFactory.getObject();
		String realResponse = endPontProxy.invoke(convertStreamToString(is));
		logger.info(realResponse);
	}


	private static String convertStreamToString(InputStream is)
	            throws IOException {
	
	       if (is != null) {
	            Writer writer = new StringWriter();
	 
	           char[] buffer = new char[1024];
	            try {
	               Reader reader = new BufferedReader(
	                        new InputStreamReader(is, "UTF-8"));
	                int n;
	                while ((n = reader.read(buffer)) != -1) {
	                    writer.write(buffer, 0, n);
	                }
	            } finally {
	                is.close();
	            }
	            return writer.toString();
	        } else {       
	            return "";
	        }
	   }

	
}
