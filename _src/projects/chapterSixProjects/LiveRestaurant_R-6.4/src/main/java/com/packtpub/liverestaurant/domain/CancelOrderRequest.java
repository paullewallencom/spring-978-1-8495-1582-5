
package com.packtpub.liverestaurant.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("cancelOrderRequest")
public class CancelOrderRequest
{
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
