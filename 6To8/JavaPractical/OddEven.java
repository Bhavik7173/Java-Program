//WAP to check given number is even or odd

package com.gi;

import java.util.Scanner;

public class OddEven {
	public static void main(String[] args)
	{
		double i,j;
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the value of i:");
		i= sc.nextDouble();
		
		//System.out.println("Enter the value of j:");
		//j= sc.nextDouble();
		
		if(i%2==0)
			System.out.println(i+ " is even number");
		else
			System.out.println(i+ " is odd number");
	}
}
