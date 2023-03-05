package com.gi;

import java.util.Scanner;

public class Sum4 {
	public static void main(String[] args)
	{
		int x,y,sum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the First Number:");
		x= sc.nextInt();
		
		System.out.println("Enter the Second Number:");
		y= sc.nextInt();
		
		sum = sum(x,y);
		
		System.out.println("C = A + B");
		System.out.println(sum+"=" +x+"+"+y);
	}
	public static int sum(int a,int b)
	{
		int sum = a + b;
		return sum;
	}
}
