package com.packtpub.liverestaurant.service.dao;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		return findUserDetailFromDAO(username);
	}	
	private UserDetails  findUserDetailFromDAO(String userName)throws UsernameNotFoundException{
		MyUserDetail mydetail=null; 
		
		/**
		 *Real scenario: Find user-name from  DAO layer, if user found,  get data from the DAO and set MyUserDetail otherwise throw UsernameNotFoundException.
		 */
		if(! userName.equals("MyFirstName MyLastName")){
			throw new UsernameNotFoundException("User name not found");
		}		
	    mydetail=new MyUserDetail(userName,"fetchedPassword",true,true,true,true,new GrantedAuthorityImpl("ROLE_GENERAL_OPERATOR"));
		return mydetail; 
	}
}
