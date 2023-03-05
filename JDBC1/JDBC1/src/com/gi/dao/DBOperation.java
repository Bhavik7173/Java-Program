package com.gi.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gi.model.Employee;

public class DBOperation {
	Connection con;
	
	public DBOperation() throws ClassNotFoundException,SQLException{
		//load driver
		String driver = "com.mysql.jdbc.Driver";
		Class.forName(driver);
		
		//create  connection
		//url : protocol + IP + port_number + db_name
		String url = "jdbc:mysql://localhost:3306/java_demo";
		String user = "root";
		String password = "";
		con = DriverManager.getConnection(url,user,password);
		
		//create table if not exists
		String query = "create table emp if not exists (id int,name varchar(20),salary number(7,2))";
		Statement st = con.createStatement();
		st.execute(query);
	}
	public int insertEmp(Employee emp)throws SQLException
	{
		int id = emp.getId();
		String name = emp.getName();
		float sal = emp.getSalary();
		String query = "insert into emp values ("+id+",'"+name+"',"+sal+")";
		
		Statement st = con.createStatement();
		return st.executeUpdate(query);
	}	
	public int updateEmp(Employee emp)throws SQLException
	{
		int id = emp.getId();
		String name = emp.getName();
		float sal = emp.getSalary();
		
		String query = "update emp set name = '"+name+"',salary="+sal+"where id="+id;
		
		Statement st = con.createStatement();
		return st.executeUpdate(query);
	}	
	public int deleteEmp(int id)throws SQLException
	{
		String query = "delete from emp where id = "+id;
		
		Statement st = con.createStatement();
		return st.executeUpdate(query);
	}
	public boolean searchEmp(int id)throws SQLException
	{
		//emp : table name
		String query = "select * from emp where id = "+id;
		Statement st = con.createStatement();
		ResultSet rst = st.executeQuery(query);
		return rst.next();
	}
	public List<Employee> fetchAllEmps()throws SQLException
	{
		//emp : table name
		String query = "select * from emp";
		Statement st = con.createStatement();
		ResultSet rst = st.executeQuery(query);
		
		List<Employee> lst = new ArrayList<>();
		
		while(rst.next())
		{
			Employee emp = new Employee();
			emp.setId(rst.getInt(1));
			emp.setName(rst.getString(2));
			emp.setSalary(rst.getFloat(3));
			
			lst.add(emp);
		}
		return lst;
	}
}
