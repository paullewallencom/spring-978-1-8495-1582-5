package com.packtpub.liverestaurant.orderservice.client;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.List;

import junit.framework.Assert;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import com.packtpub.liverestaurant.domain.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderServiceClientTest {
    @Autowired
	OrderClient  orderClient;
    @Autowired
    private GenericApplicationContext applicationContext;


   

	@Before
	public   void setUpBefore() {

	}
	@After
	public  void setUpAfter()  {

		applicationContext.close();
	}	
	
	@Test
	public  final void testPlaceOrder() throws Exception {
	
		Order order = orderClient.placeOrder("1");
		Assert.assertEquals(order.getOrderItemId(), "1");
	}
	
	@Test
	public  final void testListOrder() throws Exception {
	
		List list = orderClient.loadOrderItems();
		Assert.assertEquals(list.size(),4);
	}
}
