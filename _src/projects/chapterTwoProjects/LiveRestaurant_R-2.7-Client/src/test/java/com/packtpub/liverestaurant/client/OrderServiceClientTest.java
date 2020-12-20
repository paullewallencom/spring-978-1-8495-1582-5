package com.packtpub.liverestaurant.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.InputStream;
import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.xml.xpath.XPathExpression;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;

public class OrderServiceClientTest {
	

	private static WebServiceTemplate wsTemplate = null;
	private static InputStream isPlace;
	private static InputStream isCancel;
	private static XPathExpression xpathExpCancel;
	private static XPathExpression xpathExpPlace;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
		isPlace = new OrderServiceClientTest().getClass().getResourceAsStream("placeOrderRequest.xml");
		isCancel = new OrderServiceClientTest().getClass().getResourceAsStream("cancelOrderRequest.xml");
		xpathExpCancel=(XPathExpression) appContext.getBean("xpathExpCancel");
		xpathExpPlace=(XPathExpression) appContext.getBean("xpathExpPlace");
	}
	@Test
	public  final void  testPlaceOrderRequest() {
		DOMResult result=invokeWS(isPlace);
		 String message = xpathExpPlace.evaluateAsString(result.getNode());
		 Assert.assertTrue(message.contains("Smith"));
	     
	}
	@Test
	public  final void  testCancelOrderRequest() {
		DOMResult result= invokeWS(isCancel);
		  Boolean cancelled = xpathExpCancel.evaluateAsBoolean(result.getNode());
		  Assert.assertTrue(cancelled);
	       
    }

	
	private static  DOMResult  invokeWS(InputStream is) {
        StreamSource source = new StreamSource(is);
        DOMResult result  = new  DOMResult ();
        wsTemplate.sendSourceAndReceiveToResult(source, result);
        return result;
	}
}
