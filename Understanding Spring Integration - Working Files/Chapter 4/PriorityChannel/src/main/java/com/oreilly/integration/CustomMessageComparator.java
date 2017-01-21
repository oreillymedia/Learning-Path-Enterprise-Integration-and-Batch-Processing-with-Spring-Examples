package com.oreilly.integration;

import java.util.Comparator;

import org.springframework.messaging.Message;

public class CustomMessageComparator implements Comparator<Message<String>> {

	@Override
	public int compare(Message<String> message, Message<String> message2) {
		String payload = message.getPayload();
		String payload2 = message2.getPayload();
		 boolean isPayloadEven = Integer.valueOf(payload.substring(payload.length() - 1)) % 2 == 0;
		 boolean isPayload2Even = Integer.valueOf(payload2.substring(payload2.length() - 1)) % 2 == 0;
		 
		 if((isPayloadEven && isPayload2Even) || (!isPayloadEven && !isPayload2Even) ){
			 return 0;
		 }else if(isPayloadEven){
			 return -1;
		 }else{
			 return 1;
		 }
	}

}
