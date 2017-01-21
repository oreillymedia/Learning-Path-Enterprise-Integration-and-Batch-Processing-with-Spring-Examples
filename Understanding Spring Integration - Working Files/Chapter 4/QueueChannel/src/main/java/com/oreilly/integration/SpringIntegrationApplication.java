package com.oreilly.integration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	private PrinterGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws InterruptedException, ExecutionException {

		List<Future<Message<String>>> futures = new ArrayList<Future<Message<String>>>();

		for (int x = 0; x < 10; x++) {
			Message<String> message = MessageBuilder.withPayload("Printing message payload for " + x)
					.setHeader("messageNumber", x).build();
			System.out.println("Sending message " + x);
			futures.add(this.gateway.print(message));
		}

		for (Future<Message<String>> future : futures) {
			System.out.println(future.get().getPayload());
		}

	}

}
