package com.packtpub.liverestaurant.service.test;
/**
 * This software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
 */
import static org.springframework.ws.test.server.RequestCreators.withPayload;
import static org.springframework.ws.test.server.ResponseMatchers.payload;
import java.io.InputStream;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.server.MockWebServiceClient;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/WEB-INF/spring-ws-servlet.xml")
public class OrderServiceServerSideIntegrationTest {


    @Autowired
    private GenericApplicationContext applicationContext;
	private static InputStream placeOrderRequest;
	private static InputStream cancelOrderRequest;
	private static InputStream placeOrderResponse;
	private static InputStream cancelOrderRsponse; 
    private MockWebServiceClient wsMockClient; 

	
	  @Before
	  public void createClient() {
		  wsMockClient = MockWebServiceClient.createClient(applicationContext);
		  placeOrderRequest = new OrderServiceServerSideIntegrationTest().getClass().getResourceAsStream("placeOrderRequest.xml");
		  cancelOrderRequest = new OrderServiceServerSideIntegrationTest().getClass().getResourceAsStream("cancelOrderRequest.xml");
		  placeOrderResponse = new OrderServiceServerSideIntegrationTest().getClass().getResourceAsStream("placeOrderResponse.xml");
		  cancelOrderRsponse = new OrderServiceServerSideIntegrationTest().getClass().getResourceAsStream("cancelOrderResponse.xml");
	  }
	@After
	public  void setUpAfterClass()  {

		applicationContext.close();
	}	

	@Test
	public  final void testPlaceOrderRequest() throws Exception {
		Source requestPayload = new StreamSource(placeOrderRequest);
		Source responsePayload = new StreamSource(placeOrderResponse);
	    wsMockClient.sendRequest(withPayload(requestPayload)).
	      andExpect(payload(responsePayload));
	}
	@Test
	public  final void testCancelOrderRequest() throws Exception {
		Source requestPayload = new StreamSource(cancelOrderRequest);
	    Source responsePayload = new StreamSource(cancelOrderRsponse);
	    wsMockClient.sendRequest(withPayload(requestPayload)).
	      andExpect(payload(responsePayload));
		 
		
	}
	
}
