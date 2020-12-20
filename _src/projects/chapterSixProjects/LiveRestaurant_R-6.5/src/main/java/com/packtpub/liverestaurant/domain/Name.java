
package com.packtpub.liverestaurant.domain;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;

@XML(name="name")
public class Name
{
	@XMLField(name="FName")
    private String FName;
	@XMLField(name="MName")
    private String MName;
	@XMLField(name="LName")
    private String LName;

    /** 
     * Get the 'fName' element value.
     * 
     * @return value
     */
    public String getFName() {
        return FName;
    }

    /** 
     * Set the 'fName' element value.
     * 
     * @param fName
     */
    public void setFName(String fName) {
        FName = fName;
    }

    /** 
     * Get the 'mName' element value.
     * 
     * @return value
     */
    public String getMName() {
        return MName;
    }

    /** 
     * Set the 'mName' element value.
     * 
     * @param mName
     */
    public void setMName(String mName) {
        MName = mName;
    }

    /** 
     * Get the 'lName' element value.
     * 
     * @return value
     */
    public String getLName() {
        return LName;
    }

    /** 
     * Set the 'lName' element value.
     * 
     * @param lName
     */
    public void setLName(String lName) {
        LName = lName;
    }
}
