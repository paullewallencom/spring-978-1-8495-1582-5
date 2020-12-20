/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/

package com.packtpub.liverestaurant.service;

import java.io.InputStream;

import com.packtpub.liverestaurant.service.endpoint.OrderEndPoint;
import com.packtpub.liverestaurant.service.OrderService;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import static org.easymock.EasyMock.*;

public class OrderEndpointTest {

    private Document placeOrderRequest;
    private Document placeOrderResponse;

    private OrderEndPoint endpoint;

    private OrderService serviceMock;




    @Before
    public void setUp() throws Exception {
        serviceMock = createMock(OrderService.class);
        SAXBuilder builder = new SAXBuilder();
        InputStream is = getClass().getResourceAsStream("placeOrderRequest.xml");
        try {
        	placeOrderRequest = builder.build(is);
        }
        finally {
            is.close();
        }

        try {
        	is = getClass().getResourceAsStream("placeOrderResponse.xml");
        	placeOrderResponse = builder.build(is);
        }
        finally {
            is.close();
        }
        
        endpoint = new OrderEndPoint(serviceMock);
       
    }

    @Test
    public void orderRequest() throws Exception {
    	expect(serviceMock.placeOrder("John Smith", "9999")).andReturn("order-John Smith_9999");
    	

        replay(serviceMock);
        Element orderResponseElem=endpoint.handleOrderRequest(placeOrderRequest.getRootElement());
        Assert.assertEquals("Invalid namespace",placeOrderResponse.getRootElement().getNamespaceURI(), orderResponseElem.getNamespaceURI());
        
       
        
        String  realRefNumber = ((Element) orderResponseElem.getChildren().get(0)).getText();
        String  expectedRefNumber = ((Element) placeOrderResponse.getRootElement().getChildren().get(0)).getText();
        Assert.assertEquals("Invalid content",expectedRefNumber, realRefNumber );        
        verify(serviceMock);
    }


}
