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
	 private static InputStream is;

	public static void main (String[] args) throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		  is = new OrderServiceClient().getClass().getResourceAsStream("placeOrderRequest.xml");
		testCancelOrderRequest();
	}

	
	private static final void testCancelOrderRequest() {
		Result result = invokeWS();
		System.out.println(result.toString());
	}


	
	
	private static  Result invokeWS() {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
	
	
	



	/**
	 * @param args
	 *//*
	public static void main(String[] args) {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
		System.out.println(appContext);
		
		WebServiceTemplate wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		
        StreamSource source = new StreamSource(new StringReader(MESSAGE));
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, result);


	}
	*/
	
	
	
	
	
}
