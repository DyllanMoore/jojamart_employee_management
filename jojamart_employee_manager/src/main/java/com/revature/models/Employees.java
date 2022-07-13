package com.revature.models;

public class Employees {
	private int employee_id;
	private String employee_name;
	private Roles role;
	private int employee_salary;
	
	private int employee_role_fk;
	
	//Boilerplate Code-------------------------
	public Employees() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Employees(int employee_id, String employee_name, Roles role, int employee_salary) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.role = role;
		this.employee_salary = employee_salary;
	}


	public Employees(String employee_name, Roles role, int employee_salary) {
		super();
		this.employee_name = employee_name;
		this.role = role;
		this.employee_salary = employee_salary;
	}


	@Override
	public String toString() {
		return "Employees [employee_id=" + employee_id + ", employee_name=" + employee_name + ", role=" + role
				+ ", employee_salary=" + employee_salary + "]";
	}


	public int getEmployee_id() {
		return employee_id;
	}


	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}


	public String getEmployee_name() {
		return employee_name;
	}


	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}


	public Roles getRole() {
		return role;
	}


	public void setRole(Roles role) {
		this.role = role;
	}


	public int getEmployee_salary() {
		return employee_salary;
	}


	public void setEmployee_salary(int employee_salary) {
		this.employee_salary = employee_salary;
	}


	public int getEmployee_role_fk() {
		return employee_role_fk;
	}


	public void setEmployee_role_fk(int employee_role_fk) {
		this.employee_role_fk = employee_role_fk;
	}

	
	
}