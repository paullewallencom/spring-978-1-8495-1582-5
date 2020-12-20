
package com.packtpub.liverestaurant.domain;

import java.io.Serializable;


public class PlaceOrderRequest implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 6733584925581620977L;
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
