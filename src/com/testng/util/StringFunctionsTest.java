package com.testng.util;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class StringFunctionsTest {
	
  com.util.StringFunctions strfun = new com.util.StringFunctions();	
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("I'm in before method");
  }

  @AfterMethod 
  public void afterMethod() {
	  System.out.println("I'm in after method");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("I'm in before class");
  }

  @AfterClass
  public void afterClass() {
	  
	  System.out.println("I'm in after class");
  }


  @Test
  public void StringFunctions() {
	System.out.println("I'm in StringFunctions");
   
  }

  @Test
  public void isAnagrm() {
	  System.out.println("I'm in isAnagram");
	  Assert.assertEquals(strfun.isAnagrm("army","mary"), true);
   
  }

  @Test
  public void reverse() {
	  System.out.println("I'm in reverse");
	  String msg = String.copyValueOf(strfun.reverse("Hello"));
	  String expected = "olleH";
	  Assert.assertEquals(msg,expected);    
   
  }
}
