package com.packtpub.liverestaurant.service.client;



import java.util.ArrayList;
import java.util.Calendar;
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






@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderServiceClientTest {
    @Autowired
	OrderService  orderService;
    @Autowired
    private GenericApplicationContext applicationContext;  
	@Before
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
		Order order=new Order();
		order.setRefNumber("123");
		List<FoodItem> items=new ArrayList<FoodItem>();
		FoodItem item1=new FoodItem();
		item1.setType(FoodItemType.BEVERAGES);
		item1.setName("beverage");
		item1.setQuantity(1.0);
		items.add(item1);
		Customer customer=new Customer();
		Name name=new Name();
		name.setFName("fname");
		name.setLName("lname");
		name.setMName("mname");
		customer.setName(name);
		
		Address address=new Address();
		address.setBuilding("building1");
		address.setCity("city1");
		address.setCountry("country1");
		address.setDoorNo("door1");
		address.setEmail("a@b.c");
		address.setPhoneLandLine("1234");
		address.setPhoneMobile("011123");
		address.setStreet("street1");
		customer.setAddressPrimary(address);
		customer.setAddressSecondary(address);

	
		
		FoodItem item2=new FoodItem();
		item2.setType(FoodItemType.SNACKS);
		item2.setName("snack");
		item2.setQuantity(1.0);
		items.add(item2);

		order.setItemList(items);
		order.setCustomer(customer);
	    Calendar calendar = Calendar.getInstance();
		order.setDateSubmitted(calendar.getTime());
		order.setOrderDate(calendar.getTime());
		return order;
	}
	
}
