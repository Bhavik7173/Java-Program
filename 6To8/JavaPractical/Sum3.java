package com.gi;

import java.util.Scanner;

public class Sum3 {
	public static void main(String[] args)
	{
		int x,y,sum;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the First Number:");
		x= sc.nextInt();
		
		System.out.println("Enter the Second Number:");
		y= sc.nextInt();
		
		sum = sum(x,y);
		
		System.out.println("A\tB\tC");
		System.out.println(x+"\t"+y+"\t"+sum);
	}
	public static int sum(int a,int b)
	{
		int sum = a + b;
		return sum;
	}
}
