package com.packtpub.liverestaurant.service;


import java.util.Calendar;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import org.springframework.stereotype.Service;


@Service("orderServiceImpl")
@WebService(serviceName = "OrderService")
public class OrderServiceImpl  implements OrderService 

{
    @WebMethod(operationName = "placeOrder")
    public PlaceOrderResponse placeOrder(PlaceOrderRequest placeOrderRequest) {
    	PlaceOrderResponse response=new PlaceOrderResponse();
    	response.setRefNumber(getRandomOrderRefNo());
       
 		return response;
    }
    private String getRandomOrderRefNo() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        return "Ref-1234-" + year + "-" + month + "-" + day + "-" + Math.random();
    }
}