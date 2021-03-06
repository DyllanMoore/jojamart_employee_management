package com.revature.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.models.Employees;
import com.revature.models.Roles;
import com.revature.utils.ConnectionUtil;

public class EmployeeDAO implements EmployeeDAOInterface {

	@Override
	public boolean insertEmployee(Employees employee) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "insert into jojamart_employees (employee, employee_role_fk, employee_salary) values (?, ?, ?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, employee.getEmployee());
			ps.setInt(2, employee.getEmployee_role_fk());
			ps.setInt(3, employee.getEmployee_salary());
			
			ps.executeUpdate();
			
			System.out.println(employee.getEmployee() + " was added to JojaMart Employees!");
			
			return true;
		} catch(SQLException e) {
			System.out.println("Adding Employee Failed");
			e.printStackTrace();
		}
		
		return false;
	}


	@Override
	public ArrayList<Employees> getEmployees() {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "select * from jojamart_employees;";
			Statement s = conn.createStatement();
			ResultSet rs = s.executeQuery(sql);
			ArrayList<Employees> employeeList = new ArrayList<>();
			
			while(rs.next()) {
				Employees emp = new Employees(
						rs.getInt("employee_id"),
						rs.getString("employee"),
						null,
						rs.getInt("employee_salary")
						);
				
				int role_fk = rs.getInt("employee_role_fk");
				RoleDAO rDAO = new RoleDAO();
				Roles r = rDAO.getRoleById(role_fk);
				emp.setRole(r);
				emp.setEmployee_role_fk(role_fk);
				employeeList.add(emp);
			}
			
			return employeeList;
			
			
		} catch(SQLException e) {
			System.out.println("Get All Employees Failed");
			e.getStackTrace();
		}
		
		
		return null;
	}

	@Override
	public void deleteEmployee(String employee) {

		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "delete from jojamart_employees where employee = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, employee);
			ps.executeUpdate();
			System.out.println(employee + " was removed from JojaMart Employees.");
			
		} catch(SQLException e) {
			System.out.println("Delete Employee Failed");
			e.getStackTrace();
		}
		
	}

	@Override
	public boolean updateEmployeeSalary(String employee, int salary) {
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update jojamart_employees set employee_salary = ? where employee = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, salary);
			ps.setString(2, employee);
			ps.executeUpdate();
			System.out.println(employee + "'s salary was changed to $" + salary);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Employee Salary Failed");
			e.fillInStackTrace();
		}
		
		return false;
	}


	@Override
	public boolean updateEmployeeName(String oldName, String newName) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update jojamart_employees set employee = ? where employee = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, newName);
			ps.setString(2, oldName);
			ps.executeUpdate();
			System.out.println(oldName + "'s name was changed to " + newName);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Employee Name Failed");
			e.fillInStackTrace();
		}
		
		return false;
	}



	@Override
	public boolean updateEmployeeTitle(String employeeTitle, int title) {
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "update jojamart_employees set employee_role_fk = ? where employee = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, title);
			ps.setString(2, employeeTitle);
			ps.executeUpdate();
			System.out.println(employeeTitle + "'s title was changed to " + title);
			
			return true;
			
		} catch(SQLException e) {
			System.out.println("Update Employee Title Failed");
			e.fillInStackTrace();
		}
		
		return false;
	}

}
