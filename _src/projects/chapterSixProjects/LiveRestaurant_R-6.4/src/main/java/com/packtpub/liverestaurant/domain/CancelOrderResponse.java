
package com.packtpub.liverestaurant.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cancelOrderResponse")
public class CancelOrderResponse
{
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
