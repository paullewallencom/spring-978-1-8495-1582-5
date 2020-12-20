
package com.packtpub.liverestaurant.domain;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;

@XML(name="placeOrderRequest")
public class PlaceOrderRequest
{
	 @XMLField(name="order")
    private Order order;

    /** 
     * Get the 'order' element value.
     * 
     * @return value
     */
    public Order getOrder() {
        return order;
    }

    /** 
     * Set the 'order' element value.
     * 
     * @param order
     */
    public void setOrder(Order order) {
        this.order = order;
    }
}
