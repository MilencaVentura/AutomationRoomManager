package org.room.manager.tests.admin.emailserver;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.modules.AddEmailServer;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * This test case is for verify that is possible add a email server in Room Manager. 
 * @author Milenca Ventura
 */
public class AddEmailServerToRoomManager {
	private StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver = null;
	String baseUrl;
	
	@BeforeTest
	public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://172.20.208.174:4044";
	    driver.manage().window().maximize();
	}

	@Test (priority = 0)
	public void registerEmailService() throws Exception {
		String hostname = "env01001.unit.com";
		String username = "Administrator";
		String password = "qadev02**";
		String expectedResult = hostname + "\nMicrosoft Exchange Server 2010 SP2";
		
		driver.get(baseUrl + "/admin/#/login");
		
		HomeAdminPage.Execute(driver);
		AddEmailServer.Execute(driver,hostname,username,password);
		AddEmailServer.Assert(driver,expectedResult);
	}
	@AfterTest
	public void tearDown() throws Exception {
	   driver.quit();
	   String verificationErrorString = verificationErrors.toString();
	   if (!"".equals(verificationErrorString)) {
		   fail(verificationErrorString);
	   }
	}
}

