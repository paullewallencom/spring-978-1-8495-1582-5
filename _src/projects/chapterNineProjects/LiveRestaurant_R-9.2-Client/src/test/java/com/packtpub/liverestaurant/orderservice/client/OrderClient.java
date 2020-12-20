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
import com.packtpub.liverestaurant.domain.OrderItem;
import com.sun.syndication.feed.WireFeed;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.io.WireFeedOutput;

@Component("orderClient")
public class OrderClient {
	@Autowired
	protected RestTemplate restTemplate;
	private final static String serviceUrl = "http://localhost:8080/LiveRestaurant/";
	@SuppressWarnings("unchecked")
	public List<OrderItem> loadOrderItemsXML() {
		HttpEntity<String> entity = getHttpEntity(MediaType.APPLICATION_XML);
		ResponseEntity<List> response = restTemplate.exchange(serviceUrl
				+ "orderItems", HttpMethod.GET, entity, List.class);
		return response.getBody();
	}

	public Order placeOrder(String orderId) {
		HttpEntity<String> entity = getHttpEntity(MediaType.APPLICATION_XML);
		ResponseEntity<Order> response = restTemplate.postForEntity(serviceUrl
				+ "order/{orderId}", entity, Order.class, orderId);
		Order order = response.getBody();
		return order;
	}

	public Order placeOrderJson(String orderId) {
		HttpEntity<String> entity = getHttpEntity(MediaType.APPLICATION_JSON);
		ResponseEntity<Order> response = restTemplate.postForEntity(serviceUrl
				+ "orderJson/{orderId}", entity, Order.class, orderId);
		Order order = response.getBody();
		return order;
	}

	public String loadOrderItemsAtom() {
		HttpEntity<String> httpEntity = getHttpEntity(MediaType.APPLICATION_ATOM_XML);
		String outputStr = null;
		ResponseEntity<Feed> responseEntity = restTemplate.exchange(serviceUrl
				+ "orderItemsFeed", HttpMethod.GET, httpEntity, Feed.class);
		WireFeed wireFeed = responseEntity.getBody();
		WireFeedOutput wireFeedOutput = new WireFeedOutput();
		try {
			outputStr = wireFeedOutput.outputString(wireFeed);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return outputStr;
	}
	private HttpEntity<String> getHttpEntity(MediaType mediaType) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(httpHeaders);
		return httpEntity;
	}
}
