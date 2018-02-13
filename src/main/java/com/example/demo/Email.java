package com.example.demo;

public class Email {
	private String to;
	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	private String body;
	
	public Email() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", body=" + body + "]";
	}

	public Email(String to, String body) {
		
		this.to = to;
		this.body = body;
	}
	

}
