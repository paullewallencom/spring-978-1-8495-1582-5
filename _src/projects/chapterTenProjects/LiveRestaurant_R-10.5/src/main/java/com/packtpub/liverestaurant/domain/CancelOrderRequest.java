
package com.packtpub.liverestaurant.domain;

import java.io.Serializable;


public class CancelOrderRequest implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 939200653947372605L;
	private String refNumber;

    /** 
     * Get the 'refNumber' element value.
     * 
     * @return value
     */
    public String getRefNumber() {
        return refNumber;
    }

    /** 
     * Set the 'refNumber' element value.
     * 
     * @param refNumber
     */
    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }
}
