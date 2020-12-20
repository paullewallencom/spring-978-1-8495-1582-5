package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import javax.xml.transform.Source;

import org.springframework.ws.server.endpoint.PayloadEndpoint;
import org.springframework.xml.transform.StringSource;

import com.packtpub.liverestaurant.service.OrderService;

public class SimplePayloadEndpoint implements PayloadEndpoint {
	OrderService orderService;
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

    public Source invoke(Source request) throws Exception {
    	//extract data from input parameter
		String fName="John";
		String lName="Smith";
		String refNumber="1234";
		
    	return new StringSource(
		"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName, lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
    }
    
    
}
