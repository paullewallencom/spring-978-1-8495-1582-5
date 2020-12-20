
package com.packtpub.liverestaurant.domain;


public class PlaceOrderRequest implements java.io.Serializable
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
