package com.packtpub.liverestaurant.service.test;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

import org.apache.log4j.Logger;
import org.custommonkey.xmlunit.XMLAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

import com.packtpub.liverestaurant.service.endpoint.SimplePlayLoadEndPoint;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("applicationContext.xml")
public class XMPPTransportWebServiceIntegrationTest {
	static Logger logger = Logger.getLogger(XMPPTransportWebServiceIntegrationTest.class);
    private final String requestContent = "<?xml version='1.0' encoding='UTF-8'?><placeOrderRequest xmlns='http://www.packtpub.com/liverestaurant/OrderService/schema'><id>9999</id></placeOrderRequest>";
    @Autowired
    private WebServiceTemplate webServiceTemplate;

    @Autowired
    private GenericApplicationContext applicationContext;
    @Test
    public void testWebServiceOnXMPPTransport() throws Exception {
        StringResult result = new StringResult();
        StringSource sc=new StringSource(requestContent);
        webServiceTemplate.sendSourceAndReceiveToResult(sc, result);
        XMLAssert.assertXMLEqual("Invalid content received", requestContent, result.toString());
       
        applicationContext.close();
    }
}
