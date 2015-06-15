package org.room.manager.tests.admin.emailserver;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.utils.configReader;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveEmailServerToRoomManager {
	/**
	 * This test case is for verify that is possible add a email server in Room Manager. 
	 * @author Milenca Ventura
	 */
	public class AddEmailServerToRoomManager {
		private WebDriver driver = null;
		private managerPage automation=managerPage.getManager();
	    Logger logger=Logger.getLogger("test01AddEmailServer");
		@BeforeTest
		public void setUp() throws Exception {
		     driver = automation.getBrowserChrome();
		}
		@Test (priority = 1)
		public void registerEmailService() throws Exception {
			PropertyConfigurator.configure("Log4j.properties");
			//String expectedResult = configReader.getHostName()+ "\nMicrosoft Exchange Server 2010 SP2";
			driver.get(configReader.getUrl() + "/admin/#/login");
			logger.info("Begin the Test: Email Server");
			logger.info("Open the page");
			EmailServerAddPage emailServer = new EmailServerAddPage(driver);
			HomeAdminPage.Execute(driver);
			emailServer.Execute();
			/*
			emailServer.btn_Add();
			emailServer.txt_Hostname( configReader.getHostName());
			emailServer.txt_Username( configReader.getUsername());
			emailServer.txt_Password( configReader.getPassword());
			emailServer.btn_Save();
			driver.navigate().refresh();*/
			driver.navigate().refresh();
			emailServer.btn_Remove();
			emailServer.btn_Delete();
			//
			//Assert.assertEquals(emailServer.getButtonServer(), expectedResult, "The email server is not registered");
			Assert.assertEquals(emailServer.AssertDeleteEmailServer(), "The email server is not deleted.");
			logger.info("Close the Test: Email Server");
		}
		
		@AfterTest
		public void tearDown() throws Exception {
		   driver.quit();
		   /*String verificationErrorString = verificationErrors.toString();
		   if (!"".equals(verificationErrorString)) {
			   fail(verificationErrorString);
		   }*/
		}
	}
}
