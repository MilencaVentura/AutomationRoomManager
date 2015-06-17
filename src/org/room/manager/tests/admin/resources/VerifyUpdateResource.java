package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.room.manager.utils.HttpReader;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;

public class VerifyUpdateResource {
	private static WebDriver driver = null;
	  Logger logger=Logger.getLogger("test03UpdateResource");
	  
	  @BeforeSuite (groups = {"ACCEPTANCE"})
		public void setUp() throws Exception {
	      driver = managerPage.getBrowserChrome();
	      //HttpReader.createResourceJson(configReader.getName(), configReader.getDisplayName(),configReader.getIcon(),configReader.getDescription());
	     HttpReader.createResourceJson("Tv", "tv","fa fa-desktop","TV with DVD ready");
		}
	  @Test (groups = {"ACCEPTANCE"}) //(priority = 1)(groups = {"ACCEPTANCE"})
		public void UpdateResource() throws Exception {
		  PropertyConfigurator.configure("Log4j.properties");
			String expectedResult = "Calidad";
			String message = "The resource cannot be updated";
			driver.get(configReader.getUrl() + "/admin/#/login");
			logger.info("Begin the Test: Update Resource");
			HomeAdminPage.Execute(driver);
			EmailServerPage emailServer = new EmailServerPage(driver);
			emailServer.Execute();
			ResourcePage resourcePage = new ResourcePage(driver);
			//driver.navigate().refresh();
			resourcePage.Execute();
			resourcePage.txtSearch("Tv");
			logger.info("Resources: press button for update resource");
			resourcePage.selectResourceByName();
			ResourceCreatePage resourceAddPage = new ResourceCreatePage(driver);	
			logger.info("Resources: Updating resource");
			resourceAddPage.txt_displayName();
			logger.info("press the button save");
			resourceAddPage.btn_Save();
			logger.info("verification the datas enter.");
			assertEquals(message, resourcePage.getFirstByDisplayName(), expectedResult);
			//resourcePage.AssertUpdateResource(expectedResult);	
			//resourcePage.Execute().btn_Add().txt_name().txt_displayName().btn_Save().AssertWithouName(expectedResult);;
		}
		
	  @AfterSuite (groups = {"ACCEPTANCE"})
		public void tearDown() throws Exception {
		  HttpReader.deleteResourceByName("Tv");
		   driver.quit();
		}
}
