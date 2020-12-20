package com.packtpub.liverestaurant.service;





import javax.jws.WebService;

import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;
@WebService
public interface OrderService  {
	PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest);
}