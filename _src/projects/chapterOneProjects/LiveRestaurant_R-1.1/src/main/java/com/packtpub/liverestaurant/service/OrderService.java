/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

package com.packtpub.liverestaurant.service;



public interface OrderService {

 
    String placeOrder(String name,String refNumber);
    boolean cancelOrder(String refNumber );
}
