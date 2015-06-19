package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.common.Common;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.LoginPage;
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
	  Logger logger=Logger.getLogger("test03DeleteResource");
	  
	  @BeforeSuite (groups = {"ACCEPTANCE"})
		public void setUp() throws Exception {
	      driver = managerPage.getBrowserChrome();
	         HttpReader.createResourceJson("Monitor", "monitor","fa fa-desktop","Monitor with control ready");
		}
	  @Test (groups = {"ACCEPTANCE"}) //(priority = 1)(groups = {"ACCEPTANCE"})
		public void DeleteResource() throws Exception {
			String message = "The resource cannot be deleted";
			String customName= "Calidad";
			driver.get(configReader.getUrl() + "/admin/#/login");
			HomeAdminPage home = new HomeAdminPage(driver);
			LoginPage login = new LoginPage(driver);
			login.btn_signIn();
			Common refresh = new Common();
			refresh.Refresh(driver);
			home.lnk_Resources();
			ResourcePage resourcePage = new ResourcePage(driver);
			resourcePage.getAllresource("Monitor");
			resourcePage.checkResource("Monitor");
			resourcePage.btnRemoveResource();
			ResourceDeletePage deletePage = new ResourceDeletePage(driver);
			deletePage.btnOkRemoveResource();

			boolean resources = resourcePage.getAllresource(customName);
			Assert.assertTrue(resources, message);
	   }
		
	  @AfterSuite (groups = {"ACCEPTANCE"})
		public void tearDown() throws Exception {
		   driver.quit();
		}
}
