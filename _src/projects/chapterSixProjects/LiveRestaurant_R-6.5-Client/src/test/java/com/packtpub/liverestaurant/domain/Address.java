
package com.packtpub.liverestaurant.domain;
import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;
@XML(name="address")
public class Address
{
	@XMLField(name="doorNo")
    private String doorNo;
	@XMLField(name="building")
    private String building;
	@XMLField(name="street")
    private String street;
	@XMLField(name="city")
    private String city;
	@XMLField(name="country")
    private String country;
	@XMLField(name="phoneMobile")
    private String phoneMobile;
	@XMLField(name="phoneLandLine")
    private String phoneLandLine;
	@XMLField(name="email")
    private String email;

    /** 
     * Get the 'doorNo' element value.
     * 
     * @return value
     */
    public String getDoorNo() {
        return doorNo;
    }

    /** 
     * Set the 'doorNo' element value.
     * 
     * @param doorNo
     */
    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    /** 
     * Get the 'building' element value.
     * 
     * @return value
     */
    public String getBuilding() {
        return building;
    }

    /** 
     * Set the 'building' element value.
     * 
     * @param building
     */
    public void setBuilding(String building) {
        this.building = building;
    }

    /** 
     * Get the 'street' element value.
     * 
     * @return value
     */
    public String getStreet() {
        return street;
    }

    /** 
     * Set the 'street' element value.
     * 
     * @param street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /** 
     * Get the 'city' element value.
     * 
     * @return value
     */
    public String getCity() {
        return city;
    }

    /** 
     * Set the 'city' element value.
     * 
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /** 
     * Get the 'country' element value.
     * 
     * @return value
     */
    public String getCountry() {
        return country;
    }

    /** 
     * Set the 'country' element value.
     * 
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /** 
     * Get the 'phoneMobile' element value.
     * 
     * @return value
     */
    public String getPhoneMobile() {
        return phoneMobile;
    }

    /** 
     * Set the 'phoneMobile' element value.
     * 
     * @param phoneMobile
     */
    public void setPhoneMobile(String phoneMobile) {
        this.phoneMobile = phoneMobile;
    }

    /** 
     * Get the 'phoneLandLine' element value.
     * 
     * @return value
     */
    public String getPhoneLandLine() {
        return phoneLandLine;
    }

    /** 
     * Set the 'phoneLandLine' element value.
     * 
     * @param phoneLandLine
     */
    public void setPhoneLandLine(String phoneLandLine) {
        this.phoneLandLine = phoneLandLine;
    }

    /** 
     * Get the 'email' element value.
     * 
     * @return value
     */
    public String getEmail() {
        return email;
    }

    /** 
     * Set the 'email' element value.
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
