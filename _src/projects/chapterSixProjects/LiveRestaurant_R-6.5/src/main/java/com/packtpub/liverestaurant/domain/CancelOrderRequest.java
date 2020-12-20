
package com.packtpub.liverestaurant.domain;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;

@XML(name="cancelOrderRequest")
public class CancelOrderRequest
{
	@XMLField(name="refNumber")
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
