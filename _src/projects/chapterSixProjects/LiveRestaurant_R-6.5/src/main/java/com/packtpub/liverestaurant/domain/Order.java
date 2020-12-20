
package com.packtpub.liverestaurant.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.quigley.moose.mapping.provider.annotation.XML;
import com.quigley.moose.mapping.provider.annotation.XMLField;
import com.quigley.moose.mapping.provider.annotation.XMLList;

@XML(name="order")
public class Order
{
	@XMLField(name="refNumber")
    private String refNumber;
	@XMLField(name="customer")
    private Customer customer;
	@XMLField(name="dateSubmitted")
    private Date dateSubmitted;
	@XMLField(name="orderDate")
    private Date orderDate;
	@XMLList(name="itemList", elementName="foodItem")
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
     * Get the 'customer' element value.
     * 
     * @return value
     */
    public Customer getCustomer() {
        return customer;
    }

    /** 
     * Set the 'customer' element value.
     * 
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
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
