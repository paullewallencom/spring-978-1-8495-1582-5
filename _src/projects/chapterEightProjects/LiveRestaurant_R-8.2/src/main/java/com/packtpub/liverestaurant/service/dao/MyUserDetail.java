package com.packtpub.liverestaurant.service.dao;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetail implements UserDetails {
	
	private String password;
	private String userName;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired;
	private boolean isEnabled;
	
	
	
	
	public static  Collection<GrantedAuthority> authority =
        new ArrayList<GrantedAuthority>();
 

  public MyUserDetail( String userName, String password,boolean isAccountNonExpired, boolean isAccountNonlocked,boolean isCredentialsNonExpired, boolean isEnabled){
	  this.userName=userName;
	  this.password=password;
	  this.isAccountNonExpired=isAccountNonExpired;
	  this.isAccountNonLocked=isAccountNonlocked;
	  this.isCredentialsNonExpired=isCredentialsNonExpired;
	  this.isEnabled=isEnabled;
	  
	  
  }

  

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		
		return authority;
	}

	@Override
	public String getPassword() {
		
		return password;
	}
    
	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return isAccountNonExpired;
	}
    
	@Override
	public boolean isAccountNonLocked() {
		
		return isAccountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		
		return isCredentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {
		
		return isEnabled;
	}

}
