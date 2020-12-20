package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;

/**
 * 
 * A simple method end-point that can be configured using
 * SimpleMethodEndpointMapping.
 * 
 */
public class OrderSeviceMethodEndpoint {
    private static final String response="<ns:OrderResponse xmlns:ns=\"http://www.packtpub.com/LiveRestaurant/OrderService/schema\"><ns:message>Order Accepted!</ns:message></ns:OrderResponse>";
	public OrderSeviceMethodEndpoint() {
	}

	public @ResponsePayload
	Source handleOrderRequest(@RequestPayload Source source) throws Exception {
		System.out.println("Inside method, handleOrderMessage - actual request = "	+ xmlToString(source));
		System.out.println("Inside method, handleOrderMessage - actual response = "	+ response);
		
		return new StringSource(response);
	}




public String xmlToString(Source source) {
	try {
		StringWriter stringWriter = new StringWriter();
		Result result = new StreamResult(stringWriter);
		TransformerFactory factory = TransformerFactory.newInstance();
		Transformer transformer = factory.newTransformer();
		transformer.transform(source, result);
		return stringWriter.getBuffer().toString();
	} catch (TransformerConfigurationException e) {
		e.printStackTrace();
	} catch (TransformerException e) {
		e.printStackTrace();
	}
	return null;
}
}