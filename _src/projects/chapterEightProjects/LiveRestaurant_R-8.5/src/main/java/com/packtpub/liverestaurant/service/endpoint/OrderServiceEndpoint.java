package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.server.endpoint.annotation.SoapAction;
import org.springframework.xml.transform.StringSource;

import com.packtpub.liverestaurant.service.OrderService;

/**
 * 
 * An annotated end-point that will be automatically detected by the Spring-WS framework, and handled by the appropriate adapter.
 * 
 */
@Endpoint
public class OrderServiceEndpoint {	
	private OrderService orderService;
	@Autowired
	public OrderServiceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}
	@SoapAction("http://www.packtpub.com/OrderService/OrdReq")
	public @ResponsePayload
	Source handlePlaceOrderRequest(@RequestPayload Source source) throws Exception {		

		//extract data from input parameter
		String fName="John";
		String lName="Smith";
		String refNumber="1234";
    	return new StringSource(
		"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName, lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
	}
	
	



}
