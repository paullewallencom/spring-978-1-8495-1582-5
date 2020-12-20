package com.packtpub.liverestaurant.client;
/**
 * This software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Scanner;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamSource;

import junit.framework.Assert;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.version.Addressing10;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;
import org.springframework.ws.soap.SoapMessage;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderServiceClientTest {
	@Autowired
    private  WebServiceTemplate webServiceTemplate;
	private static InputStream placeOrderRequest;
	private static InputStream placeOrderResponse;

    @Autowired
    private GenericApplicationContext applicationContext;   
   

    @Before
	public   void setUpBefore() {
    	placeOrderRequest = new OrderServiceClientTest().getClass().getResourceAsStream("placeOrderRequest.xml");
       	placeOrderResponse = new OrderServiceClientTest().getClass().getResourceAsStream("placeOrderResponse.xml");
    	
	}
	@After
	public  void setUpAfter()  {
		applicationContext.close();
	}	
	@Test
	public  final void testPlaceOrderRequest() throws Exception {
		Result result = invokeWS(placeOrderRequest);
		 XMLAssert.assertXMLEqual("Invalid content received", getStringFromInputStream(placeOrderResponse), result.toString()); 
	}
	
	private    Result invokeWS(InputStream is) throws URISyntaxException {
        StreamSource source = new StreamSource(is);
        StringResult result = new StringResult();
        
        WebServiceMessageCallback action= new WebServiceMessageCallback() {

	           public void doWithMessage(WebServiceMessage message) {
	               ((SoapMessage)message).setSoapAction("http://www.packtpub.com/OrderService/OrdReq");
	           }
	       };//new ActionCallback(new URI("http://www.packtpub.com/OrderService/OrdReq"),new Addressing10(),new URI("http://localhost:8080/LiveRestaurant/spring-ws/OrderService"));
        webServiceTemplate.sendSourceAndReceiveToResult(source,action, result);
        return result;
	}
	public  String getStringFromInputStream (InputStream is) 
    throws IOException {
		BufferedInputStream bis = new BufferedInputStream(is);
	    ByteArrayOutputStream buf = new ByteArrayOutputStream();
	    int result = bis.read();
	    while(result != -1) {
	      byte b = (byte)result;
	      buf.write(b);
	      result = bis.read();
	    }        
	    return buf.toString();
   }
	
}
