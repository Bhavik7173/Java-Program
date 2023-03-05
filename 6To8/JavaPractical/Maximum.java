package com.gi;

import java.util.Scanner;

public class Maximum {
	public static void main(String[] args)
	{
		double i,j;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the value of i:");
		i= sc.nextDouble();
		
		System.out.println("Enter the value of j:");
		j= sc.nextDouble();
		
		if(i>j)
			System.out.println(i+ " is greater than " + j);
		else
			System.out.println(i+ " is less than " + j);
	}
}
