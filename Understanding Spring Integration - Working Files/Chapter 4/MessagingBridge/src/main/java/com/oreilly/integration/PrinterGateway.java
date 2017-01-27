package com.oreilly.integration;

import org.springframework.messaging.Message;

public interface PrinterGateway {

	public void print(Message<?> message);
	
}
