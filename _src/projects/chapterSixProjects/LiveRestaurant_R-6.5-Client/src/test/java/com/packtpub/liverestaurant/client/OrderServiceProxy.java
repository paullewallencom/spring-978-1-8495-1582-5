package com.packtpub.liverestaurant.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

import com.packtpub.liverestaurant.domain.CancelOrderRequest;
import com.packtpub.liverestaurant.domain.CancelOrderResponse;
import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;


public class OrderServiceProxy extends WebServiceGatewaySupport{
	
	
	public CancelOrderResponse handleCancelOrderRequest(CancelOrderRequest cancelOrderRequest){
		return  (CancelOrderResponse)
        getWebServiceTemplate().marshalSendAndReceive(cancelOrderRequest);
		
	}
	
	public PlaceOrderResponse handlePlaceOrderRequest(PlaceOrderRequest placeOrderRequest){
		return  (PlaceOrderResponse)
        getWebServiceTemplate().marshalSendAndReceive(placeOrderRequest);
		
	}

}
