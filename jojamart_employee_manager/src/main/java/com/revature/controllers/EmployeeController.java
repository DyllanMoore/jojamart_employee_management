package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employees;

import io.javalin.http.Handler;

public class EmployeeController {

	EmployeeDAO eDAO = new EmployeeDAO();
	
	public Handler insertEmployeeHandler = (ctx) -> {
		if(AuthController.ses != null) {	
			String body = ctx.body();
			Gson gson = new Gson();
			Employees newEmployee = gson.fromJson(body, Employees.class);
		
			if(eDAO.insertEmployee(newEmployee)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler getEmployeesHandler = (ctx) -> {
		if(AuthController.ses != null) {
			ArrayList<Employees> employees = eDAO.getEmployees();
			Gson gson = new Gson();
			String Jsonemployees = gson.toJson(employees);
			ctx.result(Jsonemployees);
			ctx.status(202);
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler deleteEmployeeHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String employeeToDelete = ctx.pathParam("employee");
			eDAO.deleteEmployee(employeeToDelete);
		
			ctx.result(employeeToDelete + " has been removed from JojaMart Employees.");
			ctx.status(202);
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler updateEmployeeSalaryHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String employee = ctx.pathParam("update_salary");
			int salary = Integer.parseInt(ctx.body());
		
			if(eDAO.updateEmployeeSalary(employee, salary)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler updateEmployeeNameHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String oldName = ctx.pathParam("update_name");
			String newName = ctx.body();
		
			if(eDAO.updateEmployeeName(oldName, newName)) {
				ctx.status(202);
			} else {
				ctx.status(406);
			}
		} else {
			ctx.result("You are not logged in");
			ctx.status(401);
		}
	};
	
	public Handler updateEmployeeTitleHandler = (ctx) -> {
		if(AuthController.ses != null) {
			String employeeTitle = ctx.pathParam("update_title");
			int title = Integer.parseInt(ctx.body());
		
			if(eDAO.updateEmployeeSalary(employeeTitle, title)) {
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
