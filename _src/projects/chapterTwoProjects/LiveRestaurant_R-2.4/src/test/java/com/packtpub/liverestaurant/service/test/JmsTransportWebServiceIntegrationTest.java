package com.packtpub.liverestaurant.service.test;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.InputStream;

import javax.xml.transform.stream.StreamSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;


import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;
import org.junit.runner.RunWith;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class JmsTransportWebServiceIntegrationTest {
	
	 private static final String expectedResponseContent =  "<tns:placeOrderResponse xmlns:tns=\"http://www.packtpub.com/liverestaurant/OrderService/schema\"><tns:refNumber>order-John_Smith_1234</tns:refNumber></tns:placeOrderResponse>";
	
    @Autowired
    private WebServiceTemplate webServiceTemplate;


    public void setWebServiceTemplate(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }

    @Test
    public void testSendReceive() throws Exception {
    	InputStream is = new JmsTransportWebServiceIntegrationTest().getClass().getResourceAsStream("placeOrderRequest.xml");
    	StreamSource source = new StreamSource(is);
        StringResult result = new StringResult();
        webServiceTemplate.sendSourceAndReceiveToResult(source, result);
        XMLAssert.assertXMLEqual("Invalid content received", expectedResponseContent, result.toString());
    }


}
