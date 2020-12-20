package com.packtpub.liverestaurant.service.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT, 
		faultStringOrReason = "Invalid Order Request: Request message incomplete")
public class InvalidOrderRequestException extends Exception {

	public InvalidOrderRequestException(String message) {
		super(message);
	}
}
