package com.packtpub.liverestaurant.client.test;
/**
 * This software is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
 */
import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.RequestMatchers.validPayload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.test.client.MockWebServiceServer;
import org.springframework.xml.transform.StringSource;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/client-integration-test.xml")
public class ClientSideIntegrationTest {

	
	
	@Autowired
    private OrderServiceClient client;

    private MockWebServiceServer mockServer;
	private static InputStream placeOrderRequest;
	private static InputStream placeOrderResponse;
	private static InputStream cancelOrderRequestWrong;

    @Before
    public void createServer() throws Exception {
        mockServer = MockWebServiceServer.createServer(client);
        placeOrderRequest = new ClientSideIntegrationTest().getClass().getResourceAsStream("placeOrderRequest.xml");
        placeOrderResponse = new ClientSideIntegrationTest().getClass().getResourceAsStream("placeOrderResponse.xml");
        cancelOrderRequestWrong = new ClientSideIntegrationTest().getClass().getResourceAsStream("cancelOrderRequestWrong.xml");
    }


    
    
     @Test
    public void testExpectedRequestResponse() throws Exception {

         Source requestPayload = new StringSource(getStringFromInputStream(placeOrderRequest));
         Source responsePayload = new StringSource(getStringFromInputStream(placeOrderResponse));
         mockServer.expect(payload(requestPayload)).andRespond(withPayload(responsePayload));
         Result result = client.getStringResult(requestPayload);
   	     XMLAssert.assertXMLEqual("Invalid content received", xmlToString(responsePayload), result.toString()); 
   	     mockServer.verify();
    }
    
     @Test
     public void testSchema() throws Exception {
     	Resource schema=new FileSystemResource("orderService.xsd");
     	mockServer.expect(validPayload(schema)); 
        client.getStringResult(new StreamSource(placeOrderRequest));
         mockServer.verify();
     }
     
     @Test(expected = AssertionError.class) 
     public void testSchemaWithWrongRequest() throws Exception {
     	Resource schema=new FileSystemResource("orderService.xsd");
     	mockServer.expect(validPayload(schema)); 
        client.getStringResult(new StringSource(getStringFromInputStream(cancelOrderRequestWrong)));
        mockServer.verify();
     }
    
 	public  String getStringFromInputStream (InputStream is) 
    throws IOException {
		BufferedInputStream bis = new BufferedInputStream(is);
	    ByteArrayOutputStream buf = new ByteArrayOutputStream();
	    int result = bis.read();
	    while(result != -1) {
	      byte b = (byte)result;
	      buf.write(b);
	      result = bis.read();
	    }        
	    return buf.toString();



}
    private static String xmlToString(Source source) {
		try {
			StringWriter stringWriter = new StringWriter();
			Result result = new StreamResult(stringWriter);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			transformer.transform(source, result);
			return stringWriter.getBuffer().toString();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
		return null;
	}

    
    

} 