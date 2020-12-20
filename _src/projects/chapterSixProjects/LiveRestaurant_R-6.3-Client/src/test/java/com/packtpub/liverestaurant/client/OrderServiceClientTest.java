package com.packtpub.liverestaurant.client;




import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;





import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;



import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import com.packtpub.liverestaurant.domain.Address;
import com.packtpub.liverestaurant.domain.CancelOrderRequest;
import com.packtpub.liverestaurant.domain.CancelOrderResponse;
import com.packtpub.liverestaurant.domain.Customer;
import com.packtpub.liverestaurant.domain.FoodItem;
import com.packtpub.liverestaurant.domain.FoodItemType;
import com.packtpub.liverestaurant.domain.Name;
import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.PlaceOrderRequest;
import com.packtpub.liverestaurant.domain.PlaceOrderResponse;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class OrderServiceClientTest {
	

	
	@Autowired
    private WebServiceTemplate webServiceTemplate;
	




    @Test
	public   void testHandleCancelOrderRequest() throws Exception {
    	CancelOrderRequest cancelOrderRequest=new CancelOrderRequest();
    	cancelOrderRequest.setRefNumber("12345");
    	CancelOrderResponse cancelOrderResponse=(CancelOrderResponse) webServiceTemplate.marshalSendAndReceive(cancelOrderRequest);
    	Assert.assertTrue(cancelOrderResponse.isCancelled() );

	}
    
    @Test
	public   void testHandleOrderRequest() throws Exception {
    	
    	Order order = getDummyOrder();
    	PlaceOrderRequest placeOrderRequest=new PlaceOrderRequest();
    	placeOrderRequest.setOrder(order);
    	PlaceOrderResponse placeOrderResponse=(PlaceOrderResponse) webServiceTemplate.marshalSendAndReceive(placeOrderRequest);
    	Assert.assertTrue(placeOrderResponse.getRefNumber().length()>0);
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
