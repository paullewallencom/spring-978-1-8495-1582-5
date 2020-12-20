package com.packtpub.liverestaurant.domain;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias( "orderItem" )
public class OrderItem {

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
