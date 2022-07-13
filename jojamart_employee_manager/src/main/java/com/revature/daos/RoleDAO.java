package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.revature.models.Roles;
import com.revature.utils.ConnectionUtil;

public class RoleDAO implements RoleDAOInterface{

	@Override
	public Roles getRoleById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateRoleName(String oldRoleName, String newRoleName) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update jojamart_roles set job_role = ? where job_role = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newRoleName);
			ps.setString(2, oldRoleName);
			ps.executeUpdate();
			System.out.println(oldRoleName + "'s name was updated to " + newRoleName);
			
			return true;
		} catch(SQLException e) {
			System.out.println("Update Role Name Failed");
			e.printStackTrace();
		}
		return false;
	}

}
