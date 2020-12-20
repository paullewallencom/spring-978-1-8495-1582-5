
package com.packtpub.liverestaurant.domain;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;

@XML(name="cancelOrderResponse")
public class CancelOrderResponse
{
	@XMLField(name="cancelled")
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
