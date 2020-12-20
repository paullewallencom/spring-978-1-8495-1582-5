package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

import java.io.InputStream;

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
	


	private static WebServiceTemplate wsTemplate = null;
	private static InputStream isPlace;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		isPlace = new OrderServiceClientTest().getClass().getResourceAsStream("placeOrderRequest.xml");
	}
	@Test
	public  final void testPlaceOrderRequest() throws Exception {
	
		Result result = invokeWS(isPlace);
		Assert.assertTrue(result.toString().indexOf("placeOrderResponse")>0);
		
	}
	
	private  static  Result invokeWS(InputStream is) {
		  StreamSource source = new StreamSource(is);
	        StringResult result = new StringResult();
	        wsTemplate.sendSourceAndReceiveToResult(source, result);
	        return result;
	}
	
	
	



	
	
	
	
	
	
}
