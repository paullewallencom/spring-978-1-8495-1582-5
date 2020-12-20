package com.packtpub.liverestaurant.service.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.soap.addressing.server.annotation.Action; 
import com.packtpub.liverestaurant.domain.CancelOrderRequest;
import com.packtpub.liverestaurant.domain.CancelOrderResponse;
import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;
import com.packtpub.liverestaurant.service.OrderService;

/**
 * 
 * An annotated end-point that will be automatically detected by the Spring-WS framework, and handled by the appropriate adapter.
 * 
 */
@Endpoint
public class OrderServiceEndpoint {
	private final OrderService orderService;
	@Autowired
	public OrderServiceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@Action("http://www.packtpub.com/OrderService/CancelOrdReq")
	public 
	CancelOrderResponse handleCancelOrderRequest(CancelOrderRequest cancelOrderRequest) throws Exception {
		CancelOrderResponse cancelOrderResponse=new CancelOrderResponse();
		cancelOrderResponse.setCancelled(orderService.cancelOrder(cancelOrderRequest.getRefNumber()));
    	return cancelOrderResponse;
	}	
	@Action("http://www.packtpub.com/OrderService/OrdReq")
	public 
	PlaceOrderResponse handlePancelOrderRequest(PlaceOrderRequest placeOrderRequest) throws Exception {
		PlaceOrderResponse orderResponse=new PlaceOrderResponse();
		orderResponse.setRefNumber(orderService.placeOrder(placeOrderRequest.getOrder()));
   	return orderResponse;
	}
	
	
	
	
}
