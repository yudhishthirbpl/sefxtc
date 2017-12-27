package com.devops.testsuites.suite01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MatchPageTitleTest {
	private WebDriver driver; 
	private String appURL;
	private String hubURL;
	private String actualPageTitle;
	
	@Parameters({ "webdriver.chrome.driver", "appUrl", "hubUrl" })
	@BeforeClass
	public void testSetUp(String chromeDriverPath, String appUrl, String hubUrl) throws Exception{
		//System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		appURL = appUrl;
		hubURL = hubUrl;
		actualPageTitle = "Cars Reports";
		System.out.println("Property = " + System.getProperty("webdriver.chrome.driver"));
		DesiredCapabilities browser = DesiredCapabilities.chrome();
		browser.setPlatform(Platform.LINUX);
		/**
		 * 
		 * Edit /opt/google/chrome/google-chrome wrapper script and replace 
		 * exec -a "$0" "$HERE/chrome" "$@" with the following command line
		 * exec -a "$0" "$HERE/chrome" "$@" --user-data-dir --no-sandbox
		 * if you are planning to run selenium hub, node and jenkins pipeline with 'root' or 'elevated' 
		 * authority
		 */
		driver = new RemoteWebDriver(new URL(hubURL),browser);
	}
	
   @Test
   public void testPageTitle() throws Exception {
	   driver.navigate().to(new URL(appURL));
	   assertEquals(driver.getTitle(), actualPageTitle);
   }//end of method
   
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}//end of class