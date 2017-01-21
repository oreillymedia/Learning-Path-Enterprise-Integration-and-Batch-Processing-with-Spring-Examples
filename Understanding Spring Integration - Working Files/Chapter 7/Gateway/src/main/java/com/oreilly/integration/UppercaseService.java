package com.oreilly.integration;

public class UppercaseService {

	public String execute(Person person){
		return (person.getFirstName() + " " + person.getLastName()).toUpperCase();
	}
	
}
