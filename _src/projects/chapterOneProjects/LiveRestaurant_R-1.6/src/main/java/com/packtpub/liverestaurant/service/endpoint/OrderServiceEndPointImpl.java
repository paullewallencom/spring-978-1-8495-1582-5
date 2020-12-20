package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.packtpub.liverestaurant.service.OrderService;
import com.packtpub.liverestaurant.service.OrderServiceImpl;
@Service("orderServiceImpl")
public class OrderServiceEndPointImpl implements IOrderServiceEndPoint {
	static Logger logger = Logger.getLogger(OrderServiceEndPointImpl.class);
	 private static final String responseContent = "<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>Order Accepted!</tns:refNumber></tns:placeOrderResponse>";

	 public String invoke(String request) throws Exception {
			//extract data from input parameter
			String fName="John";
			String lName="Smith";
			String refNumber="1234";
			OrderService orderService=new OrderServiceImpl();
	    	return 
			"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName, lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>";
   
    }
}
