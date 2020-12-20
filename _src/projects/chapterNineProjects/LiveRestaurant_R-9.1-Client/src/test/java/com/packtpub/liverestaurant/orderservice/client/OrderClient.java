package com.packtpub.liverestaurant.orderservice.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.OrderItem;;


@Component( "orderClient" )
public class OrderClient
{
	
	@Autowired
	protected RestTemplate restTemplate;


	private final static String serviceUrl = "http://localhost:8080/LiveRestaurant/";
	
	
	@SuppressWarnings( "unchecked" )
	public List<OrderItem> loadOrderItems()
	{
		return restTemplate.getForObject( serviceUrl + "orderItems", List.class );
	}
	

	public Order placeOrder( String orderId)
	{
		
		
		HttpEntity<String> entity = prepareGet(MediaType.APPLICATION_XML);
		ResponseEntity<Order> response = restTemplate.exchange(
				serviceUrl + "order/{orderId}", 
				HttpMethod.POST, entity, Order.class,orderId);
		
		Order order=response.getBody();
		return order;
	
	
	}
	
	private static HttpEntity<String> prepareGet(MediaType type) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(type);
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		return entity;
	}
	
}
	
	


