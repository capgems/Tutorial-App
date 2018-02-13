package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.JmsListener;

@Configuration
public class Reciever {

	@JmsListener(destination ="mailbox" , containerFactory="myfactory")
	public void recieveMessage(Email email){
		System.out.println("Email Recieved------>"+ email.toString());
	}
	

	@JmsListener(destination ="DbChecks" , containerFactory="myfactory")
	public void recieveMessage1(Email email){
		System.out.println("Email Recieved------>"+ email.toString());
	}
	
}
