package org.room.manager.tests.admin.resources;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.room.manager.pages.admin.resources.ResourceCreatePage;

/**
 * This test case is for verify that an error message
 * is displayed when a resource is created without name. 
 * @author Milenca Ventura
 */
public class AnErroMessageIsDisplayedWhenAResourceWithoutNameIsAdded {
	/*Test Case:
	   * Verify that is possible create a resource without name*/
	private static WebDriver driver = null;
	private managerPage automation=managerPage.getManager();
    Logger logger=Logger.getLogger("test02CreateResource");
    
    @BeforeSuite
	public void setUp() throws Exception {
		
        driver = automation.openBrowser();
	}
    @Test (priority = 0)
	public void ResourceWithoutNameIsAdded() throws Exception {
		PropertyConfigurator.configure("Log4j.properties");
		String expectedResult = "Name must not be empty";
		driver.get(configReader.getUrl() + "/admin/#/login");
		logger.info("Begin the Test: Resource");
		HomeAdminPage.Execute(driver);
		ResourceCreatePage resourcePage = new ResourceCreatePage(driver);
		resourcePage.Execute().
		btn_Add().
		txt_displayName().
		btn_Save().AssertWithouName(expectedResult);
		//post condition
		resourcePage.btn_Close();
	}
	
    @AfterSuite //(groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
    	
	   driver.quit();	  
	}
}
