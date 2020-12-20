package com.packtpub.liverestaurant.client;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;

public class OrderServiceClient {
	

	private static WebServiceTemplate wsTemplate = null;
	private static InputStream isPlace;

	
	public static void  main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		isPlace = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		
		testPlaceOrderRequest();

	}

	
	private static final void testPlaceOrderRequest() {
			 invokeWS(isPlace);
	}


	
	private static Result invokeWS(InputStream is) {
        StreamSource source = new StreamSource(is);
        StringResult result = new StringResult();
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
}
