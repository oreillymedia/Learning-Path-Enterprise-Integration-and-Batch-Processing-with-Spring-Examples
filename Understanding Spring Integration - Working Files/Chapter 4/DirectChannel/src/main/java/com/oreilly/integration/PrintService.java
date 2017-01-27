package com.oreilly.integration;

import org.springframework.messaging.Message;

public class PrintService {

	public void print(Message<String> message) {
		throw new RuntimeException("This is an error");
		//		System.out.println(message.getPayload());
	}

}
