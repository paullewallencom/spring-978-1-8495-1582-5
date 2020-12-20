package com.packtpub.liverestaurant.service.exception;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CLIENT, 
		faultStringOrReason = "Invalid Order Request: Request message incomplete")
public class InvalidOrderRequestException extends Exception {

	public InvalidOrderRequestException() {
		this("Invalid Order Request");
	}

	public InvalidOrderRequestException(String message) {
		super(message);
	}
}
