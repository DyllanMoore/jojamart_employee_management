package com.revature;

import java.sql.Connection;
import java.sql.SQLException;

import com.revature.controllers.EmployeeController;
import com.revature.controllers.RoleController;
import com.revature.utils.ConnectionUtil;

import io.javalin.Javalin;

public class Launcher {

	public static void main(String[] args) {

		System.out.println("=========JojaMart Employee Management System==========");
		
		try(Connection conn = ConnectionUtil.getConnection()){
			System.out.println("Connection successful");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		
		
		Javalin app = Javalin.create(
				config -> {
					config.enableCorsForAllOrigins();
				}
				
				).start(3000);
		
		EmployeeController ec = new EmployeeController();
		RoleController rc = new RoleController();
		
		app.post("employees/:employee", ec.insertEmployeeHandler);
		app.get("/employees", ec.getEmployeesHandler);
		app.delete("/employees/:employee", ec.deleteEmployeeHandler);
		app.put("/employees/:employee", ec.updateEmployeeSalaryHandler);
		
		app.put("/roles/:role", rc.updateRoleNameHandler);
		
	}

}
