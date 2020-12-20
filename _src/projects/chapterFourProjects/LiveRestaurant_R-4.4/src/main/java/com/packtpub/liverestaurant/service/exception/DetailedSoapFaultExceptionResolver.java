package com.packtpub.liverestaurant.service.exception;
/*
* This software is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND.
*/
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerFactoryConfigurationError;

import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultDetailElement;
import org.springframework.ws.soap.server.endpoint.SoapFaultAnnotationExceptionResolver;


public class DetailedSoapFaultExceptionResolver extends
		SoapFaultAnnotationExceptionResolver {

	@Override
	protected void customizeFault(Object endpoint, Exception ex, SoapFault fault) {
		addExceptionStackTraceToFaultDetail(ex, fault);
	}

	private void addExceptionStackTraceToFaultDetail(Exception exc,
			SoapFault fault) throws TransformerFactoryConfigurationError {
		SoapFaultDetail faultDetail = fault.addFaultDetail();
		SoapFaultDetailElement detailElem = faultDetail
				.addFaultDetailElement(new QName(
						"http://www.packtpub.com/liverestaurant/OrderService/schema",
						"stack-trace"));
		detailElem.addText(stackTraceToString(exc));
	}

	private String stackTraceToString(Throwable th) {
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		th.printStackTrace(pw);
		return sw.toString();
	}

}
