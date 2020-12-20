package com.packtpub.liverestaurant.service.dao;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserDetail implements UserDetails {
	private String userName;
	String password;
	private boolean isAccountNonExpired;
	private boolean isAccountNonLocked;
	private boolean isCredentialsNonExpired; 
	private boolean isEnabled ;
	
	public  Collection<GrantedAuthority> roles =    new ArrayList<GrantedAuthority>();
 
	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		
		return roles;
	}
	MyUserDetail(String userName,String password,boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired , boolean isEnabled,GrantedAuthorityImpl grantedAuthorityImpl ){
		this.userName=userName;
		this.password=password;
		this.isAccountNonExpired=isAccountNonExpired;
		this.isAccountNonLocked=isAccountNonLocked;
		this.isCredentialsNonExpired=isCredentialsNonExpired;
		this.isEnabled=isEnabled;
		this.roles.add(grantedAuthorityImpl);
		
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
