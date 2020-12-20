package com.packtpub.liverestaurant.orderservice;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.xstream.XStreamMarshaller;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.OrderItem;
import com.packtpub.liverestaurant.orderservice.service.OrderService;
import com.sun.syndication.feed.atom.Entry;
import com.sun.syndication.feed.atom.Feed;
import com.sun.syndication.feed.atom.Content;

import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class OrderController
{
	
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private XStreamMarshaller xStreamMarshaller;
	
	@RequestMapping( value="/order/{orderId}", method=RequestMethod.POST,headers="Accept=application/xml" )
	public  @ResponseBody Order placeOrderXml(  @PathVariable String orderId	 ) 
	{
	return orderService.placeOrder(orderId);
	}
	
	@RequestMapping( value="/orderItems", method=RequestMethod.GET , headers="Accept=application/xml")
	public @ResponseBody   List<OrderItem> loadOrderItemsXml() 
	{
		return orderService.listOrderItems();

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/orderJson/{orderId}", headers="Accept=application/json")
	public @ResponseBody Order placeOrderJson(@PathVariable String orderId) {
		Order order=orderService.placeOrder(orderId);
		return order;
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/orderItemsFeed",
			headers="Accept=application/atom+xml")
			public @ResponseBody Feed loadOrderItemsAtom() {
		Feed feed = null;
		try {
			feed= getOrderItemsFeed(orderService.listOrderItems());
		} catch (Exception e) {
			throw new RuntimeException(e); 
		} 
    return feed;
	}
	
	
	
	private  Feed getOrderItemsFeed(List<OrderItem> orderItems) throws XmlMappingException, IOException {
		Feed feed = new Feed();
		feed.setFeedType("atom_1.0");
		feed.setTitle("OrderItems Atom Feed");
		
		List<Entry> entries = new ArrayList<Entry>();
		for(OrderItem orderItem : orderItems) {
			StreamResult result = new StreamResult(new ByteArrayOutputStream());
			
			xStreamMarshaller.marshal(orderItem, result);
			String xmlContent = result.getOutputStream().toString();
			
			Entry entry = new Entry();
			entry.setId(Long.valueOf(orderItem.getId()).toString());
			entry.setTitle(orderItem.getName());
			Content content = new Content();
			content.setType(Content.XML);
			content.setValue(xmlContent);
			
			List<Content> contents = new ArrayList<Content>();
			contents.add(content);
			entry.setContents(contents);
			
			entries.add(entry);
		}
		feed.setEntries(entries);
		return feed;
	}
	
	

}
