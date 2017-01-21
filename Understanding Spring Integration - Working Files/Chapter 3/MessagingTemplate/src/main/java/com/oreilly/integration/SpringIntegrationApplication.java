package com.oreilly.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessagingTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	@Qualifier("inputChannel")
	private DirectChannel inputChannel;

	
	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) {

		
		Message<String> message = MessageBuilder.withPayload("Hello World, from the builder pattern")
				.setHeader("newHeader", "newHeaderValue").build();
	
		MessagingTemplate template = new MessagingTemplate();
		Message returnMessage = template.sendAndReceive(inputChannel, message);
		System.out.println(returnMessage.getPayload());
		
		
		
		
		
		
	}
	

}
