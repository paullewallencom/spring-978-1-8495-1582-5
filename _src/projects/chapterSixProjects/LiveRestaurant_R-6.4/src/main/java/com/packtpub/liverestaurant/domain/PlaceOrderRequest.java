
package com.packtpub.liverestaurant.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("placeOrderRequest")
public class PlaceOrderRequest
{
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
