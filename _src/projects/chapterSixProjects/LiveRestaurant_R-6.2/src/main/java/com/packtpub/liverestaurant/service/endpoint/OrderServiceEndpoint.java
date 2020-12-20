package com.packtpub.liverestaurant.service.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.packtpub.liverestaurant.orderService.schema.CancelOrderRequestDocument;
import com.packtpub.liverestaurant.orderService.schema.CancelOrderResponseDocument;
import com.packtpub.liverestaurant.orderService.schema.PlaceOrderRequestDocument;
import com.packtpub.liverestaurant.orderService.schema.PlaceOrderResponseDocument;
import com.packtpub.liverestaurant.service.OrderService;





/**
 * <pre>
 * This is the endpoint for the {@link OrderService}.
 * Requests are simply delegated to the {@link OrderService} for processing.
 * Two operations are mapped, using annotation, as specified in the link,
 * <a href="http://static.springsource.org/spring-ws/sites/1.5/reference/html/server.html#server-at-endpoint"
 * >http://static.springsource.org/spring-ws/sites/1.5/reference/html/server.html#server-at-endpoint</a
 * ><ul>
 *     <li>placeOrderRequest</li>
 *     <li>cancelOrderRequest</li>
 * </ul>
 * </pre>
 * 
 */
@Endpoint
public class OrderServiceEndpoint {
	

	private final String SERVICE_NS = "http://www.packtpub.com/liverestaurant/OrderService/schema";
	private final OrderService orderService;
	@Autowired
	public OrderServiceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}

	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public PlaceOrderResponseDocument getOrder(PlaceOrderRequestDocument orderRequestDoc) {	
		PlaceOrderResponseDocument orderResponseDocument =PlaceOrderResponseDocument.Factory.newInstance();
		orderResponseDocument.addNewPlaceOrderResponse();
		orderResponseDocument.getPlaceOrderResponse().setRefNumber(orderService.placeOrder(orderRequestDoc));
		return orderResponseDocument;
	}

	@PayloadRoot(localPart = "cancelOrderRequest", namespace = SERVICE_NS)
	public CancelOrderResponseDocument placeCancelOrderDoc(
			CancelOrderRequestDocument cancelOrderRequestDoc) {
	
		 CancelOrderResponseDocument cancelOrderResponseDocument= CancelOrderResponseDocument.Factory.newInstance();
		cancelOrderResponseDocument.addNewCancelOrderResponse();
		cancelOrderResponseDocument.getCancelOrderResponse().setCancelled(orderService.cancelOrder(cancelOrderRequestDoc.getCancelOrderRequest().getRefNumber()));
		return cancelOrderResponseDocument;
	}
}