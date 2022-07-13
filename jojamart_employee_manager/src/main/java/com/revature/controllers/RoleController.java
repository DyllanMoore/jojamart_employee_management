package com.revature.controllers;

import com.revature.daos.RoleDAO;

import io.javalin.http.Handler;

public class RoleController {
	
	RoleDAO rDAO = new RoleDAO();

	public Handler updateRoleNameHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String oldRoleName = ctx.pathParam("role");
			String newRoleName = ctx.body();
		
			if(rDAO.updateRoleName(oldRoleName, newRoleName)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
}
