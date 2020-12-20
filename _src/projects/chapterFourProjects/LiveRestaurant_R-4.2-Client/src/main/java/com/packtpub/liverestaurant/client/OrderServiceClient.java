package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.InputStream;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;

public class OrderServiceClient {
	

	private static WebServiceTemplate wsTemplate = null;
	private static InputStream placeOrderRequestStream;

	
	public static void  main(String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		placeOrderRequestStream = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		
		testPlaceOrderRequest();
	
	}

	
	private static final void testPlaceOrderRequest() {
			 invokeWS(placeOrderRequestStream);
	}


	
	private static Result invokeWS(InputStream is) {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
}
