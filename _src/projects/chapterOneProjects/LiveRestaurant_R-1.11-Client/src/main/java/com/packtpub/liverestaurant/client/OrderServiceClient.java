package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.InputStream;
import java.io.StringReader;
import java.net.URI;
import java.net.URISyntaxException;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.version.Addressing10;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class OrderServiceClient {
	

	private static WebServiceTemplate wsTemplate = null;
	private static InputStream is;
	
	public static void  main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("wsTemplate");
		 is = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		testPlaceOrderRequest();
	}

	
	private static final void testPlaceOrderRequest() throws URISyntaxException {
			 invokeWS();
	}
	
	private static Result invokeWS() throws URISyntaxException {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, new ActionCallback(new URI("http://www.packtpub.com/OrderService/OrdReq"),new Addressing10(),new URI("http://www.packtpub.com/liverestaurant/OrderService/schema")),
        	     result);

        return result;
	}
}
