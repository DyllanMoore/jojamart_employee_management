package com.revature.controllers;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.revature.daos.EmployeeDAO;
import com.revature.models.Employees;

import io.javalin.http.Handler;

public class EmployeeController {

	EmployeeDAO eDAO = new EmployeeDAO();
	
	public Handler insertEmployeeHandler = (ctx) -> {
		String body = ctx.body();
		Gson gson = new Gson();
		Employees newEmployee = gson.fromJson(body, Employees.class);
		
		if(eDAO.insertEmployee(newEmployee)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
		
	};
	
	public Handler getEmployeesHandler = (ctx) -> {
		ArrayList<Employees> employees = eDAO.getEmployees();
		Gson gson = new Gson();
		String Jsonemployees = gson.toJson(employees);
		ctx.result(Jsonemployees);
		ctx.status(200);
	};
	
	public Handler deleteEmployeeHandler = (ctx) -> {
		String employeeToDelete = ctx.pathParam("employee");
		eDAO.deleteEmployee(employeeToDelete);
		
		ctx.result(employeeToDelete + " has been removed from JojaMart Employees.");
		ctx.status(202);
	};
	
	public Handler updateEmployeeSalaryHandler = (ctx) -> {
		String employee = ctx.pathParam("employee");
		int salary = Integer.parseInt(ctx.body());
		
		if(eDAO.updateEmployeeSalary(employee, salary)) {
			ctx.status(202);
		} else {
			ctx.status(406);
		}
	};
	
}
