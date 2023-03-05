package com.gi;

import java.util.Scanner;

public class Volume {
	public static void main(String[] args)
	{
		float l,b,h,v;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the length:");
		l= sc.nextFloat();
		
		System.out.println("Enter the width:");
		b= sc.nextFloat();
		
		System.out.println("Enter the height:");
		h= sc.nextFloat();
		
		v = volume(l,b,h);
		
	System.out.println("Print the Volume:" + v);
	}
	
	public static float volume(float l,float b,float h)
	{
		float v = l * b * h;
		return v;
	}
}
