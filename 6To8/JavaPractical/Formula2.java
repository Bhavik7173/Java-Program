package com.gi;

import java.util.Scanner;

public class Formula2 {
	public static void main(String[] args)
	{
		float a,b,c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the y:");
		a= sc.nextFloat();
		
		System.out.println("Enter the z:");
		b= sc.nextFloat();
		
		c = cube(a,b);
		
		System.out.println("Print the cube:" + c);
	}
	public static float cube(float a,float b)
	{
		//float c = (a + b)* (a+b);
		float c = (a^2) - (b^2);
		return c;
	}
}
