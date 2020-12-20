package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import javax.xml.transform.Source;

import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;

import com.packtpub.liverestaurant.service.OrderService;

/**
 * 
 * A simple method end-point that can be configured using
 * SimpleMethodEndpointMapping.
 * 
 */
public class OrderSeviceMethodEndpoint {	
	OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public @ResponsePayload
	Source handleplaceOrderRequest(@RequestPayload Source source) throws Exception {
		//extract data from input parameter
		String fName="John";
		String lName="Smith";
		String refNumber="1234";
		return new StringSource(
				"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName,lName,refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
	}
	
	
	

}
