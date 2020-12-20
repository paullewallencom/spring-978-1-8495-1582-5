package com.packtpub.liverestaurant.client.test;
/**
 * This software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
 */
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;


public class OrderServiceClient extends WebServiceGatewaySupport  {
	

	 



/*	
	public    Result getStringResult(StreamSource source) {
       
        Result result = new StringResult();
        getWebServiceTemplate().sendSourceAndReceiveToResult(source, result);
        return result;
	}*/
	
	
	public    Result getStringResult(Source source) {
       // StringSource source = new StringSource(xml);
      StringResult result = new StringResult();
        getWebServiceTemplate().sendSourceAndReceiveToResult(source, result);
        return result;
	}
	
	
	



	
	
	
	
	
	
}
