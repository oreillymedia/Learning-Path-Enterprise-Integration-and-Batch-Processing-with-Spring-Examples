package com.oreilly.integration;

public class PersonDirectoryService {

	public Person findNewPeople(){
		System.out.println("Inbound Adapter has polled this service.");
		return new Person("Jan", "Doe");
	}
}
