package com.packtpub.liverestaurant.service.test;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import org.custommonkey.xmlunit.XMLAssert;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jvnet.mock_javamail.Mailbox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class MailTransportWebServiceIntegrationTest {
	 private static final String expectedResponseContent =  "<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>order-John_Smith_1234</tns:refNumber></tns:placeOrderResponse>";
	
	
    @Autowired
    private WebServiceTemplate webServiceTemplate;
    @Autowired
    private GenericApplicationContext applicationContext;
    @After
    public void clearMailbox() throws Exception {
        Mailbox.clearAll();
    }
    @Test
    public void testWebServiceOnMailTransport() throws Exception {
    	InputStream is = new MailTransportWebServiceIntegrationTest().getClass().getResourceAsStream("placeOrderRequest.xml");
    	StreamSource source = new StreamSource(is);
    	StringResult result = new StringResult();
        
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);
        applicationContext.close();
        XMLAssert.assertXMLEqual("Invalid content received", expectedResponseContent, result.toString());
    }
}
