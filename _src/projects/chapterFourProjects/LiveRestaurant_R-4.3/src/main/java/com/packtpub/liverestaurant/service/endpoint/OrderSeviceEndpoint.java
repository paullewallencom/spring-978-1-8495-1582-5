package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;

import com.packtpub.liverestaurant.service.OrderService;
import com.packtpub.liverestaurant.service.exception.InvalidOrderRequestException;
import com.packtpub.liverestaurant.service.exception.ProcessingFailedException;

/**
 * 
 * An annotated end-point that will be automatically detected by the Spring-WS framework, and handled by the appropriate adapter.
 * 
 */
@Endpoint
public class OrderSeviceEndpoint {	
	private final String SERVICE_NS = "http://www.packtpub.com/liverestaurant/OrderService/schema";
	private OrderService orderService;
	@Autowired
	public OrderSeviceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}
	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public @ResponsePayload
	Source handlePlaceOrderRequest(@RequestPayload Source source) throws Exception {		

		//extract data from input parameter
		String fName="John";
		String lName="Smith";
		String refNumber="";
		if(refNumber.length()>0)
    	return new StringSource(
		"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName, lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
		else 
			throw new InvalidOrderRequestException("Reference number is not provided!");
	}
	@PayloadRoot(localPart = "cancelOrderRequest", namespace = SERVICE_NS)
	public @ResponsePayload
	Source handleCancelOrderRequest(@RequestPayload Source source) throws Exception {
		//extract data from input parameter
		boolean cancelled =true ;	
		if( isDataBaseServerRunning())
			return new StringSource(
					"<tns:cancelOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><cancelled>"+(cancelled?"true":"false")+"</cancelled></tns:cancelOrderResponse>");
		else
			throw new ProcessingFailedException("Database server is down!");
	}
	private boolean isDataBaseServerRunning(){
		return false;
	}
	

	
	
	
	
	



}
