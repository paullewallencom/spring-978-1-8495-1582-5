package com.packtpub.liverestaurant.service.endpoint;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;
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
	Source handlePlaceOrderRequest(@RequestPayload Source source) throws Exception {
		
	   PlaceOrderRequest request = (PlaceOrderRequest) unmarshal(source, PlaceOrderRequest.class);
		PlaceOrderResponse response = new PlaceOrderResponse();
		String refNumber=request.getOrder().getRefNumber();
		String fName=request.getOrder().getCustomer().getName().getFName();
		String lName=request.getOrder().getCustomer().getName().getLName();
		response.setRefNumber(orderService.placeOrder(fName,lName,refNumber));
		
		return marshal(response);
	}
	private Object unmarshal(Source source, Class clazz) throws JAXBException {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(clazz);
			Unmarshaller um = context.createUnmarshaller();
			return um.unmarshal(source);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	private Source marshal(Object obj) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(obj.getClass());
		return new JAXBSource(context, obj);
	}
	
	
	
}
