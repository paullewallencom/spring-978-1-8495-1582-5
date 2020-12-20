
package com.packtpub.liverestaurant.domain;

import java.io.Serializable;


public class CancelOrderResponse implements Serializable
{

    /**
	 * 
	 */
	private static final long serialVersionUID = 4782612674755265111L;
	private boolean cancelled;

    /** 
     * Get the 'cancelled' element value.
     * 
     * @return value
     */
    public boolean isCancelled() {
        return cancelled;
    }

    /** 
     * Set the 'cancelled' element value.
     * 
     * @param cancelled
     */
    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
