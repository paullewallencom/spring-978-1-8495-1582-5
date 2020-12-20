
package com.packtpub.liverestaurant.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Order implements java.io.Serializable
{
    private String refNumber;
    private String customerfName;
    private String customerlName;
    private String customerTel;
    private Date dateSubmitted;
    private Date orderDate;
    private List<FoodItem> itemList = new ArrayList<FoodItem>();

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

    /** 
     * Get the 'customerfName' element value.
     * 
     * @return value
     */
    public String getCustomerfName() {
        return customerfName;
    }

    /** 
     * Set the 'customerfName' element value.
     * 
     * @param customerfName
     */
    public void setCustomerfName(String customerfName) {
        this.customerfName = customerfName;
    }

    /** 
     * Get the 'customerlName' element value.
     * 
     * @return value
     */
    public String getCustomerlName() {
        return customerlName;
    }

    /** 
     * Set the 'customerlName' element value.
     * 
     * @param customerlName
     */
    public void setCustomerlName(String customerlName) {
        this.customerlName = customerlName;
    }

    /** 
     * Get the 'customerTel' element value.
     * 
     * @return value
     */
    public String getCustomerTel() {
        return customerTel;
    }

    /** 
     * Set the 'customerTel' element value.
     * 
     * @param customerTel
     */
    public void setCustomerTel(String customerTel) {
        this.customerTel = customerTel;
    }

    /** 
     * Get the 'dateSubmitted' element value.
     * 
     * @return value
     */
    public Date getDateSubmitted() {
        return dateSubmitted;
    }

    /** 
     * Set the 'dateSubmitted' element value.
     * 
     * @param dateSubmitted
     */
    public void setDateSubmitted(Date dateSubmitted) {
        this.dateSubmitted = dateSubmitted;
    }

    /** 
     * Get the 'orderDate' element value.
     * 
     * @return value
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /** 
     * Set the 'orderDate' element value.
     * 
     * @param orderDate
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /** 
     * Get the list of 'items' element items.
     * 
     * @return list
     */
    public List<FoodItem> getItemList() {
        return itemList;
    }

    /** 
     * Set the list of 'items' element items.
     * 
     * @param list
     */
    public void setItemList(List<FoodItem> list) {
        itemList = list;
    }
}
