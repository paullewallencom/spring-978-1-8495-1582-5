package com.packtpub.liverestaurant.service.client;



import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.Assert;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.packtpub.liverestaurant.domain.Address;
import com.packtpub.liverestaurant.domain.Customer;
import com.packtpub.liverestaurant.domain.FoodItem;
import com.packtpub.liverestaurant.domain.FoodItemType;
import com.packtpub.liverestaurant.domain.Name;
import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;
import com.packtpub.liverestaurant.service.OrderService;
import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderServiceClientTest {
 
    @Autowired
    private GenericApplicationContext applicationContext;  

    @Autowired
	OrderService  orderService;
	@After
	public  void setUpAfter()  {
		applicationContext.close();
	}	
	
	@Test
	public  final void testPlaceOrder() throws Exception {
	      PlaceOrderRequest orderRequest = new PlaceOrderRequest();
	      orderRequest.setOrder(getDummyOrder());
	     

          PlaceOrderResponse orderResponse = orderService.placeOrder(orderRequest);
		Assert.assertTrue(orderResponse.getRefNumber().indexOf("1234")>0);
	}
	
	
	 private Order getDummyOrder() {
	        Order order = new Order();
	        order.setRefNumber("123456");
	        order.setCustomer(prepareCustomer());
	        order.setDateSubmitted(prepareDate(2010, 10, 15, 8, 00, 00));
	        order.setOrderDate(prepareDate(2010, 10, 15, 12, 00, 00));
	        order.getItems().addAll(prepareOrderItems());
	        return order;
	    }

	    private List<FoodItem> prepareOrderItems() {
	        List<FoodItem> items = new ArrayList<FoodItem>(5);
	        items.add(prepareFoodItem("Vegetable Thali",

	FoodItemType.MEALS, 2));
	        items.add(prepareFoodItem("Kheer/ Palpayasam",

	FoodItemType.DESSERTS, 4));
	        items.add(prepareFoodItem("Fresh Orange Juice",

	FoodItemType.JUICES, 1));
	        items.add(prepareFoodItem("Fresh Carrot Juice",

	FoodItemType.JUICES, 1));
	        items.add(prepareFoodItem("Sweet Corn Soup",

	FoodItemType.STARTERS, 2));
	        return items;
	    }

	    private XMLGregorianCalendarImpl prepareDate(int year, int month, int date, int hour, int minute, int second) {
	        GregorianCalendar calendar = new GregorianCalendar();
	        calendar.set(Calendar.YEAR, year);
	        calendar.set(Calendar.MONTH, month);
	        calendar.set(Calendar.DAY_OF_MONTH, date);
	        calendar.set(Calendar.HOUR_OF_DAY, hour);
	        calendar.set(Calendar.MINUTE, minute);
	        calendar.set(Calendar.SECOND, second);
	        return new XMLGregorianCalendarImpl(calendar);
	    }

	    private FoodItem prepareFoodItem(String name, FoodItemType type,
	            double quantity) {
	        FoodItem item = new FoodItem();
	        item.setName(name);
	        item.setType(type);
	        item.setQuantity(quantity);
	        return item;
	    }

	    private Customer prepareCustomer() {
	        Customer customer = new Customer();
	        customer.setName(prepareCustomerName());
	        customer.setAddressPrimary(prepareAddress("123", "My Office Building",
	                "My Office Street", "Dubai", "United Arab Emirates",
	                "0097150xxxxxxx", "009714xxxxxxx", "shameer@mycompany.com"));
	        customer.setAddressSecondary(prepareAddress("234", "My Home Building",
	                "My Home Street", "Dubai", "United Arab Emirates",
	                "0097150xxxxxxx", "009714xxxxxxx", "shameer@myhome.com"));
	        return customer;
	    }

	    private Name prepareCustomerName() {
	       
	        Name name = new Name();
	        name.setLName("Shameer");
	        name.setFName("Kunjumohamed");
	        return name;
	    }

	    private Address prepareAddress(String doorNo, String building,
	            String street, String city, String country, String phoneMobile,
	            String phoneLandline, String email) {
	       
	        Address address = new Address();
	        address.setDoorNo(doorNo);
	        address.setBuilding(building);
	        address.setStreet(street);
	        address.setCity(city);
	        address.setCountry(country);
	        address.setPhoneMobile(phoneMobile);
	        address.setPhoneLandLine(phoneLandline);
	        address.setEmail(email);
	        return address;
	    }
	
}
