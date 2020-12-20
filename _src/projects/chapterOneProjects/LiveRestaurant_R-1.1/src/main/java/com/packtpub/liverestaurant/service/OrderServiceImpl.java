/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
package com.packtpub.liverestaurant.service;

import org.springframework.stereotype.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@Service
public class OrderServiceImpl implements OrderService {

    private static final Log logger = LogFactory.getLog(OrderServiceImpl.class);

    public String placeOrder(String name,String refNumber){
    	return "order-" +name+ "_"+refNumber;
    	
    }
    
    public boolean cancelOrder(String refNumber ){
    	
    	return true;
    	
    }
}
