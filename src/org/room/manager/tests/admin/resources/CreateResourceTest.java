package org.room.manager.tests.admin.resources;

import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
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
		PropertyConfigurator.configure("Log4j.properties");
		String expectedResult = "Resource1";
		driver.get(configReader.getUrl() + "/admin/#/login");
		logger.info("Begin the Test: Resource");
		HomeAdminPage.Execute(driver);
		EmailServerPage emailServer = new EmailServerPage(driver);
		emailServer.Execute();
		ResourcePage resourcePage = new ResourcePage(driver);
		resourcePage.Execute();
		logger.info("Resources: press button add");
		resourcePage.btn_Add();	
		ResourceCreatePage resourceAddPage = new ResourceCreatePage(driver);
		//driver.navigate().refresh();
		resourceAddPage.txt_name();
		resourceAddPage.txt_displayName();
		logger.info("press the button save");
		resourceAddPage.btn_Save();
		logger.info("verification the datas enter.");
		resourcePage.AssertCreateResource(expectedResult);
		//resourcePage.Execute().btn_Add().txt_name().txt_displayName().btn_Save().AssertWithouName(expectedResult);;
	}
	
  @AfterSuite (groups = {"ACCEPTANCE"})
	public void tearDown() throws Exception {
	   HttpReader.deleteResourceByName("Resource1");
	   driver.quit();
	}
}