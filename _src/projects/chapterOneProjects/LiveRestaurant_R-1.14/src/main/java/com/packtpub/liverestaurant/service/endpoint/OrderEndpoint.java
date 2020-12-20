package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.Namespace;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.packtpub.liverestaurant.service.OrderService;


@Endpoint
public class OrderEndpoint {
	private static final String NAMESPACE_URI = "http://www.packtpub.com/liverestaurant/OrderService/schema";
	private OrderService orderService;
	@Autowired
    public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}




    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "placeOrderRequest")
    @ResponsePayload
	public Element handlePlaceOrderRequest(
			@RequestPayload Element placeOrderRequest) throws Exception {

		Namespace namespace = Namespace.getNamespace("tns", NAMESPACE_URI);
		XPath refNumberExpression = XPath.newInstance("//tns:refNumber");
		refNumberExpression.addNamespace(namespace);

		XPath fNameExpression = XPath.newInstance("//tns:fName");
		fNameExpression.addNamespace(namespace);

		XPath lNameExpression = XPath.newInstance("//tns:lName");
		lNameExpression.addNamespace(namespace);

		String refNumber = refNumberExpression.valueOf(placeOrderRequest);
		String fName = fNameExpression.valueOf(placeOrderRequest);
		String lName = lNameExpression.valueOf(placeOrderRequest);
		;

		Namespace resNamespace = Namespace.getNamespace("tns", NAMESPACE_URI);
		Element root = new Element("placeOrderResponse", resNamespace);
		Element message = new Element("refNumber", resNamespace);
		message.setText(orderService.placeOrder(fName, lName, refNumber));
		root.addContent(message);
		Document doc = new Document(root);
		return doc.getRootElement();
	}
    
    
    
}
