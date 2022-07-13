package com.revature.controllers;

import com.revature.daos.RoleDAO;

import io.javalin.http.Handler;

public class RoleController {
	
	RoleDAO rDAO = new RoleDAO();

	public Handler updateRoleNameHandler = (ctx) -> {
		
		String oldRoleName = ctx.pathParam("role");
		String newRoleName = ctx.body();
		
		if(rDAO.updateRoleName(oldRoleName, newRoleName)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};
}
