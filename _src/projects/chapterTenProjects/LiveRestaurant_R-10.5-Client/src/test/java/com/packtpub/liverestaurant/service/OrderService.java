package com.packtpub.liverestaurant.service;





import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;

public interface OrderService  {
	PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}