package com.revature.daos;

import com.revature.models.Roles;

public interface RoleDAOInterface {
	
	Roles getRoleById(int id);
	
	boolean updateRoleName(String oldRoleName, String newRoleName);
}
