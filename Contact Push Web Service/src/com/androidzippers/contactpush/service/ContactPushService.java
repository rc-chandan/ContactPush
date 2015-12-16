/**
 * 
 */
package com.androidzippers.contactpush.service;

import com.androidzippers.contactpush.bean.ContactPushUser;
import com.androidzippers.contactpush.dao.ContactPushDao;

/**
 * @author Chandan Kumar
 *
 */
public class ContactPushService {

	private ContactPushDao dao = new ContactPushDao();
	public boolean signUp(String name, String phone, String email, String password){
		ContactPushUser user = new ContactPushUser(name, phone, email, password);
		return dao.addUser(user);
	}
	
	public ContactPushUser logIn(String phone, String password){
		
		return dao.loggedInUser(phone, password);
	}
}