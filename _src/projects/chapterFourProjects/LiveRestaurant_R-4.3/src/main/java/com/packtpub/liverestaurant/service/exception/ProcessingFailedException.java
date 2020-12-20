package com.packtpub.liverestaurant.service.exception;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.SERVER, 
		faultStringOrReason = "Database server under maintenance, please try after some time.")
public class ProcessingFailedException extends Exception {
	public ProcessingFailedException(String message) {
		super(message);
	}
}
