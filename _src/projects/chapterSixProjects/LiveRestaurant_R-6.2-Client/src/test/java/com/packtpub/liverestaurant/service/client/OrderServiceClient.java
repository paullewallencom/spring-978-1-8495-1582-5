package com.packtpub.liverestaurant.service.client;

import org.apache.log4j.Logger;
import org.springframework.ws.client.core.WebServiceTemplate;




import com.packtpub.liverestaurant.service.OrderService;

public class OrderServiceClient implements OrderService {

    private static final Logger logger = Logger.getLogger(OrderServiceClient.class);
            
    private  WebServiceTemplate webServiceTemplate;

    public OrderServiceClient(WebServiceTemplate webServiceTemplate) {
        this.webServiceTemplate = webServiceTemplate;
    }
    
    @Override
    public boolean cancelOrder(String orderRef) {
        logger.debug("Preparing CancelOrderRequest.....");
        		com.packtpub.liverestaurant.orderService.schema.CancelOrderRequestDocument cancelOrderRequestDocument=		com.packtpub.liverestaurant.orderService.schema.CancelOrderRequestDocument.Factory.newInstance();
       cancelOrderRequestDocument.addNewCancelOrderRequest();
        cancelOrderRequestDocument.getCancelOrderRequest().setRefNumber(orderRef);
       
       

        logger.debug("Invoking Web service Operation[CancelOrder]....");
        		com.packtpub.liverestaurant.orderService.schema.CancelOrderResponseDocument cancelOrderResponseDoc = (		com.packtpub.liverestaurant.orderService.schema.CancelOrderResponseDocument) webServiceTemplate.marshalSendAndReceive(cancelOrderRequestDocument);
       
            
        logger.debug("Has the order cancelled: " + cancelOrderResponseDoc.getCancelOrderResponse().getCancelled());
            
        return  cancelOrderResponseDoc.getCancelOrderResponse().getCancelled();
    }
    

    @Override
    public String placeOrder(	com.packtpub.liverestaurant.orderService.schema.PlaceOrderRequestDocument orderRequestDoc) {
        logger.debug("Preparing PlaceOrderRequest.....");

            
        logger.debug("Invoking Web service Operation[PlaceOrder]....");
        com.packtpub.liverestaurant.orderService.schema.PlaceOrderResponseDocument orderResponseDocumentresponse=(        com.packtpub.liverestaurant.orderService.schema.PlaceOrderResponseDocument) webServiceTemplate.marshalSendAndReceive(orderRequestDoc);
		
                
        logger.debug("Order reference: " + orderResponseDocumentresponse.getPlaceOrderResponse().getRefNumber());
        return orderResponseDocumentresponse.getPlaceOrderResponse().getRefNumber();
    }
}    