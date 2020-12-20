package com.packtpub.liverestaurant.orderservice.service;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.List;

import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.OrderItem;




public interface OrderService {

	Order placeOrder(String orderId);

    List<OrderItem> listOrderItems();
}