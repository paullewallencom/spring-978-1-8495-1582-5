package com.packtpub.liverestaurant.domain;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias( "order" )
public class Order {

	protected String message;
	protected String ref;
	protected String orderItemId;

	

	public Order(String message, String ref, String orderItemId) {
		super();
		this.message = message;
		this.ref = ref;
		this.orderItemId = orderItemId;
	}


	public String getOrderItemId() {
		return orderItemId;
	}


	public void setOrderItemId(String orderItemId) {
		this.orderItemId = orderItemId;
	}


	public String getRef() {
		return ref;
	}


	public void setRef(String ref) {
		this.ref = ref;
	}

	public Order() {
		// TODO Auto-generated constructor stub
	}

	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
