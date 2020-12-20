package com.packtpub.liverestaurant.marshaller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

/*import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Namespace;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;*/

import org.dom4j.DocumentHelper;
import org.dom4j.io.DOMReader;
import org.dom4j.io.DocumentResult;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.UnmarshallingFailureException;
import org.springframework.oxm.XmlMappingException;
import com.packtpub.liverestaurant.domain.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ServerCustomMarshaller implements Marshaller, Unmarshaller {
	private List registeredClassNames;
	@Override
	public boolean supports(Class<?> arg0) {
		return  registeredClassNames.contains(arg0.getSimpleName())  ;	}

	@Override
	public Object unmarshal(Source source) throws IOException,
			XmlMappingException {
		 PlaceOrderRequest placeOrderRequest=new PlaceOrderRequest();
		  Order order=new Order();	
	           
	            try {
	            	DOMSource in = (DOMSource)source;	            
	            	org.dom4j.Document document = org.dom4j.DocumentHelper.parseText( xmlToString(source) );	            	
	            	org.dom4j.Element orderRequestElem=document.getRootElement();
	            	org.dom4j.Node orderNode=orderRequestElem.selectSingleNode("//ns:order");
	        		order.setRefNumber(orderNode.valueOf("@refNumber"));
	        		order.setCustomerfName(orderNode.valueOf("@customerfName"));
	        		order.setCustomerlName(orderNode.valueOf("@customerlName"));
	        		order.setCustomerTel(orderNode.valueOf("@customerTel"));
	        		try {
						order.setOrderDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderNode.valueOf("@dateSubmitted")));
						order.setDateSubmitted(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(orderNode.valueOf("@orderDate")));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	        		
	        		placeOrderRequest.setOrder(order);
	        		List orderItems=orderNode.selectNodes("//ns:order/ns:item");
	        		FoodItem item=null;

	        		List<FoodItem> foodItemsList=new ArrayList<FoodItem>();
	        		Iterator iter=orderItems.iterator();
	        		   while(iter.hasNext()){
	        			   item=new FoodItem();
	        			   org.dom4j.Element element=(org.dom4j.Element)iter.next();
	        		       item.setName(element.valueOf("@name"));
	        		       item.setType(FoodItemType.valueOf(element.valueOf("@type")));
	        		       item.setQuantity(Double.valueOf(element.valueOf("@quantity")));
	        		       foodItemsList.add(item);
	        		   }
	        		   order.setItemList(foodItemsList);
	                }catch (Exception e) {
	                throw new UnmarshallingFailureException(e.getMessage(), e);
	            } finally {
	              // in.close();
	            }
	            placeOrderRequest.setOrder(order);
	        return placeOrderRequest;
	}

	@Override
	public void marshal(Object bean, Result result)   throws IOException,
	XmlMappingException
			 {
		XMLStreamWriter writer=null; 
	        PlaceOrderResponse placeOrderResponse=(PlaceOrderResponse) bean;
		 try {
			 DOMResult out = (DOMResult)result;
				 writer = XMLOutputFactory.newInstance().createXMLStreamWriter(out);
				writer.writeStartElement("ns", "placeOrderResponse", "http://www.packtpub.com/LiveRestaurant/OrderService/schema");
				writer.writeAttribute( "refNumber", placeOrderResponse.getRefNumber());
				writer.writeEndElement();
				writer.flush();
         } catch (Exception e) {
 			e.printStackTrace();
 		} finally{
 			try{writer.close();}catch (Exception e) {}
 		}
	}
	public List getRegisteredClassNames() {
	return registeredClassNames;
}
public void setRegisteredClassNames(List registeredClassNames) {
	this.registeredClassNames = registeredClassNames;
}

public String xmlToString(Source source) {
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
