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
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.xml.transform.StringSource;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.packtpub.liverestaurant.service.OrderService;
/**
 * 
 * An annotated end-point that will be automatically detected by the Spring-WS framework, and handled by the appropriate adapter.
 * 
 */
@Endpoint
public class OrderSeviceEndpoint {	
	private static final Log logger = LogFactory.getLog(OrderSeviceEndpoint.class);
	private final String SERVICE_NS = "http://www.packtpub.com/liverestaurant/OrderService/schema";
	private OrderService orderService;
	@Autowired
	public OrderSeviceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}
	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public @ResponsePayload
	Source handlePlaceOrderRequest(@RequestPayload Source source) throws Exception {		
    String placeOrderRequestMessage = xmlToString(source);
	logger.info("\n\n Message Payload method handlePlaceOrderRequest  start ==== \n\n\n " + placeOrderRequestMessage + "\n\n\n ==== Message Payload End\n\n");
		//extract data from input parameter
		String fName="John";
		String lName="Smith";
		String refNumber="1234";	
    	return new StringSource(
		"<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>"+orderService.placeOrder(fName, lName, refNumber)+"</tns:refNumber></tns:placeOrderResponse>");
	}
	@PayloadRoot(namespace = SERVICE_NS, localPart = "cancelOrderRequest")
    @ResponsePayload
    public Source handleCancelOrderRequest(@RequestPayload Element cancelOrderRequest) throws Exception {
    	String refNumber=cancelOrderRequest.getElementsByTagNameNS(SERVICE_NS, "refNumber") .item(0).getTextContent();
        String cancelOrderRequestMessage = xmlToString(cancelOrderRequest);
    	logger.info("\n\nMessage Payload method handleCancelOrderRequest  start ==== \n\n\n " + cancelOrderRequestMessage + "\n\n\n ==== Message Payload End\n\n");
	    	return new StringSource(
		"<tns:cancelOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:cancelled>"+orderService.cancelOrder(refNumber)+"</tns:cancelled></tns:cancelOrderResponse>");
    }
	
	 private  String xmlToString(Node node) {
	        try {
	            Source source = new DOMSource(node);
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
	 
		private static String xmlToString(Source source) {
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
