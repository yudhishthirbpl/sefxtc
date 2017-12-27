package com.devops.testsuites.suite01;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;

public class MatchPageTitleTest {
	private WebDriver driver; 
	String appURL = "http://google.com"; 
	
   @Test
   public void testAdd() {
	  System.out.println("---- executing test ----");
      String str = "TestNG is working fine";
      assertEquals("TestNG is working fine", str);
   }
   
   @Test
   public void testChromeBrowser() {
	   
   }//end of method
}//end of class