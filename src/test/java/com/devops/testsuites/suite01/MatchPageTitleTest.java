package com.devops.testsuites.suite01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MatchPageTitleTest {
	private WebDriver driver; 
	private String appURL;
	private String actualPageTitle;
	
	@Parameters({ "webdriver.chrome.driver", "appUrl" })
	@BeforeClass
	public void testSetUp(String chromeDriverPath, String appUrl) {
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		appURL = appUrl;
		actualPageTitle = "Cars Reports";
		driver = new ChromeDriver();
	}
	
   @Test
   public void testPageTitle() {
	   driver.navigate().to(appURL);
	   assertEquals(driver.getTitle(), actualPageTitle);
   }//end of method
   
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}//end of class