package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;

public class OrderServiceClientTest {
	

    private static final String MESSAGE="<ns:OrderRequest xmlns:ns=\"http://www.packtpub.com/LiveRestaurant/OrderService/schema\" message=\"This is a sample Order Message\"/>";
	private static WebServiceTemplate wsTemplate = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
	}
	@Test
	public  final void testCancelOrderRequest() throws Exception {
	
		Result result = invokeWS(MESSAGE);
		Assert.assertTrue(result.toString().contains("OrderResponse"));
		
	}
	
	private  static  Result invokeWS(String xml) {
        StreamSource source = new StreamSource(new StringReader(xml));
       StringResult result = new StringResult();
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
	
	
	



	
	
	
	
	
	
}
