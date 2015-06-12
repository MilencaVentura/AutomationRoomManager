package org.room.manager.tests.admin.resources;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateResourceTest {
	/*Test Case:
	   * Verify that is possible create a resource*/
	private StringBuffer verificationErrors = new StringBuffer();
	private static WebDriver driver = null;
	private managerPage automation=managerPage.getManager();
  Logger logger=Logger.getLogger("test02CreateResource");
  
  @BeforeTest
	public void setUp() throws Exception {
      driver = automation.openBrowser();
	}
  @Test //(groups = {"ACCEPTANCE"})
	public void CreateResource() throws Exception {
		PropertyConfigurator.configure("Log4j.properties");
		String expectedResult = "Resource1";
		driver.get(configReader.getUrl() + "/admin/#/login");
		logger.info("Begin the Test: Resource");
		HomeAdminPage.Execute(driver);
		ResourceCreatePage resourcePage = new ResourceCreatePage(driver);
		resourcePage.Execute();
		logger.info("Resources: press button add");
		resourcePage.btn_Add();		
		resourcePage.txt_name();
		resourcePage.txt_displayName();
		logger.info("press the button save");
		resourcePage.btn_Save();
		logger.info("verification the datas enter.");
		resourcePage.AssertCreateResource(expectedResult);
		logger.info("Close the Test: Resource");
		//resourcePage.Execute().btn_Add().txt_name().txt_displayName().btn_Save().AssertWithouName(expectedResult);;
	}
	
	@AfterTest //(groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
	   driver.quit();
	   String verificationErrorString = verificationErrors.toString();
	   if (!"".equals(verificationErrorString)) {
		   fail(verificationErrorString);
	   }
	}
}