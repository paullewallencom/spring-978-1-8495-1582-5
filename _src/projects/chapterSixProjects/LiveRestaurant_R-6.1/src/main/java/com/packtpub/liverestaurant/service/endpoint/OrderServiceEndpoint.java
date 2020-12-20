package com.packtpub.liverestaurant.service.endpoint;

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;

import com.packtpub.liverestaurant.domain.CancelOrderRequest;
import com.packtpub.liverestaurant.domain.CancelOrderResponse;
import com.packtpub.liverestaurant.domain.ObjectFactory;
import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;
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

	private final OrderService orderService;
	private final ObjectFactory JAXB_OBJECT_FACTORY = new ObjectFactory();
	private final String SERVICE_NS = "http://www.packtpub.com/liverestaurant/OrderService/schema";

	@Autowired
	public OrderServiceEndpoint(OrderService orderService) {
		this.orderService = orderService;
	}

	@PayloadRoot(localPart = "placeOrderRequest", namespace = SERVICE_NS)
	public PlaceOrderResponse getOrder(
			PlaceOrderRequest placeOrderRequest) {
		
		PlaceOrderResponse response = JAXB_OBJECT_FACTORY
				.createPlaceOrderResponse();
		response.setRefNumber(orderService.placeOrder(placeOrderRequest
				.getOrder()));

		return response;
	}

	@PayloadRoot(localPart = "cancelOrderRequest", namespace = SERVICE_NS)
	public CancelOrderResponse cancelOrder(
			CancelOrderRequest cancelOrderRequest) {
		
		CancelOrderResponse response = JAXB_OBJECT_FACTORY
				.createCancelOrderResponse();
		response.setCancelled(orderService.cancelOrder(cancelOrderRequest
				.getRefNumber()));
		return response;
	}

}