package com.bean;

public class User {
	private String username;
	private String password;
	private String address;
	private boolean receivePaper;
	private String [] favoriteFrameworks;
	private String gender;
	private String paymentType;
	private String country;
	
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String[] getFavoriteFrameworks() {
		return favoriteFrameworks;
	}
	public void setFavoriteFrameworks(String[] favoriteFrameworks) {
		this.favoriteFrameworks = favoriteFrameworks;
	}
	public boolean isReceivePaper() {
		return receivePaper;
	}
	public void setReceivePaper(boolean receivePaper) {
		this.receivePaper = receivePaper;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
