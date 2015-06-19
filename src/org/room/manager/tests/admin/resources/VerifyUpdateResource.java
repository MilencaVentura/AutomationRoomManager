package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.LoginPage;
import org.room.manager.common.Common;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.room.manager.utils.HttpReader;
import org.room.manager.utils.configReader;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyUpdateResource {
	private static WebDriver driver = null;
	  Logger logger=Logger.getLogger("test04UpdateResource");
	  
	  @BeforeSuite (groups = {"ACCEPTANCE"})
		public void setUp() throws Exception {
	      driver = managerPage.getBrowserChrome();
		     HttpReader.createResourceJson("Tv", "tv","fa fa-desktop","TV with DVD ready");
		}
	  @Test (groups = {"ACCEPTANCE"})
		public void UpdateResource() throws Exception {
			String message = "The resource cannot be updated";
			driver.get(configReader.getUrl() + "/admin/#/login");
			HomeAdminPage home = new HomeAdminPage(driver);
			LoginPage login = new LoginPage(driver);
			login.btn_signIn();
			ResourcePage resourcePage = new ResourcePage(driver);	
			Common refresh = new Common();
			refresh.Refresh(driver);
			home.lnk_Resources();
			resourcePage.clickSelectResource("Tv");
			ResourceCreatePage resourceAddPage = new ResourceCreatePage(driver);	
			resourceAddPage.txt_displayName().btn_Save();
			String resources = resourcePage.getResourceCustomName("Calidad");
			Assert.assertEquals(resources, "Calidad", message);		
	  }
		
	  @AfterSuite (groups = {"ACCEPTANCE"})
		public void tearDown() throws Exception {
		  HttpReader.deleteResourceByName("Tv");
		   driver.quit();
		}
}
