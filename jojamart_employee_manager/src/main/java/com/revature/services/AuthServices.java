package com.revature.services;

import com.revature.daos.AuthDAO;

public class AuthServices {
	
	AuthDAO authDAO = new AuthDAO();
	
	public String login(String username, String password) {
		
		if (authDAO.login(username, password)) {
			return username; 
		}
		
		return null; 
	}


}