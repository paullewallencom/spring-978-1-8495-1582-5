package com.packtpub.liverestaurant.orderservice;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
import com.packtpub.liverestaurant.domain.Order;
import com.packtpub.liverestaurant.domain.OrderItem;
import com.packtpub.liverestaurant.orderservice.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.POST)
	public ModelAndView placeOrder(@PathVariable String orderId) {
		Order order = orderService.placeOrder(orderId);
		ModelAndView mav = new ModelAndView("orderXmlView",
				BindingResult.MODEL_KEY_PREFIX + "order", order);
		return mav;
	}

	@RequestMapping(value = "/orderItems", method = RequestMethod.GET)
	public ModelAndView loadOrderItems() {
		List<OrderItem> orderItems = orderService.listOrderItems();
		ModelAndView modelAndView = new ModelAndView("orderXmlView",
				BindingResult.MODEL_KEY_PREFIX + "orderItem", orderItems);
		return modelAndView;
	}

}
