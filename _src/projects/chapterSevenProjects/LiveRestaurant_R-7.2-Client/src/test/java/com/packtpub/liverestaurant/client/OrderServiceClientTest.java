package com.packtpub.liverestaurant.client;
/**
 * This software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
 */
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

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
	
	private    Result invokeWS(InputStream is) {
        StreamSource source = new StreamSource(is);
        StringResult result = new StringResult();
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);
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
