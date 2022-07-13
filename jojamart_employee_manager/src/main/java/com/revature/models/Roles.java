package com.revature.models;

public class Roles {

	private int role_id;
	private String job_role;
	
	//Boilerplate Code-----------------------
	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Roles(int role_id, String job_role) {
		super();
		this.role_id = role_id;
		this.job_role = job_role;
	}

	public Roles(String job_role) {
		super();
		this.job_role = job_role;
	}

	@Override
	public String toString() {
		return "Roles [role_id=" + role_id + ", job_role=" + job_role + "]";
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public String getJob_role() {
		return job_role;
	}

	public void setJob_role(String job_role) {
		this.job_role = job_role;
	}

	
	
}