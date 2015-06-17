package org.room.manager.tests.admin.emailserver;
import org.room.manager.utils.HttpRequest;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.room.manager.pages.admin.HomeAdminPage;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.room.manager.utils.configReader;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.room.manager.pages.admin.emailserver.EmailServerAddPage;
import org.room.manager.pages.admin.emailserver.EmailServerPage;
import org.room.manager.pages.admin.resources.ResourcePage;
import org.room.manager.managerPage;

/**
 * This test case is for verify that is possible add a email server in Room Manager. 
 * @author Milenca Ventura
 */
public class AddEmailServerToRoomManager {
	private static WebDriver driver = null;
	private managerPage automation=managerPage.getManager();
    Logger logger=Logger.getLogger("test01AddEmailServer");
    @BeforeSuite
	public void setUp() throws Exception {
        driver = automation.getBrowserChrome();
        HttpRequest.deleteServiceByName("Microsoft Exchange Server 2010 SP2");
	}
	@Test 
	public void registerEmailService() throws Exception {
		PropertyConfigurator.configure("Log4j.properties");
		String expectedResult = configReader.getHostName() + "\nMicrosoft Exchange Server 2010 SP2";
		System.out.print("expecet:"+expectedResult);
		driver.get(configReader.getUrl() + "/admin/#/login");
		logger.info("Begin the Test: Email Server");
		logger.info("Open the page");
		HomeAdminPage.Execute(driver);
		ResourcePage resourcePage = new ResourcePage(driver);
		resourcePage.Execute();
		EmailServerPage emailServer = new EmailServerPage(driver);
		emailServer.Execute();
		emailServer.btn_Add();
		EmailServerAddPage addEmailServer = new EmailServerAddPage(driver);
		addEmailServer.txt_Hostname( configReader.getHostName());
		addEmailServer.txt_Username( configReader.getUsername());
		addEmailServer.txt_Password( configReader.getPassword());
		addEmailServer.btn_Save();
		
		Assert.assertEquals(emailServer.getButtonServer(), expectedResult, "The email server is not registered");
		logger.info("Close the Test: Email Server");
	}
	
	@AfterSuite
	public void tearDown() throws Exception {
	   HttpRequest.deleteServiceByName("Microsoft Exchange Server 2010 SP2");
	   driver.quit();
	}
}
