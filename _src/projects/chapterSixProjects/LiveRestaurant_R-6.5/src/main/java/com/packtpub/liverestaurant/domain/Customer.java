
package com.packtpub.liverestaurant.domain;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;

@XML(name="customer")
public class Customer
{
	@XMLField(name="addressPrimary")
    private Address addressPrimary;
	@XMLField(name="addressSecondary")
    private Address addressSecondary;
	@XMLField(name="name")
    private Name name;

    /** 
     * Get the 'addressPrimary' element value.
     * 
     * @return value
     */
    public Address getAddressPrimary() {
        return addressPrimary;
    }

    /** 
     * Set the 'addressPrimary' element value.
     * 
     * @param addressPrimary
     */
    public void setAddressPrimary(Address addressPrimary) {
        this.addressPrimary = addressPrimary;
    }

    /** 
     * Get the 'addressSecondary' element value.
     * 
     * @return value
     */
    public Address getAddressSecondary() {
        return addressSecondary;
    }

    /** 
     * Set the 'addressSecondary' element value.
     * 
     * @param addressSecondary
     */
    public void setAddressSecondary(Address addressSecondary) {
        this.addressSecondary = addressSecondary;
    }

    /** 
     * Get the 'name' element value.
     * 
     * @return value
     */
    public Name getName() {
        return name;
    }

    /** 
     * Set the 'name' element value.
     * 
     * @param name
     */
    public void setName(Name name) {
        this.name = name;
    }
}
