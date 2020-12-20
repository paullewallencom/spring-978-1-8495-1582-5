package com.packtpub.liverestaurant.service.endpoint;




import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;


import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;

/**
 * 
 * An annotated end-point that will be automatically detected by the Spring-WS framework, and handled by the appropriate adapter.
 * 
 */
@Endpoint
public class OrderEndpoint{
	
	private final String SERVICE_NS = "http://www.packtpub.com/LiveRestaurant/OrderService/schema";
	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public	
	PlaceOrderResponse handleOrderRequest( PlaceOrderRequest orderRequest) throws Exception {
		PlaceOrderResponse orderResponse=new PlaceOrderResponse();
		orderResponse.setRefNumber(orderRequest.getOrder().getRefNumber());
    	return orderResponse;
	}
	

}
