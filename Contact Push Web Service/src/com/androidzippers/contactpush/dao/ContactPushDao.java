package com.androidzippers.contactpush.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.androidzippers.contactpush.bean.ContactPushUser;

public class ContactPushDao {
	
	private Connection con = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	public boolean addUser(ContactPushUser user){
		
		boolean signedUp = false;
		
		try {
		con = DatabaseUtil.getConnection();
			ps = con.prepareStatement("INSERT INTO CONTACTPUSH_USER (NAME, EMAIL, PHONE, PASSWORD) VALUES (?, ?, ?, ?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setString(4, user.getPassword());
			
			if(ps.executeUpdate() > 0){
				signedUp = true;
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return signedUp;
	}
	
	public ContactPushUser loggedInUser(String phone, String password){
		
		ContactPushUser user = null;
		
		try {
			con = DatabaseUtil.getConnection();
				ps = con.prepareStatement("SELECT * FROM CONTACTPUSH_USER WHERE PHONE = ?");
				ps.setString(1, phone);
				
				rs = ps.executeQuery();
				
				while(rs.next()){
					if(rs.getString(4).equals(password)){
						user = new ContactPushUser(rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4));
					}
				}
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		return user;
	}
}
