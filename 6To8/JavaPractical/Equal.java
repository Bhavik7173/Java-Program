package com.gi;

import java.util.Scanner;

public class Equal {
	public static void main(String[] args)
	{
		double i,j;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the value of i:");
		i= sc.nextDouble();
		
		System.out.println("Enter the value of j:");
		j= sc.nextDouble();
		
		if(i!=j)
			System.out.println(i+ " is not equal to " + j);
		else
			System.out.println(i+ " is equal " + j);
	}
}
