package com.packtpub.liverestaurant.orderservice.service;

/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;


import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.OrderItem;


/**
* <pre>
* Service implementation for {@link OrderService}
* </pre>
*
* @see OrderService
*
*/
@Service( "orderService" )
public class OrderServiceImpl implements OrderService {
List <OrderItem>items=null;


private List<OrderItem> getOrgerItems(){
	 if(items==null){
		 items=new ArrayList <OrderItem>();
		 items.add(new OrderItem("Berger", "0"));
		 items.add(new OrderItem("Pizza", "1"));
		 items.add(new OrderItem("Sushi", "2"));
		 items.add(new OrderItem("Salad", "3"));
		 
	 }
	 
	
	return items;
}
public Order placeOrder(String orderId) {
	int id=-1;
	   try{
		    id=Integer.valueOf(orderId);
		    if(id>3)throw new RuntimeException("Such order does not exist.");
		}catch(Exception e){
			throw new RuntimeException(e);
		}
      OrderItem item=getOrgerItems().get(id);
		
		return new Order("Order "+item.getName()+" has been placed","Ref:"+orderId,orderId) ;
	}

	public List<OrderItem> listOrderItems() {

		return getOrgerItems();
	}
	


}