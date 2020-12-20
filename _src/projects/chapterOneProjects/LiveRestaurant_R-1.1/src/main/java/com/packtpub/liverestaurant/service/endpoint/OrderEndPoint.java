/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
package com.packtpub.liverestaurant.service.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.Namespace;
import org.jdom.output.XMLOutputter;
import org.jdom.xpath.XPath;

import com.packtpub.liverestaurant.service.OrderService;


@Endpoint
public class OrderEndPoint {
	private static final Log logger = LogFactory.getLog(OrderEndPoint.class);
    private static final String NAMESPACE_URI = "http://www.packtpub.com/liverestaurant/OrderService/schema";
    private XPath refNumberExpression;
    private XPath typeExpression;
    private XPath nameExpression;
    private XPath quantityExpression;
    private OrderService orderService;

    @Autowired
    public OrderEndPoint(OrderService orderService) throws JDOMException {
        this.orderService = orderService;
       Namespace namespace = Namespace.getNamespace("QOrder", NAMESPACE_URI);

       refNumberExpression = XPath.newInstance("//QOrder:refNumber");
       refNumberExpression.addNamespace(namespace);
       
       nameExpression = XPath.newInstance("concat(//QOrder:fName,' ',//QOrder:lName)");
       nameExpression.addNamespace(namespace);
       
       typeExpression = XPath.newInstance("//QOrder:type");
       typeExpression.addNamespace(namespace);
       
       quantityExpression = XPath.newInstance("//QOrder:quantity");
       quantityExpression.addNamespace(namespace);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "placeOrderRequest")
    public Element handleOrderRequest(@RequestPayload Element placeOrderRequest) throws Exception {
       String name=nameExpression.valueOf(placeOrderRequest);
       String refNumber = refNumberExpression.valueOf(placeOrderRequest);
      
       
        String repText= orderService.placeOrder(name, refNumber);
        
        Namespace resNamespace = Namespace.getNamespace("",	NAMESPACE_URI);
        Element root = new Element("placeOrderResponse", resNamespace);
        Element echoResponse = new Element("refNumber", resNamespace);
        echoResponse.setText(repText);
        root.addContent(echoResponse);
        Document doc = new Document(root);


        return doc.getRootElement();
    }
}
