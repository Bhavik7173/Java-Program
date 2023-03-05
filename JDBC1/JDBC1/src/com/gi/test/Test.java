package com.gi.test;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.gi.dao.DBOperation;
import com.gi.model.Employee;

public class Test {
	public static Employee createEmp()
	{
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		System.out.println("Enter Name : ");
		String name = sc.next();
		
		System.out.println("Enter Salary : ");
		float sal = sc.nextFloat();
		
		Employee emp = new Employee(id,name,sal);
		
		return emp;
	}
	public static Employee updateEmp()
	{
		Scanner sc = new Scanner(System.in); 
		
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		System.out.println("Enter Name : ");
		String name = sc.next();
		
		System.out.println("Enter Salary : ");
		float sal = sc.nextFloat();
		
		Employee emp = new Employee(id,name,sal);
		
		return emp;
	}
	public static void main(String[] args) {
		int ch = 0;
		Scanner sc = new Scanner(System.in);
		
		try {
		DBOperation dbOperation = new DBOperation();
		
		do {
			System.out.println("1. insert new Employee");
			System.out.println("2. delete an Employee");
			System.out.println("3. udpate an Employee");
			System.out.println("4. serach for an Employee (id based)");
			System.out.println("5. Disp all Employees");
			System.out.println("6. Exit");
			System.out.println("Enter your choice : ");
			ch = sc.nextInt();
			int n = 0,id = 0;
			Employee emp = null;
			switch (ch) {
			case 1: 
				emp = createEmp();
				n = dbOperation.insertEmp(emp);
				System.out.println(n+" records inserted...");
				break;
			case 2: 
				System.out.println("Enter id : ");
				id = sc.nextInt();
				n = dbOperation.deleteEmp(id);
				System.out.println(id+" records deleted...");
				break;
			case 3:	
				emp = createEmp();
				n = dbOperation.updateEmp(emp);
				System.out.println(n+" records updated...");
				break;
			case 4: 
				System.out.println("Enter id : ");
				id = sc.nextInt();
				boolean status = dbOperation.searchEmp(id);
				if(status == true)
					System.out.println("Found");
				else
					System.out.println("not Found");
				
				break;
			case 5: 
				List<Employee> employees = dbOperation.fetchAllEmps();
				for(Employee tempemp : employees)
				{
					System.out.println(tempemp);
				}
				break;
			case 6:
				System.out.println("bye");
				break;
 			default:
				System.out.println("Invalid choice");
			}
		} while (ch!=6);
		}
		catch (ClassNotFoundException e) {
			System.out.println(e);
		}
		catch (SQLException e) {
			System.out.println(e);
		}
	}
}
