package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.utils.ConnectionUtil;

public class AuthDAO implements AuthDAOInterface{

	@Override
	public boolean login(String username, String password) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from users where username = ? and password = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				return true;
			}
		}catch(SQLException e) {
			System.out.println("Login Failed");
			e.printStackTrace();
		}
		return false;
	}

}
