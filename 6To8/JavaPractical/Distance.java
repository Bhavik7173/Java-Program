package com.gi;

import java.util.Scanner;

public class Distance {

	    static double start,acclanation,time;

	    public static void main(String args[]){
	    	
	    	Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter the Starting Speed:");
			start= sc.nextDouble();
	        
			System.out.println("Enter the accalanation Speed:");
			acclanation= sc.nextDouble();
	        
			System.out.println("Enter the time:");
			time= sc.nextDouble();
	        
			Distance testInstance= new Distance();
	        double result = testInstance.distance(start,acclanation,time);
	        System.out.println(result);
	    }

	    //write your code here
	    public double distance(double u, double a, double t){
	        double d = d = (u*t) + (0.5*a*(t*t)) ;
	        return d;
	    }
}
