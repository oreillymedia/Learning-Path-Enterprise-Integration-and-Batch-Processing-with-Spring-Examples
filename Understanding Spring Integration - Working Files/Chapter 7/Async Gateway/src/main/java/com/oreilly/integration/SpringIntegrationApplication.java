package com.oreilly.integration;

import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@SpringBootApplication
@Configuration
@ImportResource("integration-context.xml")
public class SpringIntegrationApplication implements ApplicationRunner {

	@Autowired
	private EnhancedPrinterGateway gateway;

	public static void main(String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments arg0) throws InterruptedException, ExecutionException {
		Person[] payloads = { new Person("Kevin", "Bowersox"), new Person("John", "Doe") };
		for (int x = 0; x < payloads.length; x++) {
			
			System.out.println("Invoking the gateway method");
			
			ListenableFuture<String> future = this.gateway.uppercase(payloads[x]);
			future.addCallback(new ListenableFutureCallback<String>(){

				@Override
				public void onSuccess(String result) {
					System.out.println("Invoking the success callback");
					System.out.println(result);
				}

				@Override
				public void onFailure(Throwable ex) {
				}
				
			});
			
//			System.out.println(returnMessage);
		}
	}

}
