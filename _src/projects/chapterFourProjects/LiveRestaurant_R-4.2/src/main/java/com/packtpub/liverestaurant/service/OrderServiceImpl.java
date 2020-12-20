/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
package com.packtpub.liverestaurant.service;

import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

	public String placeOrder( String fName,String lName,String refNumber){
    	return "order-"+fName+"_"+lName+"_"+refNumber;
    }
    
    public boolean cancelOrder( String refNumber ){
    	return true;
    }
}
