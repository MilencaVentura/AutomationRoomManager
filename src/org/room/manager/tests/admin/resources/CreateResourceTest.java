package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.LoginPage;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.room.manager.utils.configReader;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.room.manager.utils.HttpReader;

public class CreateResourceTest {
	/*Test Case:
	   * Verify that is possible create a resource*/
	private static WebDriver driver = null;
  Logger logger=Logger.getLogger("test02CreateResource");
  
  @BeforeSuite (groups = {"ACCEPTANCE"})
	public void setUp() throws Exception {
      driver = managerPage.getBrowserChrome();
	}
  @Test  (groups = {"ACCEPTANCE"})
	public void CreateResource() throws Exception {
		String nameResource = "Resource1";
		String message = "The resource cannot be created";
		driver.get(configReader.getUrl() + "/admin/#/login");
		HomeAdminPage home = new HomeAdminPage(driver);
		LoginPage login = new LoginPage(driver);
		login.btn_signIn();
		home.lnk_Resources();
		ResourcePage resourcePage = new ResourcePage(driver);
		resourcePage.btn_Add();
		ResourceCreatePage resourceAddPage = new ResourceCreatePage(driver);
		resourceAddPage.txt_name().txt_displayName().btn_Save();
		String resources = resourcePage.getResourceName(nameResource);
		Assert.assertEquals(resources, nameResource, message);
		
  }
	
  @AfterSuite (groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
	   HttpReader.deleteResourceByName("Resource1");
	   driver.quit();
	}
}