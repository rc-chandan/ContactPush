/**
 * 
 */
package com.androidzippers.contactpush.bean;

/**
 * @author Chandan
 *
 */
public class ContactPushUser {
	private String name, phone, email, password;

	public String getName() {
		return name;
	}
	
	public ContactPushUser(){}

	public ContactPushUser(String name, String phone, String email,
			String password) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
