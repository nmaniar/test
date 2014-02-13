package com.util;

public class StringFunctions {

	public StringFunctions() {
		// TODO Auto-generated constructor stub
	}

	

	public static char[] reverse(String s)
	
	{
		//s = s.toLowerCase();
		char [] rev = new char[s.length()];
		for(int i= s.length()-1, j=0;  i >= 0;i--,j++)
		{
			rev[j] = s.charAt(i);
		}
		return rev;
	      
	}
	
	public static boolean isAnagrm(String str1, String str2)
	{
		
		if (str1.length() != str2.length())
			                      return false;
		else
		{
			str1=str1.toLowerCase();
			str2=str2.toLowerCase();
			for (int i=0; i < str2.length();i++)
			{
				if (str1.indexOf(str2.charAt(i)) > -1)
					
				{
					str1= str1.substring(0,str1.indexOf(str2.charAt(i)))+ str1.substring(str1.indexOf(str2.charAt(i))+1);
				}			
				else 
					 return false;
			}
			
		}
			return true;
	}
	
	
	
}

