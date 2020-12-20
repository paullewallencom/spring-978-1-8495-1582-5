
package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

import java.io.IOException;
import java.io.StringReader;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import java.io.InputStream;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class OrderServiceClient {
	

	
	private static WebServiceTemplate wsTemplate = null;
	private static InputStream is;
	
	public static void  main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		 is = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		testPlaceOrderRequest();
	}

	
	private static final void testPlaceOrderRequest() {
			 invokeWS();
	}
	
	private static Result invokeWS() {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
	
	

	
	
}
