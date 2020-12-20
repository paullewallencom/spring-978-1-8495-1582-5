package com.packtpub.liverestaurant.service.client.test;


import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.packtpub.liverestaurant.orderService.schema.PlaceOrderRequestDocument;
import com.packtpub.liverestaurant.service.OrderService;

public class OrderServiceClientTest {

    private static ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/applicationContext.xml");


    @Test
    public void testCancelOrder() {
        OrderService client = (OrderService) context.getBean("OrderServiceClient");
        boolean isCancelled = client.cancelOrder("Ref-2010-9-15-0.8432452204897198");
        Assert.assertTrue(isCancelled);
    }

@Test
    public void testPlaceOrder() {
        OrderService client = (OrderService) context.getBean("OrderServiceClient");
       
        PlaceOrderRequestDocument orderRequestDocument = PlaceOrderRequestDocument.Factory.newInstance();
        orderRequestDocument.addNewPlaceOrderRequest();
        orderRequestDocument.getPlaceOrderRequest().addNewOrder().setRefNumber("1234567");
        
        
        Assert.assertTrue( client.placeOrder(orderRequestDocument).length()>0);
    }

   

	
}