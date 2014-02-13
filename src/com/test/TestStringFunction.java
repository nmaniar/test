package com.test;

import java.util.Scanner;
import java.lang.Exception;
import com.util.StringFunctions;

public class TestStringFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
		System.out.println("Enter R For Reverse function");
		System.out.println("Enter A For Anagram function");
		Scanner in = new Scanner(System.in);
		String choice= in.nextLine().toUpperCase(); 
		
		switch (choice ) {
		case "R": 
			    System.out.println("Enter strings seperated by comma.\n ");
			    in = new Scanner(System.in);
			    line = in.nextLine();
			    line=line+",";
			    do
			    {
			    	System.out.println(StringFunctions.reverse(line.substring(0, line.indexOf(","))));
			    	line = line.substring(line.indexOf(",")+1);
			    }while(line.indexOf(",")>-1);
				
		break;
		case "A": 
			 System.out.println("Enter two strings seperated by comma.\n ");
			 in = new Scanner(System.in);
			 line = in.nextLine().trim(); // to ignore trailing spaces.
			 try
			 {
				 String str1= line.substring(0, line.indexOf(","));
				 String str2= line.substring(line.indexOf(",") +1);
			 
			
				 if(StringFunctions.isAnagrm(str1, str2))
				    System.out.println(str1 + " and " + str2 +" are an anagram strings.");
				 else
				    System.out.println(str1 + " and " + str2 +" are not an anagram strings."); 
			 }
			 catch (Exception ex)
			 {
				System.out.println("Please check your input strings.") ;
			 }
		break;
		default:
		   System.out.println("Sorry you enter wrong choice.");

		}
		
		
			in.close();
		
		
		
	}
	
		


	

}
