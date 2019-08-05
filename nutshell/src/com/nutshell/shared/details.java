package com.nutshell.shared;

import java.io.Serializable;

public class details implements Serializable {
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getNews_agency() {
		return news_agency;
	}
	public void setNews_agency(String news_agency) {
		this.news_agency = news_agency;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	String email_id;
	String news_agency;
	int phone;
	String Password;

}
