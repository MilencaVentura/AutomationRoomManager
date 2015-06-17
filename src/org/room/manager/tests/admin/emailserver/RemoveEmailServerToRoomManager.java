package org.room.manager.tests.admin.emailserver;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerConfirmationPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.utils.HttpRequest;
import org.room.manager.utils.configReader;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RemoveEmailServerToRoomManager {
	/**
	 * This test case is for verify that is possible add a email server in Room Manager. 
	 * @author Milenca Ventura
	 */
	public class AddEmailServerToRoomManager {
		private WebDriver driver = null;
	    Logger logger=Logger.getLogger("test01AddEmailServer");
	    
	    @BeforeSuite (groups = {"ACCEPTANCE"})
		public void setUp() throws Exception {
		     driver = managerPage.getBrowserChrome();
		     HttpRequest.addEmailServerJson(configReader.getUsername(),configReader.getPassword(),configReader.getHostName());
		}
		@Test (groups = {"ACCEPTANCE"})
		public void registerEmailService() throws Exception {
			PropertyConfigurator.configure("Log4j.properties");
			String message = "The email server is not deleted.";
			driver.get(configReader.getUrl() + "/admin/#/login");
			logger.info("Begin the Test: Email Server");
			logger.info("Open the page");
			EmailServerPage emailServer = new EmailServerPage(driver);
			HomeAdminPage.Execute(driver);
			emailServer.Execute();
			emailServer.btn_Remove();
			EmailServerConfirmationPage emailServerConfirmation = new EmailServerConfirmationPage(driver);
			emailServerConfirmation.btn_Delete();
			Assert.assertTrue(emailServer.AssertDeleteEmailServer(), message);
			logger.info("Close the Test: Email Server");
		}
		
		@AfterSuite (groups = {"ACCEPTANCE"})
		public void tearDown() throws Exception {
			HttpRequest.deleteServiceByName("Microsoft Exchange Server 2010 SP2");
		   driver.quit();
		}
	}
}
