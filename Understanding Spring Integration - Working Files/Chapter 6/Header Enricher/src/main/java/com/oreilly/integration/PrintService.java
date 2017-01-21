package com.oreilly.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;

public class PrintService {

	public void print(Message<String> message) {
		System.out.println(message.getPayload());
		
		for(Entry<String,Object> entry:message.getHeaders().entrySet()){
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}

}
