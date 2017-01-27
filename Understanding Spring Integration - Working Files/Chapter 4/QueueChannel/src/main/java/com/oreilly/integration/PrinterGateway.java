package com.oreilly.integration;

import java.util.concurrent.Future;

import org.springframework.messaging.Message;

public interface PrinterGateway {

	public Future<Message<String>> print(Message<?> message);
}
