package com.oreilly.integration;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

public class PrintService {

	public Message<String> print(Message<String> message) {
		System.out.println(message.getPayload());
		int messageNumber = (int) message.getHeaders().get("messageNumber");
		return MessageBuilder.withPayload("Sending a reply for message " + messageNumber).build();
	}

}
