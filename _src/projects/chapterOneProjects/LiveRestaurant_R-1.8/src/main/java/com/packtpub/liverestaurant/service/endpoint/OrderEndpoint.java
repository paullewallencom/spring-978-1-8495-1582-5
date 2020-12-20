package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

import javax.xml.transform.Source;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Element;
import com.packtpub.liverestaurant.service.OrderService;



@Endpoint
public class OrderEndpoint {
	private static final Log logger = LogFactory.getLog(OrderEndpoint.class);
    private static final String NAMESPACE_URI = "http://www.packtpub.com/liverestaurant/OrderService/schema";
	private OrderService orderService;
    @Autowired
	public OrderEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "placeOrderRequest")
    @ResponsePayload
    public Source handlePlaceOrderRequest(@RequestPayload Element placeOrderRequest) throws Exception {
    	String refNumber=placeOrderRequest.getElementsByTagNameNS(NAMESPACE_URI, "refNumber") .item(0).getTextContent();
    	String fName=placeOrderRequest.getElementsByTagNameNS(NAMESPACE_URI, "fName") .item(0).getTextContent();
    	String lName=placeOrderRequest.getElementsByTagNameNS(NAMESPACE_URI, "lName") .item(0).getTextContent();
	    	return new StringSource(
		"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName,lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
    }
  }
