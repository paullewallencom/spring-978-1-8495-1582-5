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

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.version.Addressing10;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.xml.xpath.XPathExpression;

public class OrderServiceClientTest {
	

	private static WebServiceTemplate wsTemplate = null;
	private static InputStream isPlace;
	private static InputStream isCancel;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("wsTemplate");
		isPlace = new OrderServiceClientTest().getClass().getResourceAsStream("placeOrderRequest.xml");
		isCancel = new OrderServiceClientTest().getClass().getResourceAsStream("cancelOrderRequest.xml");

	}

	@Test
	public  final void testPlaceOrderRequest() throws URISyntaxException {
			 invokeWS(isPlace,"http://www.packtpub.com/OrderService/OrdReq");
	}
	@Test
	public  final void testCancelOrderRequest() throws URISyntaxException {
		 invokeWS(isCancel,"http://www.packtpub.com/OrderService/CanOrdReq");
}
	
	private static Result invokeWS(InputStream is,String action) throws URISyntaxException {
        StreamSource source = new StreamSource(is);
        StreamResult result = new StreamResult(System.out);
        wsTemplate.sendSourceAndReceiveToResult(source, new ActionCallback(new URI(action),new Addressing10(),new URI("http://www.packtpub.com/liverestaurant/OrderService/schema")),
        	     result);

        return result;
	}
}
