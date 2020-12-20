package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.server.endpoint.annotation.XPathParam;
import org.springframework.xml.transform.StringSource;

import com.packtpub.liverestaurant.service.OrderService;


/**
 * 
 * An annotated end-point that will be automatically detected by the Spring-WS framework, and handled by the appropriate adapter.
 * 
 */
@Endpoint
public class OrderEndpoint {
	
	private final String SERVICE_NS = "http://www.packtpub.com/liverestaurant/OrderService/schema";

	private OrderService orderService;

	@Autowired
	public OrderEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}

	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public @ResponsePayload
	Source handleOrderRequest(@XPathParam("//fName") String fName,@XPathParam("//lName") String lName,@XPathParam("//refNumber") String refNumber) throws Exception {
		return new StringSource(
		"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>" + orderService.placeOrder(fName, lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
	}

	@PayloadRoot(localPart = "cancelOrderRequest", namespace = SERVICE_NS)
	public @ResponsePayload
	Source handleCancelOrderRequest(@XPathParam("//refNumber") String refNumber) throws Exception {
		boolean cancelled = orderService.cancelOrder(refNumber);		
			return new StringSource(
					"<tns:cancelOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><cancelled>"+(cancelled?"true":"false")+"</cancelled></tns:cancelOrderResponse>");
	}



}
