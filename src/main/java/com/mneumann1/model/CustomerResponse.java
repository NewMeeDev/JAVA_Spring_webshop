package com.mneumann1.model;

public class CustomerResponse {
	
	private String id;
	private String firstName;
	private String lastName;
	private String eMail;
	
	public CustomerResponse(String id, String firstName, String lastName, String eMail) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String geteMail() {
		return eMail;
	}

}
