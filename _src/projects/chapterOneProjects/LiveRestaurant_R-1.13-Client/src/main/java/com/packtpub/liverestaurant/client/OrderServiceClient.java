package com.packtpub.liverestaurant.client;

import java.io.InputStream;
import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class OrderServiceClient {
	

	private static WebServiceTemplate wsTemplate = null;
	private static InputStream isPlace;
	private static InputStream isCancel;
	
	public static void  main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		isPlace = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		//isCancel = new OrderServiceClient().getClass().getResourceAsStream("cancelOrderRequest.xml");
		testPlaceOrderRequest();
		//testCancelOrderRequest();
	}

	
	private static final void testPlaceOrderRequest() {
			 invokeWS(isPlace);
	}
	/*private static final void testCancelOrderRequest() {
		 invokeWS(isCancel);
}*/

	
	private static Result invokeWS(InputStream is) {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
}
