package com.packtpub.liverestaurant.service.endpoint;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import com.packtpub.liverestaurant.service.OrderService;


@Endpoint
public class OrderEndpoint {
	private OrderService orderService;
    private static final String NAMESPACE_URI = "http://www.packtpub.com/liverestaurant/OrderService/schema";
	@Autowired
    public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "placeOrderRequest")
    @ResponsePayload
    public Element handlePlaceOrderRequest(@RequestPayload Element placeOrderRequest) throws Exception {
    	
    	String refNumber=placeOrderRequest.getElementsByTagNameNS(NAMESPACE_URI, "refNumber") .item(0).getTextContent();
    	String fName=placeOrderRequest.getElementsByTagNameNS(NAMESPACE_URI, "fName") .item(0).getTextContent();
    	String lName=placeOrderRequest.getElementsByTagNameNS(NAMESPACE_URI, "lName") .item(0).getTextContent();
	
    	DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder documentBuilder = documentBuilderFactory
    	.newDocumentBuilder();

    	Document document = documentBuilder.newDocument();
    	Element responseElement = document.createElementNS(NAMESPACE_URI,
    	"placeOrderResponse");
    	
         Element canElem=document.createElementNS(NAMESPACE_URI,"refNumber");
    	Text responseText = document.createTextNode(orderService.placeOrder(fName, lName, refNumber));

    	canElem.appendChild(responseText);
    	responseElement.appendChild(canElem);
    	return responseElement;
    }
    
  

  
}
