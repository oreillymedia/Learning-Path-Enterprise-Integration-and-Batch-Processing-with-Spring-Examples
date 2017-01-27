package com.oreilly.integration;

public class PersonRegistrationService {

	public void registerEmail(Person person){
		System.out.println("Email created for: " + person.getFirstName());
	}
}
