package com.packtpub.liverestaurant.domain;

import java.io.Serializable;


public class OrderItem  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 229160746046699088L;
	protected String name;
	protected String id;

	public String getId() {
		return id;
	}



	public OrderItem(String name,String id) {
		this.name=name;
		this.id=id;
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	

}
