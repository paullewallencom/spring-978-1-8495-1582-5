package com.packtpub.liverestaurant.client;

import java.net.URI;

import javax.xml.namespace.QName;
import javax.xml.transform.stream.StreamResult;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.addressing.client.ActionCallback;
import org.springframework.ws.soap.addressing.version.Addressing10;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import org.dom4j.Document;
import org.dom4j.io.SAXReader;

public class ClientTest {
	

  
	private static WebServiceTemplate wsTemplate = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
		wsTemplate = (WebServiceTemplate) appContext.getBean("webServiceTemplate");
	}
	@Test
	public  final void testCancelOrderRequest() throws Exception {
		
		SAXReader saxReader = new SAXReader();
		Document document = saxReader.read("input.xml");
	    StringResult result = new StringResult();

		
		 wsTemplate.sendSourceAndReceiveToResult( new StringSource(document.asXML()), result);
		 System.out.println(result);

		  
		
	}	
}
