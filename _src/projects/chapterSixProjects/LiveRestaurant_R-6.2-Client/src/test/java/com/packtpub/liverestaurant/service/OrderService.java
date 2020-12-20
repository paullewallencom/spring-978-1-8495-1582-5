package com.packtpub.liverestaurant.service;




/**
* <pre>
* Service interface for Order Service operations, handles two operations. <ul>
*     <li>placeOrderRequest</li>
*     <li>cancelOrderRequest</li>
* </ul>
* </pre>
*
*
* @see OrderServiceImpl
*
*/
public interface OrderService {

	 String placeOrder(com.packtpub.liverestaurant.orderService.schema.PlaceOrderRequestDocument orderRequestDoc);

	 boolean cancelOrder(String orderRef);
}