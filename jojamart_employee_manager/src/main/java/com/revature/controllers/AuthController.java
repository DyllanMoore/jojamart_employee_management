package com.revature.controllers;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.services.AuthServices;

import io.javalin.http.Handler;

public class AuthController {

	AuthServices as = new AuthServices();
	
		static HttpSession ses;
	
		public Handler loginHandler = (ctx) -> {
		
			String body = ctx.body();
			Gson gson = new Gson();
		
			LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
			String loginUsername = as.login(lDTO.getUsername(), lDTO.getPassword()); 
		
			if( loginUsername != null) { 
			
				ses = ctx.req.getSession(); 
			
				ctx.result("welcome " + loginUsername);
				ctx.status(202);
			} else {
				ctx.status(401);
			}
		};
}
