package com.revature.daos;

import java.util.ArrayList;

import com.revature.models.Employees;

public interface EmployeeDAOInterface {

	//insert new employee
	boolean insertEmployee(Employees employee);
		
	//get all employees
	ArrayList<Employees> getEmployees();
	
	//delete an employee
	public void deleteEmployee(String employee);
	
	//update an employee's salary
	boolean updateEmployeeSalary(String employee, int salary);
	
	boolean updateEmployeeName(String oldName, String newName);
	
	boolean updateEmployeeTitle(String employeeTitle, int title);
}