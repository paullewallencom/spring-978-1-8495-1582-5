package com.packtpub.liverestaurant.service;

import java.util.Calendar;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;


/**
* <pre>
* Service implementation for {@link OrderService}
* </pre>
*
* @see OrderService
*
*/
@Service
public class OrderServiceImpl implements OrderService {
   
    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

    public OrderServiceImpl() {
    }

 
    public String placeOrder(com.packtpub.liverestaurant.orderService.schema.PlaceOrderRequestDocument orderRequestDoc) {
        logger.info("Order has been placed. Order Info is : " + orderRequestDoc.getPlaceOrderRequest().getOrder().getRefNumber());
        return getRandomOrderRefNo();
    }


    public boolean cancelOrder(String orderRef) {
        logger.info("Order has been cancelled. Order Reference : " + orderRef);
        return true;
    }
   
    private String getRandomOrderRefNo() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        return "Ref-" + year + "-" + month + "-" + day + "-" + Math.random();
       
    }
}