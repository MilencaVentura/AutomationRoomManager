package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.common.Common;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.LoginPage;
import org.room.manager.utils.configReader;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.pages.admin.resources.ResourcePage;

/**
 * This test case is for verify that an error message
 * is displayed when a resource is created without name. 
 * @author Milenca Ventura
 */
public class AnErroMessageIsDisplayedWhenAResourceWithoutNameIsAdded {
	/*Test Case:
	   * Verify that is possible create a resource without name*/
	private static WebDriver driver = null;
    Logger logger=Logger.getLogger("test01CreateResource");
    @BeforeSuite (groups = {"ACCEPTANCE"})
	public void setUp() throws Exception {
		
        driver = managerPage.getBrowserChrome();
	}
    @Test (groups = {"ACCEPTANCE"})
	public void ResourceWithoutNameIsAdded() throws Exception {
		String expectedResult = "Name must not be empty";
		driver.get(configReader.getUrl() + "/admin/#/login");
		HomeAdminPage home = new HomeAdminPage(driver);
		LoginPage login = new LoginPage(driver);
		login.btn_signIn();
		Common refresh = new Common();
		refresh.Refresh(driver);
		home.lnk_Resources();
		ResourceCreatePage resourceAddPage = new ResourceCreatePage(driver);
		ResourcePage resourcePage = new ResourcePage(driver);
		resourcePage.btn_Add();
		resourceAddPage.txt_displayName().clickSaveButton();
		String resource = resourcePage.verificationResourceWithoutName(expectedResult);
		Assert.assertEquals(resource, expectedResult);
		resourceAddPage.btn_Close();
	}
	
    @AfterSuite (groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
	   driver.quit();	  
	}
}
