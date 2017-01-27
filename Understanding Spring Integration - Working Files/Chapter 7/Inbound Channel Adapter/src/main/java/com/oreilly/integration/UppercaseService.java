package com.oreilly.integration;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UppercaseService {

	public String execute(Person person){
		
		try {
			TimeUnit.SECONDS.sleep(new Random().nextInt(10));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return (person.getFirstName() + " " + person.getLastName()).toUpperCase();
		
	}
	
}
