package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.utils.configReader;
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
    Logger logger=Logger.getLogger("test02CreateResource");
    @BeforeSuite (groups = {"ACCEPTANCE"})
	public void setUp() throws Exception {
		
        driver = managerPage.getBrowserChrome();
	}
    @Test (groups = {"ACCEPTANCE"})
	public void ResourceWithoutNameIsAdded() throws Exception {
		PropertyConfigurator.configure("Log4j.properties");
		String expectedResult = "Name must not be empty";
		driver.get(configReader.getUrl() + "/admin/#/login");
		logger.info("Begin the Test: Resource without name");
		HomeAdminPage.Execute(driver);
		EmailServerPage emailServer = new EmailServerPage(driver);
		emailServer.Execute();
		ResourceCreatePage resourceAddPage = new ResourceCreatePage(driver);
		ResourcePage resourcePage = new ResourcePage(driver);
		resourcePage.Execute();
		resourcePage.btn_Add();
		resourceAddPage.txt_displayName();
		resourceAddPage.btn_Save();
		resourcePage.AssertWithouName(expectedResult);
		logger.info("End test:Resource without name");
		resourceAddPage.btn_Close();
	}
	
    @AfterSuite (groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
	   driver.quit();	  
	}
}
