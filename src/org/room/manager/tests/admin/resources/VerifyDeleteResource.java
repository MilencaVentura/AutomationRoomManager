package org.room.manager.tests.admin.resources;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.pages.admin.resources.ResourceDeletePage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.room.manager.utils.HttpReader;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.Assert;

public class VerifyDeleteResource {
	private static WebDriver driver = null;
	  Logger logger=Logger.getLogger("test05DeleteResource");
	  
	  @BeforeSuite (groups = {"ACCEPTANCE"})
		public void setUp() throws Exception {
	      driver = managerPage.getBrowserChrome();
	         HttpReader.createResourceJson("Monitor", "monitor","fa fa-desktop","Monitor with control ready");
		}
	  @Test (groups = {"ACCEPTANCE"}) //(priority = 1)(groups = {"ACCEPTANCE"})
		public void UpdateResource() throws Exception {
		    PropertyConfigurator.configure("Log4j.properties");
			String message = "The resource cannot be deleted";
			driver.get(configReader.getUrl() + "/admin/#/login");
			logger.info("Begin the Test: Delete Resource");
			HomeAdminPage.Execute(driver);
			EmailServerPage emailServer = new EmailServerPage(driver);
			emailServer.Execute();
			ResourcePage resourcePage = new ResourcePage(driver);
			driver.navigate().refresh();
			resourcePage.Execute();
			resourcePage.txtSearch("Monitor");
			logger.info("Resources: Select resource for delete");
			resourcePage.checkResource();
			logger.info("Resources: press button for Delete resource");
			resourcePage.btnRemoveResource();
			ResourceDeletePage deletePage = new ResourceDeletePage(driver);
			logger.info("Resources: press button ok for confirmate for Delete resource");
			deletePage.btnOkRemoveResource();
			logger.info("verification if the resources is deleted.");
			resourcePage.txtSearch("Monitor");
			boolean resources = resourcePage.getAllresource();
			Assert.assertTrue(resources, message);
	   }
		
	  @AfterSuite (groups = {"ACCEPTANCE"})
		public void tearDown() throws Exception {
		   driver.quit();
		}
}
