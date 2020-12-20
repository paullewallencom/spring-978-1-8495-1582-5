package com.packtpub.liverestaurant.server;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServerStartUp {
	public static void main(String[] args) throws  IOException {
		
    
			ClassPathXmlApplicationContext appContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
			System.out.println(appContext);
			
		
		 char c;
	      // Create a BufferedReader using System.in
	      BufferedReader br = new BufferedReader(new 
	                         InputStreamReader(System.in));
	      System.out.println("Enter any character  to quit.");
	      c = (char) br.read();
	
	      appContext.close();

	}

}
