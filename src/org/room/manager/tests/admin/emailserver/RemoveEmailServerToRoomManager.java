package org.room.manager.tests.admin.emailserver;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RemoveEmailServerToRoomManager {
	/**
	 * This test case is for verify that is possible add a email server in Room Manager. 
	 * @author Milenca Ventura
	 */
	public class AddEmailServerToRoomManager {
		private StringBuffer verificationErrors = new StringBuffer();
		private WebDriver driver = null;
		private managerPage automation=managerPage.getManager();
	    Logger logger=Logger.getLogger("test01AddEmailServer");
		@BeforeTest
		public void setUp() throws Exception {
			System.setProperty("webdriver.chrome.driver", configReader.getChromeDriver());
	        driver = automation.openBrowser();
	        driver.manage().window().maximize();
		}
		@Test (priority = 0)
		public void registerEmailService() throws Exception {
			PropertyConfigurator.configure("Log4j.properties");
			String hostname = configReader.getHostName();
			String username = configReader.getUsername();
			String password = configReader.getPassword();
			String expectedResult = hostname + "\nMicrosoft Exchange Server 2010 SP2";
			String expectedResultDelete = hostname + "\nMicrosoft Exchange Server 2010 SP2";
			driver.get(configReader.getUrl() + "/admin/#/login");
			logger.info("Begin the Test: Email Server");
			logger.info("Open the page");
			EmailServerAddPage emailServer = new EmailServerAddPage(driver);
			HomeAdminPage.Execute(driver);
			emailServer.Execute().
			btn_Add().
			txt_Hostname(hostname).
			txt_Username(username).
			txt_Password(password).
			btn_Save().
			Assert(expectedResult).btn_Remove().AssertDelete(expectedResultDelete);
			logger.info("Close the Test: Email Server");
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
}
