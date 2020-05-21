package com.anubhab.restservices.hello;

public class UserDetail {
	
	private String firstName;
	private String lasteName;
	private String city;
	
	public UserDetail() { }
	
	public UserDetail(String firstName, String lasteName, String city) {
		this.firstName = firstName;
		this.lasteName = lasteName;
		this.city = city;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLasteName() {
		return lasteName;
	}
	public void setLasteName(String lasteName) {
		this.lasteName = lasteName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "UserDetail [firstName=" + firstName + ", lasteName=" + lasteName + ", city=" + city + "]";
	}
	
}
