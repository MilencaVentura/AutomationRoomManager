package org.room.manager.tests.admin.resources;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.room.manager.managerPage;
import org.room.manager.pages.admin.HomeAdminPage;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.pages.admin.resources.ResourceCreatePage;
import org.room.manager.utils.HttpReader;
import org.room.manager.utils.configReader;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class VerifyUpdateResource {
	private static WebDriver driver = null;
	  Logger logger=Logger.getLogger("test03UpdateResource");
	  
	  @BeforeSuite
		public void setUp() throws Exception {
	      driver = managerPage.getBrowserChrome();
	      //HttpReader.createResourceJson(configReader.getName(), configReader.getDisplayName(),configReader.getIcon(),configReader.getDescription());
	      HttpReader.createResourceJson("TV", "TV","fa fa-desktop","TV with DVD ready");
		}
	  @Test  //(priority = 1)(groups = {"ACCEPTANCE"})
		public void UpdateResource() throws Exception {
		  PropertyConfigurator.configure("Log4j.properties");
			String expectedResult = "Calidad";
			driver.get(configReader.getUrl() + "/admin/#/login");
			logger.info("Begin the Test: Resource");
			HomeAdminPage.Execute(driver);
			EmailServerAddPage emailServer = new EmailServerAddPage(driver);
			emailServer.Execute();
			ResourceCreatePage resourcePage = new ResourceCreatePage(driver);
			driver.navigate().refresh();
			resourcePage.Execute();
			logger.info("Resources: press button for update resource");
			resourcePage.btnResource();
			logger.info("Resources: Updating resource");
			resourcePage.txt_displayNameUpdate();
			logger.info("press the button save");
			resourcePage.btn_Save();
			logger.info("verification the datas enter.");
			resourcePage.AssertUpdateResource(expectedResult);	
			//resourcePage.Execute().btn_Add().txt_name().txt_displayName().btn_Save().AssertWithouName(expectedResult);;
		}
		
	  @AfterSuite //(groups = {"ACCEPTANCE"})
		public void tearDown() throws Exception {
		  HttpReader.deleteResourceByName("TV");
		   driver.quit();
		}
}
