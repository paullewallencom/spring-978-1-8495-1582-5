package com.packtpub.liverestaurant.service.dao;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MyUserDetailService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		
		return getUserDataFromDao(username);
	}

	private MyUserDetail getUserDataFromDao(String username) {

		/**
		 *Real scenario: find user data from a DAO layer  by userName,
		 * if this user name found, populate  MyUserDetail with its data(username, password,Role, ....).
		 */
		MyUserDetail mydetail=new MyUserDetail(username,"pass",true,true,true,true);
		mydetail.getAuthorities().add(new GrantedAuthorityImpl("ROLE_GENERAL_OPERATOR"));
		
		return mydetail;
		
	}

}
