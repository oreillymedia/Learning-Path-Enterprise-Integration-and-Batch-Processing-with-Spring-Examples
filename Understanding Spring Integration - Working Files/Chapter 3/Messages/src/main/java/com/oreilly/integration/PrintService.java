package com.oreilly.integration;

import java.util.Map.Entry;

import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

public class PrintService {

	public void print(Message<String> message){
		MessageHeaders headers = message.getHeaders();
		
		for(Entry<String,Object> entry:headers.entrySet()){
			System.out.println(entry.getKey());
			System.out.println(entry.getValue());
		}
		
		System.out.println(message.getPayload());
	}
}
