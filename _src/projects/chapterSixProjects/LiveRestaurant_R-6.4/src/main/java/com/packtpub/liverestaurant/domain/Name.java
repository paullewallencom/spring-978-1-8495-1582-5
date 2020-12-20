
package com.packtpub.liverestaurant.domain;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("name")
public class Name
{
	
    private String FName;
    private String MName;
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
